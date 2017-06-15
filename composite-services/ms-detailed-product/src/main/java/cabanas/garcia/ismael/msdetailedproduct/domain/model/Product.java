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
}
