import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import static java.lang.System.exit;

public class ControlPanel extends JPanel{
    private static final String ADD_BUTTON_NAME = "<<";
    private static final String ADD_ALL_BUTTON_NAME = "<<<<";
    private static final String DELETE_BUTTON_NAME = ">>";
    private static final String DELETE_ALL_BUTTON_NAME = ">>>>";
    private static final String SAVE_BUTTON_NAME = "Save";
    private JButton deleteButton;
    private JButton addButton;
    private JButton deleteAllButton;
    private JButton addAllButton;
    private JButton saveButton;
    private JTable menuTable;
    private JTable productsTable;
    private ArrayList<Product> restaurantMenu;
    private ArrayList<Product> products;
    public ControlPanel(JTable menuTable, JTable productsTable, ArrayList<Product> allProoducts, ArrayList<Product> menuProducts) {
        this.addButton = new JButton(ADD_BUTTON_NAME);
        this.addAllButton = new JButton(ADD_ALL_BUTTON_NAME);
        this.deleteButton = new JButton(DELETE_BUTTON_NAME);
        this.deleteAllButton = new JButton(DELETE_ALL_BUTTON_NAME);
        this.saveButton = new JButton(SAVE_BUTTON_NAME);
        initButtons();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(addButton);
        this.add(addAllButton);
        this.add(deleteButton);
        this.add(deleteAllButton);
        this.add(saveButton);
        this.menuTable = menuTable;
        this.productsTable = productsTable;
        this.restaurantMenu = menuProducts;
        this.products = allProoducts;


    }
    private void initButtons() {
        deleteButton.addActionListener((ActionEvent e) -> {
            int rowIndex = this.menuTable.getSelectedRow();
            ProductsModel productsModel = (ProductsModel) this.menuTable.getModel();
            productsModel.deleteRow(rowIndex, rowIndex, this.products, this.productsTable);
        });
        addButton.addActionListener((ActionEvent e) -> {
            int rowIndex = this.productsTable.getSelectedRow();
            ProductsModel productsModel = (ProductsModel) this.productsTable.getModel();
            productsModel.deleteRow(rowIndex, rowIndex, this.restaurantMenu, this.menuTable);
        });
        deleteAllButton.addActionListener((ActionEvent e) -> {
            ProductsModel productsModel = (ProductsModel) this.productsTable.getModel();
            productsModel.deleteRow(0, this.products.size(), this.restaurantMenu, this.menuTable);
        });
        saveButton.addActionListener((ActionEvent e) -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("."));
            fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            fileChooser.setFileFilter(new FileNameExtensionFilter("XML files", "xml"));
            fileChooser.showOpenDialog(null);
            XMLHandler xmlHandler = new XMLHandler();
            FileHandler fh = new FileHandler();
            RestaurantMenu rMenu = new RestaurantMenu();
            rMenu.setRestaurantMenu(restaurantMenu);
            fh.saveToFile(fileChooser.getSelectedFile().getPath(), xmlHandler.serialize(rMenu));
        });
        addAllButton.addActionListener((ActionEvent e) -> {
            ProductsModel productsModel = (ProductsModel) this.menuTable.getModel();
            productsModel.deleteRow(0, this.restaurantMenu.size(), this.products, this.productsTable);
        });
        deleteButton.setSize(new Dimension(100,20));
        deleteAllButton.setSize(new Dimension(100,20));
        addButton.setSize(new Dimension(100,20));
        addAllButton.setSize(new Dimension(100,20));
        saveButton.setSize(new Dimension(100,20));
    }
}
