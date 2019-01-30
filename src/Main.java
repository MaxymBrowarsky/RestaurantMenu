import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;




public class Main {

    public static void main(String[] args) throws SQLException, IOException {

//        Object[][] cells = {{}};
//        DBPanel panel = new DBPanel(cells);
//        MainFrame mf = new MainFrame(panel);
        ArrayList<Product> products =  Connection.Select();
        XMLHandler xmlHandler = new XMLHandler();
        RestaurantMenu menu = new RestaurantMenu();
        menu.setRestaurantMenu(products);
        String content = xmlHandler.serialize(menu);
        System.out.println(content);
        File file = new File("d:/1.xml");

        Writer writer = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        bufferedWriter.write(content);
        bufferedWriter.close();
        File file2 = new File("d:/1.xml");

        ArrayList<Product> p2 = new ArrayList<Product>();
        p2 = xmlHandler.deserialize(file2);
        System.out.println(p2);
//        DBPanel panel = new DBPanel(products);
//        MainFrame mf = new MainFrame(panel);
//        DBPanel panel = new DBPanel();
//        MainFrame mf = new MainFrame(panel);


    }
}
