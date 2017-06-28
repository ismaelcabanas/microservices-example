package cabanas.garcia.ismael.msproduct.framework.kafka;

import com.google.common.collect.ImmutableMap;
import kafka.message.MessageAndMetadata;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.ByteArraySerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * Created by ismaelcabanas on 22/6/17.
 */
public class KafkaProductConsumerProcessor {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProductConsumerProcessor.class);

    private static final String ZOOKEEPER_CONNECT = "zookeeper.connect";
    private static final String GROUP_ID = "group.id";

    private final String groupId;
    private final Properties consumerProps;
    private final Properties hospitalityProps;

    public KafkaProductConsumerProcessor(String zookeeperConnect, String kafkaHost, String groupId) {
        consumerProps = new Properties();
        consumerProps.putAll(ImmutableMap.builder()
                .put(ZOOKEEPER_CONNECT, zookeeperConnect)
                .put(GROUP_ID, groupId)
                .put("auto.offset.reset", "smallest")
                .build()
        );

        hospitalityProps = new Properties();
        hospitalityProps.putAll(ImmutableMap.builder()
                .put("bootstrap.servers", kafkaHost)
                .put("acks", "all")
                .put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, ByteArraySerializer.class.getName())
                .put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, ByteArraySerializer.class.getName())
                .put("retries", String.valueOf(Integer.MAX_VALUE))
                .build()
        );

        this.groupId = groupId;
    }

    public void start(String topic, int numStreams, java.util.function.Consumer<MessageAndMetadata<byte[], byte[]>> consumerCommand) {
        KafkaTopicConsumerProcessor.builder()
                .consumerProps(consumerProps)
                .hospitalityProps(hospitalityProps)
                .threads(numStreams)
                .topic(topic)
                .groupId(groupId)
                .start(consumerCommand);
    }
}
