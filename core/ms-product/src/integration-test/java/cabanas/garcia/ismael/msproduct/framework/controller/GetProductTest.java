package cabanas.garcia.ismael.msproduct.framework.controller;

import cabanas.garcia.ismael.msproduct.IntegrationTestContext;
import cabanas.garcia.ismael.msproduct.IntegrationTests;
import cabanas.garcia.ismael.msproduct.Products;
import cabanas.garcia.ismael.msproduct.ReplacementDataSetLoader;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.ServletTestExecutionListener;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by ismaelcabanas on 21/6/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {IntegrationTestContext.class}, properties = {"spring.cloud.config.enabled=false", "spring.cloud.bus.enabled=false", "spring.cloud.discovery.enabled=false"})
@AutoConfigureMockMvc
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class,
        ServletTestExecutionListener.class
})
@DatabaseSetup(value = "/datasets/products.xml")
@DatabaseTearDown(value = "/datasets/products.xml", type = DatabaseOperation.DELETE_ALL)
@DbUnitConfiguration(dataSetLoader = ReplacementDataSetLoader.class)
@Category(IntegrationTests.class)
public class GetProductTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void should_return_http_status_code_ok() throws Exception {
        // given

        // when
        ResultActions result = findProduct(Products.RaspberryPi.ID);

        // then
        result.andExpect(status().isOk());
    }

    @Test
    public void should_return_http_status_code_not_found() throws Exception {
        // given

        // when
        ResultActions result = findProduct(Products.UNKNOWN_PRODUCT_ID);

        // then
        result.andExpect(status().isNotFound());
    }

    @Test
    public void should_return_product_as_json() throws Exception{
        // given

        // when
        ResultActions result = findProduct(Products.RaspberryPi.ID);

        // then
        result.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }

    @Test
    public void should_return_information_of_product_found() throws Exception{
        // given

        // when
        ResultActions result = findProduct(Products.RaspberryPi.ID);

        // then
        result.andExpect(jsonPath("$.id", is(equalTo(Products.RaspberryPi.ID.intValue()))))
                .andExpect(jsonPath("$.name", is(equalTo(Products.RaspberryPi.NAME))))
                .andExpect(jsonPath("$.weight", is(equalTo(Products.RaspberryPi.WEIGHT))));
    }

    private ResultActions findProduct(Long productId) throws Exception {
        return mockMvc.perform(get("/products/{id}", productId));
    }
}
