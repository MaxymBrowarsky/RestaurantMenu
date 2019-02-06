import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;




public class Main {

    public static void main(String[] args) throws SQLException, IOException {


//        ArrayList<Product> products =  Connection.Select();
//        XMLHandler xmlHandler = new XMLHandler();
//        RestaurantMenu menu = new RestaurantMenu();
//        menu.setRestaurantMenu(products);
//        String content = xmlHandler.serialize(menu);
//        System.out.println(content);
//        File file = new File("d:/1.xml");
//
//        Writer writer = new FileWriter(file);
//        BufferedWriter bufferedWriter = new BufferedWriter(writer);
//        bufferedWriter.write(content);
//        bufferedWriter.close();
//        File file2 = new File("d:/1.xml");
//
//        ArrayList<Product> p2 = new ArrayList<Product>();
//        p2 = xmlHandler.deserialize(file2);
//        System.out.println(p2);
//        DBPanel panel = new DBPanel(products);
//        MainFrame mf = new MainFrame(panel);
//        DBPanel panel = new DBPanel();
//        MainFrame mf = new MainFrame(panel);
        Product p1 = new Product(1, "afd" , "fad", 2, 3, 4);
        Product p2 = new Product(2, "afd" , "fad", 2, 3, 4);
        Product p3 = new Product(3, "afd" , "fad", 2, 3, 4);
        Product p4 = new Product(4, "afd" , "fad", 2, 3, 4);
        Product p5 = new Product(15, "afd" , "fad", 2, 3, 4);
        ArrayList<Product> menu = new ArrayList<>();
        menu.add(p1);
        menu.add(p2);
        ArrayList<Product> products = new ArrayList<>();
        products.add(p3);
        products.add(p4);
        products.add(p5);
        RestaurantMenuPanel menuPanel = new RestaurantMenuPanel(menu);
        MainFrame frame = new MainFrame(menuPanel, products, menu);
        DBPanel dbPanel = new DBPanel(products);
        frame.setDBPanel(dbPanel);
        frame.setRestaurantMenuPanel(menuPanel);

    }
}
