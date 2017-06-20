package cabanas.garcia.ismael.msproduct.framework.repository;

import cabanas.garcia.ismael.msproduct.IntegrationTests;
import cabanas.garcia.ismael.msproduct.domain.model.Product;
import cabanas.garcia.ismael.msproduct.domain.repository.ProductRepository;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by ismaelcabanas on 19/6/17.
 */
//@Category(IntegrationTests.class)
@RunWith(SpringRunner.class)
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
