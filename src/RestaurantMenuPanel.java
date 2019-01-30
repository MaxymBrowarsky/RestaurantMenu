import javax.swing.*;
import java.util.ArrayList;

public class RestaurantMenuPanel extends JPanel {
    private static final String[] COL_NAMES = {
            "ID", "Name" , "Description", "Weight", "Price", "Rating"
    };
    private JTable productsTable;

    public JTable getProductsTable() {
        return productsTable;
    }

    public RestaurantMenuPanel(ArrayList<Product> products) {
        ProductsModel tableModel = new ProductsModel(products, COL_NAMES);
        JTable table = new JTable(tableModel);
        this.add(new JScrollPane(table));
        this.productsTable = table;
    }
}
