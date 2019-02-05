import javax.swing.*;
import java.util.ArrayList;

public class MainFrame extends JFrame{
    private static final String TITLE_NAME = "Restaurant Menu";
    private JMenuBar menu;
    private JPanel activePanel;
    private DBPanel DBPanel;
    private FormerPanel formerPanel;
    private RestaurantMenuPanel restaurantMenuPanel;
    private ArrayList<Product> allProoducts;
    private ArrayList<Product> menuProoducts;


    public ArrayList<Product> getMenuProoducts() {
        return menuProoducts;
    }

    public void setMenuProoducts(ArrayList<Product> menuProoducts) {
        this.menuProoducts = menuProoducts;
    }

    public ArrayList<Product> getAllProoducts() {
        return allProoducts;
    }

    public void setAllProoducts(ArrayList<Product> allProoducts) {
        this.allProoducts = allProoducts;
    }


    public void setDBPanel(DBPanel DBPanel) {
        this.DBPanel = DBPanel;
    }

    public void setFormerPanel(FormerPanel formerPanel) {
        this.formerPanel = formerPanel;
    }

    public void setRestaurantMenuPanel(RestaurantMenuPanel restaurantMenuPanel) {
        this.restaurantMenuPanel = restaurantMenuPanel;
    }

    public RestaurantMenuPanel getRestaurantMenuPanel() {
        return restaurantMenuPanel;
    }

    public FormerPanel getFormerPanel() {
        return this.formerPanel;
    }
    public JPanel getDBPanel() {
        return DBPanel;
    }

    public MainFrame(JPanel activePanel, ArrayList<Product> allProoducts, ArrayList<Product> menuProducts) {
        this.setTitle(TITLE_NAME);
        this.setSize(600,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainMenuBar menu = new MainMenuBar();
        this.allProoducts = allProoducts;
        this.menuProoducts = menuProducts;
        this.menu = menu;
        this.activePanel = activePanel;
        this.setJMenuBar(this.menu);
        this.add(this.activePanel);
        this.setVisible(true);
        this.pack();
    }
    public void changePanel(JPanel panel) {
        this.remove(this.activePanel);
        this.add(panel);
        this.activePanel = panel;
        this.pack();
    }
}
