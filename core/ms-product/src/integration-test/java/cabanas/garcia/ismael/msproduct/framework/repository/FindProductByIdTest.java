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

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by ismaelcabanas on 20/6/17.
 *
 * Listeners utilizados para la ejecución de tests:
 *
 * 1.- DependencyInjectionTestExecutionListener proporciona soporte para la inyección de dependencias e inicialización
 * de las instancias de test.
 *
 * 2.- TransactionalTestExecutionListener proporciona soporte para test gestionados por transacciones (@Transactional)
 *
 * 3.- DbUnitTestExecutionListener proporciona soporte para las features propoporcionadas por la librería Spring Test DBUnit
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {IntegrationTestContext.class}, properties = {"spring.cloud.config.enabled=false", "spring.cloud.bus.enabled=false", "spring.cloud.discovery.enabled=false"})
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class
})
@DatabaseSetup(value = "/datasets/products.xml")
@DatabaseTearDown(value = "/datasets/products.xml", type = DatabaseOperation.DELETE_ALL)
@DbUnitConfiguration(dataSetLoader = ReplacementDataSetLoader.class)
@ActiveProfiles(value = Profiles.DEV)
@Category(IntegrationTests.class)
public class FindProductByIdTest {

    @Autowired
    private ProductRepository sut;

    @Test
    public void should_return_optional_that_contains_found_product_when_product_is_found(){
        // given

        // when
        Optional<Product> actual = sut.findById(Products.RaspberryPi.ID);

        // then
        assertThat(actual.isPresent()).isTrue();
    }

    @Test
    public void should_return_correct_information_when_product_is_found(){
        // given

        // when
        Product actual = sut.findById(Products.RaspberryPi.ID).get();

        // then
        assertThat(actual.getId()).isEqualTo(Products.RaspberryPi.ID);
        assertThat(actual.getName()).isEqualTo(Products.RaspberryPi.NAME);
        assertThat(actual.getWeight()).isEqualTo(Products.RaspberryPi.WEIGHT);
    }

    @Test
    public void should_return_empty_optional_when_product_is_not_found(){
        // given

        // when
        Optional<Product> actual = sut.findById(Products.UNKNOWN_PRODUCT_ID);

        // then
        assertThat(actual.isPresent()).isFalse();
    }

}
