package cabanas.garcia.ismael.msproduct.framework.repository;

import cabanas.garcia.ismael.msproduct.IntegrationTests;
import cabanas.garcia.ismael.msproduct.domain.model.Product;
import cabanas.garcia.ismael.msproduct.domain.repository.ProductRepository;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;


/**
 * Created by ismaelcabanas on 19/6/17.
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
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class
})
@Category(IntegrationTests.class)
public class PostgresProductRepositoryTests {

    @Autowired
    private ProductRepository repository;

    @Test
    public void should_create_product(){
        // given
        Product randomProduct = getRandomProduct();

        // when
        repository.create(randomProduct);

        // then


    }

    private Product getRandomProduct() {
        return null;
    }

}
