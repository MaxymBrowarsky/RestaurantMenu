import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
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
    private static final String OPEN_MENU_ITEM_NAME = "Open file with menu";
    private static final String FORM_MENU_ITEM_NAME = "Form new menu";
    private static final String ADD_PRODUCT_ITEM_NAME = "Add new product";
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





//        MenuFormer.addActionListener((ActionEvent a) -> {
//            MainFrame frame = (MainFrame) getTopLevelAncestor();
//            frame.changePanel(frame.getFormerPanel());
//
//        });
        JMenuItem openMenu = new JMenuItem(OPEN_MENU_ITEM_NAME);
        openMenu.addActionListener((ActionEvent e) -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("."));
            fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            fileChooser.setFileFilter(new FileNameExtensionFilter("XML files", "xml"));
            fileChooser.showOpenDialog(null);
            File file = new File(fileChooser.getSelectedFile().getPath());
            XMLHandler xmlHandler = new XMLHandler();
            ArrayList<Product> products = xmlHandler.deserialize(file);
            RestaurantMenuPanel menuPanel  = new RestaurantMenuPanel(products);
            MainFrame frame = (MainFrame) getTopLevelAncestor();
            frame.changePanel(menuPanel);
            frame.setRestaurantMenuPanel(menuPanel);
        });
        JMenuItem formMenuItem = new JMenuItem(FORM_MENU_ITEM_NAME);
        formMenuItem.addActionListener((ActionEvent e) -> {

            MainFrame frame = (MainFrame) getTopLevelAncestor();
            RestaurantMenuPanel menuPanel = new RestaurantMenuPanel(frame.getMenuProoducts());
            RestaurantMenuPanel productsPanel = new RestaurantMenuPanel(frame.getAllProoducts());
            ControlPanel controlPanel = new ControlPanel(menuPanel.getProductsTable(),
                    productsPanel.getProductsTable(),
                    frame.getMenuProoducts(),
                    frame.getAllProoducts());

            FormerPanel formerPanel = new FormerPanel(menuPanel, controlPanel, productsPanel);
            frame.changePanel(formerPanel);
            frame.setFormerPanel(formerPanel);
        });
        MenuFormer.add(openMenu);
        MenuFormer.add(formMenuItem);


        this.add(MenuFormer);
        this.add(DBMenu);
        this.add(HelpMenu);


    }
    private JMenu formDBMenu(JMenu menu) {
        JMenuItem products = new JMenuItem(PRODUCTS_ITEM_NAME);
        JMenuItem addProduct = new JMenuItem(ADD_PRODUCT_ITEM_NAME);

        addProduct.addActionListener((ActionEvent action) -> {
            AddingProductFrame addingProductFrame = new AddingProductFrame();
        });
        products.addActionListener((ActionEvent action) -> {
            MainFrame frame = (MainFrame) getTopLevelAncestor();
            frame.changePanel(frame.getDBPanel());
        });
        menu.add(products);

        return menu;
    }

}
