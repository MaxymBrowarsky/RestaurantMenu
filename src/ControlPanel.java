import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import static java.lang.System.exit;

public class ControlPanel extends JPanel{
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
        this.addButton = new JButton(">>");
        this.addAllButton = new JButton("<<");
        this.deleteButton = new JButton(">>>>");
        this.deleteAllButton = new JButton("<<<<");
        this.saveButton = new JButton("Save");
        initButtons();
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
            this.menuTable.remove(rowIndex);
        });
        addButton.addActionListener((ActionEvent e) -> {
            int rowIndex = this.productsTable.getSelectedRow();
            restaurantMenu.add(products.get(rowIndex));
            ProductsModel productsModel = (ProductsModel) menuTable.getModel();

            productsModel.fireTableDataChanged();
        });
        deleteAllButton.addActionListener((ActionEvent e) -> {
            this.menuTable.removeAll();
            this.restaurantMenu.clear();
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
            restaurantMenu.clear();
            for (Product p : products) {
                try {
                    restaurantMenu.add(p.clone());

                } catch (Exception exp) {
                    exit(1);
                }
            }
            ProductsModel productsModel = (ProductsModel) menuTable.getModel();
            productsModel.fireTableDataChanged();
        });

    }
}
