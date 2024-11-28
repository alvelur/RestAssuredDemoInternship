package Session2.pojo;
import lombok.Data;
import java.util.List;

@Data
public class Cart {

    private int id;
    private List<Product> products;
    private double total;
    private double discountedTotal;
    private int userId;
    private int totalProducts;
    private int totalQuantity;

}
