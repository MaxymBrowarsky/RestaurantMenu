import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainMenuBar extends JMenuBar {
    private static final String DBMenu_NAME = "DBMenu";
    private static final String HELP_MENU_NAME = "Help";
    private static final String MENU_FORMER_NAME = "Menu Former";
    private static final String PRODUCTS_ITEM_NAME = "Products";
    private static final String HELP_ITEM_NAME = "Open docs";
    public static final String OPEN_MENU_ITEM_NAME = "Open file with menu";
    public MainMenuBar() {
        JMenu DBMenu = new JMenu(DBMenu_NAME);
        JMenu HelpMenu = new JMenu(HELP_MENU_NAME);
        JMenu MenuFormer = new JMenu(MENU_FORMER_NAME);
        this.formDBMenu(DBMenu);
        JMenuItem helpItem = new JMenuItem(HELP_ITEM_NAME);
        helpItem.addActionListener((ActionEvent a) -> {
            try {
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(new File("D:\\help.docx"));
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        });
        HelpMenu.add(helpItem);
        MenuFormer.addActionListener((ActionEvent a) -> {
            MainFrame frame = (MainFrame) getTopLevelAncestor();
            frame.changePanel(frame.getFormerPanel());
            
        });
        JMenuItem openMenu = new JMenuItem(OPEN_MENU_ITEM_NAME);
        openMenu.addActionListener((ActionEvent e) -> {
            File file = new File("./menus/current.xml");
            XMLHandler xmlHandler = new XMLHandler();
            ArrayList<Product> products = new ArrayList<>();
            products = xmlHandler.deserialize(file);
            RestaurantMenuPanel menuPanel  = new RestaurantMenuPanel(products);
            MainFrame frame = (MainFrame) getTopLevelAncestor();
            frame.changePanel(menuPanel);
            frame.setRestaurantMenuPanel(menuPanel);
        });
        this.add(MenuFormer);
        this.add(DBMenu);
        this.add(HelpMenu);


    }
    private JMenu formDBMenu(JMenu menu) {
        JMenuItem products = new JMenuItem(PRODUCTS_ITEM_NAME);
        products.addActionListener((ActionEvent action) -> {
            MainFrame frame = (MainFrame) getTopLevelAncestor();
            frame.changePanel(frame.getDBPanel());
        });
        menu.add(products);
        return menu;
    }

}
