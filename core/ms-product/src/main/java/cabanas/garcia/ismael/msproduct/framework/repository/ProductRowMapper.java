package cabanas.garcia.ismael.msproduct.framework.repository;

import cabanas.garcia.ismael.msproduct.domain.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by ismaelcabanas on 20/6/17.
 */
public class ProductRowMapper implements RowMapper<Product>{
    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        String name = rs.getString("NAME");
        Long id = rs.getLong("ID");
        int weight = rs.getInt("WEIGHT");
        return Product.ProductBuilder.builder().withId(id).withName(name).withWeight(weight).build();
    }
}
