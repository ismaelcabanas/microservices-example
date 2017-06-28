package cabanas.garcia.ismael.msproduct.framework.configuration;

import cabanas.garcia.ismael.msproduct.domain.service.ProductService;
import cabanas.garcia.ismael.msproduct.domain.service.consumer.CreateProductConsumer;
import cabanas.garcia.ismael.msproduct.framework.kafka.KafkaProductConsumerProcessor;
import cabanas.garcia.ismael.msproduct.framework.kafka.KafkaCreateProductConsumer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ismaelcabanas on 22/6/17.
 */
@Configuration
public class KafkaConfiguration {

    @Value("${kafka.product.topic}")
    private String productTopic;

    @Value("${kafka.product.groupId}")
    private String productGroupId;

    @Value("${kafka.zookeeper.connect}")
    private String zookeperConnect;

    @Value("${kafka.bootstrap.servers}")
    private String kafkaBootstrapServers;

    @Value("${kafka.acks}")
    private String kafkaAcks;

    @Value("${kafka.retries}")
    private String kafkaRetries;

    @Bean
    public KafkaProductConsumerProcessor consumerProcessor() {
        return new KafkaProductConsumerProcessor(zookeperConnect, kafkaBootstrapServers, productGroupId);
    }

    @Bean
    public CreateProductConsumer createProductConsumer(ProductService productService, KafkaProductConsumerProcessor consumerProcessor) {
        return new KafkaCreateProductConsumer(productService, this.productTopic, this.zookeperConnect, 6, consumerProcessor);
    }

}
