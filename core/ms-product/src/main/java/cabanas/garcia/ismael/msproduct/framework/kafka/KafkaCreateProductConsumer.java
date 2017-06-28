package cabanas.garcia.ismael.msproduct.framework.kafka;

import cabanas.garcia.ismael.msproduct.domain.model.Product;
import cabanas.garcia.ismael.msproduct.domain.service.ProductService;
import cabanas.garcia.ismael.msproduct.domain.service.consumer.CreateProductConsumer;
import com.fasterxml.jackson.databind.ObjectMapper;
import kafka.message.MessageAndMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.io.IOException;

/**
 * Created by ismaelcabanas on 22/6/17.
 */
public class KafkaCreateProductConsumer implements CreateProductConsumer {

    private static final Logger log = LoggerFactory.getLogger(KafkaProductConsumerProcessor.class);

    private ProductService productService;
    private final int numThreads;
    private final KafkaProductConsumerProcessor consumerProcessor;
    private ObjectMapper om;
    private final String topic;

    public KafkaCreateProductConsumer(ProductService productService, String productTopic, String zookeperConnect, int numThreads, KafkaProductConsumerProcessor consumerProcessor) {
        this.topic = productTopic;
        this.productService = productService;
        this.numThreads = numThreads;
        this.consumerProcessor = consumerProcessor;
        this.om = new ObjectMapper();
    }

    @EventListener(ApplicationReadyEvent.class)
    private void start() {
        log.info("Starting CreateProductConsumer...");
        consumerProcessor.start(topic, numThreads, this::manageMessage);
    }

    private void manageMessage(MessageAndMetadata<byte[], byte[]> messageAndMetadata) {
        try {
            Product product = om.readValue(messageAndMetadata.message(), Product.class);
            this.productService.saveProduct(product);
        } catch (IOException e) {
            throw new RuntimeException("Error reading json data", e);
        }

    }

}
