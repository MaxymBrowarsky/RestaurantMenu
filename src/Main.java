import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;




public class Main {
    private static final String CURRENT_MENU = "menus/current_menu.xml";
    public static void main(String[] args) throws SQLException, IOException {


        ArrayList<Product> products =  Connection.Select();

        XMLHandler xmlHandler = new XMLHandler();
        File currentMenuFile = new File(CURRENT_MENU);
        ArrayList<Product> menu = xmlHandler.deserialize(currentMenuFile);


        RestaurantMenuPanel menuPanel = new RestaurantMenuPanel(menu);
        MainFrame frame = new MainFrame(menuPanel, products, menu);
        DBPanel dbPanel = new DBPanel(products);
        frame.setDBPanel(dbPanel);
        frame.setRestaurantMenuPanel(menuPanel);

    }
}
