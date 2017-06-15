package cabanas.garcia.ismael.msdetailedproduct.domain.model;

/**
 * Created by ismaelcabanas on 14/6/17.
 */
public class Product {
    private int id;
    private String name;
    private int weight;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }

    public static final class ProductBuilder {
        private int id;
        private String name;
        private int weight;

        private ProductBuilder() {
        }

        public static ProductBuilder builder() {
            return new ProductBuilder();
        }

        public ProductBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public ProductBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public ProductBuilder withWeight(int weight) {
            this.weight = weight;
            return this;
        }

        public Product build() {
            Product product = new Product();
            product.id = this.id;
            product.weight = this.weight;
            product.name = this.name;
            return product;
        }
    }
}
