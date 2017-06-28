package cabanas.garcia.ismael.msproduct.framework.kafka;

import cabanas.garcia.ismael.msproduct.*;
import cabanas.garcia.ismael.msproduct.domain.model.Product;
import cabanas.garcia.ismael.msproduct.domain.repository.ProductRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.server.KafkaConfig;
import kafka.server.KafkaServerStartable;
import org.apache.curator.test.TestingServer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import java.io.IOException;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

/**
 * Created by ismaelcabanas on 22/6/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {IntegrationTestContext.class}, properties = {"spring.cloud.config.enabled=false", "spring.cloud.bus.enabled=false", "spring.cloud.discovery.enabled=false"})
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class
})
@ActiveProfiles(value = Profiles.DEV)
@Category(IntegrationTests.class)
public class CreateConsumerProductTest {

    private static final String BOOTSTRAP_SERVERS = "bootstrap.servers";
    private static final String ACKS = "acks";
    private static final String RETRIES = "retries";

    @Value("${kafka.bootstrap.servers}")
    private String kafkaBootstrapServers;

    @Value("${kafka.acks}")
    private String kafkaAcks;

    @Value("${kafka.retries}")
    private String kafkaRetries;

    @Value("${kafka.product.topic}")
    private String topic;

    private ObjectMapper objectMapper = new ObjectMapper();

    private Producer producer;
    private ConsumerConnector consumerConnector;

    @Autowired
    private ProductRepository productRepository;
    private KafkaTestFixture server;

    @Before
    public void setUp() throws Exception{
        /*
        this.producer = new KafkaProducer<>(1ImmutableMap.<String, Object>builder()
                .put(BOOTSTRAP_SERVERS, "192.168.99.100:9092")
                .put(ACKS, "all")
                .put(RETRIES, 0)
                //.put("batch.size", String.valueOf(1000000))
                //.put("linger.ms", "500")
                .put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName())
                .put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName())
                .build());
        */
        this.producer = new KafkaProducer(producerProperties());

        server = new KafkaTestFixture();
        server.start(serverProperties());
    }

    @Test
    public void should_consume_a_product_message_when_system_produces_an_event(){
        // given
        Product raspberryPi = Product.ProductBuilder.builder()
                .withId(Products.RaspberryPi.ID)
                .withName(Products.RaspberryPi.NAME)
                .withWeight(Products.RaspberryPi.WEIGHT)
                .build();

        // when
        sendEvent(raspberryPi);

        // then

    }

    private Properties serverProperties() {
        Properties props = new Properties();
        props.put("zookeeper.connect", "localhost:2181");
        props.put("broker.id", "1");
        return props;
    }

    private Properties producerProperties() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("request.required.acks", "1");
        return props;
    }


    private void sendEvent(Product product) {
        try {
            String uuid = UUID.randomUUID().toString();
            ProducerRecord<String, String> message = buildMessage(uuid, this.objectMapper.writeValueAsString(product));
            producer.send(message).get();
        } catch(ExecutionException | InterruptedException e) {
            throw new RuntimeException("Error sending event to Kafka", e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error serializing pokemon to json", e);
        }

    }

    private ProducerRecord<String, String> buildMessage(String key, Object msg) {
        return new ProducerRecord<>("pub-create-product", key, msg.toString());
    }

    private static class KafkaTestFixture {
        private TestingServer zk;
        private KafkaServerStartable kafka;

        public void start(Properties properties) throws Exception {
            Integer port = getZkPort(properties);
            zk = new TestingServer(port);
            zk.start();

            KafkaConfig kafkaConfig = new KafkaConfig(properties);
            kafka = new KafkaServerStartable(kafkaConfig);
            kafka.startup();
        }

        public void stop() throws IOException {
            kafka.shutdown();
            zk.stop();
            zk.close();
        }

        private int getZkPort(Properties properties) {
            String url = (String) properties.get("zookeeper.connect");
            String port = url.split(":")[1];
            return Integer.valueOf(port);
        }
    }
}
