import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connection {

    static  String driver = "com.mysql.jdbc.Driver";
    static  String URL = "jdbc:mysql://127.0.0.1:3306/restaurantmenu?user=root&password=1111&useSSL=false";

    private static  java.sql.Connection conn;
    private static Statement statement;

    static {
        try {
            conn = DriverManager.getConnection(URL);
            statement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void Select() throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM products");
        while (resultSet.next()){

            System.out.println("qq"+resultSet.getInt(1)+resultSet.getString(2)+resultSet.getString(3)+
                    resultSet.getInt(4)+resultSet.getInt(5)+resultSet.getInt(6));
        }
    }

    public static void add(Product product) throws SQLException {

        statement.executeUpdate("insert into products(id,Name,Description,Weight,Price,Rating) value("+
                product.getId()+",\""+
                product.getName()+"\",\""+
                product.getDescription()+"\","+
                product.getWeight()+","+
                product.getPrice()+","+
                product.getRating()+")");
    }

    public static void delete(Integer id) throws SQLException {
        statement.execute("Delete from products where id = "+id+" ");
    }

    public static void update(Product product) throws SQLException {

        statement.executeUpdate("update products set " +
                "Name = \""+product.getName()+"\"," +
                "Description= \""+product.getDescription()+"\"," +
                "Weight = "+product.getWeight()+"," +
                "Price = "+product.getPrice()+"," +
                "Rating = "+product.getRating()+" " +
                "where id = "+product.getId()+";");
    }

    public static void Con() throws ParserConfigurationException, IOException, SQLException, ClassNotFoundException{
        try{
            statement.executeUpdate("");
            //code
//            statement.executeQuery("SELECT * FROM products");
//id
//            ResultSet resultSet = statement.executeQuery("SELECT max(id) FROM restaurantmenu.products");
//            int cur = 0;
//            while (resultSet.next()) {
//                cur = (resultSet.getInt(1)+1);
//            }


        }catch (Exception e){
        }

    }
}
