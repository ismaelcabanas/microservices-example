package cabanas.garcia.ismael.msproduct.framework.repository;

import cabanas.garcia.ismael.msproduct.domain.model.Product;
import cabanas.garcia.ismael.msproduct.domain.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by ismaelcabanas on 19/6/17.
 */
public class PostgresProductRepository implements ProductRepository {

    private static final Logger LOG = LoggerFactory.getLogger(PostgresProductRepository.class);
    private static final String QUERY_FIND_BY_ID = String.format("SELECT ID, NAME, WEIGHT FROM PRODUCT WHERE ID=?");
    public static final String QUERY_INSERT = "INSERT INTO PRODUCT (ID, NAME, WEIGHT) VALUES (?,?,?)";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PostgresProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Product product) {
        LOG.debug("Creating product {}", product);

        this.jdbcTemplate.update(QUERY_INSERT, product.getId(), product.getName(), product.getWeight());

        LOG.info("Product {} created", product);
    }

    @Override
    public Optional<Product> findById(Long productId) {
        LOG.debug("Getting product with identifier {}", productId);

        Map<String, Object> params = new HashMap<>();
        params.put("id", productId);
        try {
            Product found = jdbcTemplate.queryForObject(QUERY_FIND_BY_ID,
                    new ProductRowMapper(), productId);
            LOG.info("Found product: {}", found);

            return Optional.of(found);
        }
        catch (EmptyResultDataAccessException ex) {
            LOG.info("No product found with id: {}", productId);
            return Optional.empty();
        }

    }
}
