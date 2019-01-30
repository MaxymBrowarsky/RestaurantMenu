import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

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
    public ControlPanel() {
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
        addAllButton.addActionListener((ActionEvent e) -> {
            restaurantMenu.clear();
            for (Product p : products) {
                restaurantMenu.add(p.clone());
            }
            ProductsModel productsModel = (ProductsModel) menuTable.getModel();
            productsModel.fireTableDataChanged();
        });
        saveButton.addActionListener((ActionEvent e) -> {

        });
    }
}
