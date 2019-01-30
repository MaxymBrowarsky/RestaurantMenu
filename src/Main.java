import java.sql.SQLException;
import java.util.ArrayList;




public class Main {

    public static void main(String[] args) throws SQLException {

//        Object[][] cells = {{}};
//        DBPanel panel = new DBPanel(cells);
//        MainFrame mf = new MainFrame(panel);
          ArrayList<Product> products =  Connection.Select();
        DBPanel panel = new DBPanel(products);
        MainFrame mf = new MainFrame(panel);
//        DBPanel panel = new DBPanel();
//        MainFrame mf = new MainFrame(panel);


    }
}
