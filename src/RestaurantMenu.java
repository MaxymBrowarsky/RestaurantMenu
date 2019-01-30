import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "RestaurantMenu")
public class RestaurantMenu {
    ArrayList<Product> products;
    public ArrayList<Product> getRestaurantMenu() {
        return products;
    }
    @XmlElement(name = "Product")
    public void setRestaurantMenu(ArrayList<Product> products) {
        this.products = products;
    }
    public void add(Product product) {
        if (this.products == null) {
            this.products = new ArrayList<Product>();
        }
        this.products.add(product);
    }
}
