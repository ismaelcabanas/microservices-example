package cabanas.garcia.ismael.msproduct.framework.repository;

import cabanas.garcia.ismael.msproduct.*;
import cabanas.garcia.ismael.msproduct.domain.model.Product;
import cabanas.garcia.ismael.msproduct.domain.repository.ProductRepository;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by ismaelcabanas on 19/6/17.
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {IntegrationTestContext.class}, properties = {"spring.cloud.config.enabled=false", "spring.cloud.bus.enabled=false", "spring.cloud.discovery.enabled=false"})
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class
})
@DatabaseSetup(value = "/datasets/empty-products.xml")
@DatabaseTearDown(value = "/datasets/empty-products.xml", type = DatabaseOperation.DELETE_ALL)
@DbUnitConfiguration(dataSetLoader = ReplacementDataSetLoader.class)
@ActiveProfiles(value = Profiles.DEV)
@Category(IntegrationTests.class)
public class CreateProductTest {

    @Autowired
    private ProductRepository repository;

    @Test
    public void should_persist_product(){
        // given
        Product raspberryPi = Product.ProductBuilder.builder()
                .withId(Products.RaspberryPi.ID)
                .withName(Products.RaspberryPi.NAME)
                .withWeight(Products.RaspberryPi.WEIGHT)
                .build();

        // when
        repository.create(raspberryPi);

        // then
        Product found = repository.findById(raspberryPi.getId()).get();

        assertThat(found.getId()).isEqualTo(Products.RaspberryPi.ID);
        assertThat(found.getName()).isEqualTo(Products.RaspberryPi.NAME);
        assertThat(found.getWeight()).isEqualTo(Products.RaspberryPi.WEIGHT);
    }

}
