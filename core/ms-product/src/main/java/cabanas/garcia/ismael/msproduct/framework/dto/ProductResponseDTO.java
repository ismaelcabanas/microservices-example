package cabanas.garcia.ismael.msproduct.framework.dto;

/**
 * Created by ismaelcabanas on 13/6/17.
 */
public class ProductResponseDTO {
    private int id;
    private String name;
    private int weight;


    public static final class ProductResponseDTOBuilder {
        private int id;
        private String name;
        private int weight;

        private ProductResponseDTOBuilder() {
        }

        public static ProductResponseDTOBuilder aProductResponseDTO() {
            return new ProductResponseDTOBuilder();
        }

        public ProductResponseDTOBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public ProductResponseDTOBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public ProductResponseDTOBuilder withWeight(int weight) {
            this.weight = weight;
            return this;
        }

        public ProductResponseDTO build() {
            ProductResponseDTO productResponseDTO = new ProductResponseDTO();
            productResponseDTO.weight = this.weight;
            productResponseDTO.name = this.name;
            productResponseDTO.id = this.id;
            return productResponseDTO;
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }
}
