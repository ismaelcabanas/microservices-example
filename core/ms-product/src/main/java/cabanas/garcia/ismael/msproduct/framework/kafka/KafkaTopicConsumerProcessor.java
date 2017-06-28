package cabanas.garcia.ismael.msproduct.framework.kafka;

import kafka.consumer.ConsumerConfig;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.message.MessageAndMetadata;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

class KafkaTopicConsumerProcessor {
  private static final Logger LOGGER = LoggerFactory.getLogger(KafkaTopicConsumerProcessor.class);

  private final ConsumerConnector consumerConnector;
  private final KafkaProducer<byte[], byte[]> hospitalityProducer;
  private final int threads;
  private final String topic;
  private final String groupId;
  private final ExecutorService executorService;

  KafkaTopicConsumerProcessor(Properties consumerProps, Properties hospitalityConsumerProps, int threads, String topic, String groupId) {
    Runtime.getRuntime().addShutdownHook(new Thread(this::gracefullyShutdown));

    this.consumerConnector = kafka.consumer.Consumer.createJavaConsumerConnector(new ConsumerConfig(consumerProps));
    this.hospitalityProducer = new KafkaProducer<>(hospitalityConsumerProps);
    this.threads = threads;
    this.topic = topic;
    this.groupId = groupId;
    this.executorService = Executors.newFixedThreadPool(threads);
  }

  public static Builder builder() {
    return new Builder();
  }

  private void start(Consumer<MessageAndMetadata<byte[], byte[]>> consumerCommand) {
    Map<String, List<KafkaStream<byte[], byte[]>>> messageStreams = consumerConnector.createMessageStreams(
        Collections.singletonMap(topic, threads)
    );

    for (Map.Entry<String, List<KafkaStream<byte[], byte[]>>> entry : messageStreams.entrySet()) {
      for (KafkaStream<byte[], byte[]> stream : entry.getValue()) {
        executorService.submit(() -> {
          for (MessageAndMetadata<byte[], byte[]> messageAndMetadata : stream) {
            try {
              consumerCommand.accept(messageAndMetadata);
            } catch(Exception e) {
              LOGGER.error("Cannot consumer message topic '" + topic + "' on consumer group '" + groupId + "'", e);

              sendHospitality(messageAndMetadata);
            }
          }
        });
      }
    }
  }

  private void sendHospitality(MessageAndMetadata<byte[], byte[]> messageAndMetadata) {
    String hospitalityTopic = String.format("%s-%s-hospitality", groupId, topic);
    ProducerRecord<byte[], byte[]> producerRecord = new ProducerRecord<>(hospitalityTopic, messageAndMetadata.key(), messageAndMetadata.message());

    hospitalityProducer.send(producerRecord, (metadata, exception) -> {
      if(exception != null) {
        LOGGER.error("Cannot send message to hospitality");
      }
    });
  }

  private void gracefullyShutdown() {
    LOGGER.info("Shutting down consumer '{}' of topic '{}'", groupId, topic);


    if(consumerConnector != null) {
      try {
        consumerConnector.shutdown();
      } catch (Exception e) {
        LOGGER.error("Cannot terminate gracefully consumer '" + groupId + "' on topic '" + topic + "'", e);
      }
    }

    if (executorService != null) {
      executorService.shutdown();
      try {
        executorService.awaitTermination(5, TimeUnit.MINUTES);
      } catch (Exception e) {
        LOGGER.error("Cannot terminate gracefully consumer threads", e);
      }
    }

    if(hospitalityProducer != null) {
      try {
        hospitalityProducer.close();
      } catch (Exception e) {
        LOGGER.error("Cannot shutdown gracefully hospitality producer of consumer '" + groupId + "' on topic '" + topic + "'", e);
      }
    }

    LOGGER.info("Shutdown consumer '{}' of topic '{}' complete", groupId, topic);
  }

  public static final class Builder {
    private int threads;
    private String topic;
    private String groupId;
    private Properties consumerProps;
    private Properties hospitalityProps;

    private Builder() {
    }

    public Builder threads(int threads) {
      this.threads = threads;
      return this;
    }

    public Builder topic(String topic) {
      this.topic = topic;
      return this;
    }

    public Builder groupId(String groupId) {
      this.groupId = groupId;
      return this;
    }

    public Builder consumerProps(Properties consumerProps) {
      this.consumerProps = consumerProps;
      return this;
    }

    public Builder hospitalityProps(Properties hospitalityProps) {
      this.hospitalityProps = hospitalityProps;
      return this;
    }

    public void start(Consumer<MessageAndMetadata<byte[], byte[]>> consumerCommand) {
      new KafkaTopicConsumerProcessor(consumerProps, hospitalityProps, threads, topic, groupId).start(consumerCommand);
    }
  }
}
