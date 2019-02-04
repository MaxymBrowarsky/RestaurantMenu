import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;
import java.util.ArrayList;

public class RestaurantMenuPanel extends JPanel {
    private static final String SEARCH_LABEL = "Enter name";
    private static final String[] COL_NAMES = {
            "ID", "Name" , "Description", "Weight", "Price", "Rating"
    };
    private JTable productsTable;

    public JTable getProductsTable() {
        return this.productsTable;
    }

    public RestaurantMenuPanel(ArrayList<Product> products) {
        ProductsModel tableModel = new ProductsModel(products, COL_NAMES, false);
        JTable table = new JTable(tableModel);
        JLabel label = new JLabel(SEARCH_LABEL);
        JTextField textField = new JTextField();
        JScrollPane scrollPane = new JScrollPane(table);

        TableRowSorter<ProductsModel> rowSorter = new TableRowSorter<ProductsModel>((ProductsModel) table.getModel());
        textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = textField.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = textField.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });
        table.setRowSorter(rowSorter);


        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(scrollPane)
                .addGroup(layout.createSequentialGroup()
                .addComponent(label)
                .addComponent(textField)))
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(scrollPane)
                .addGroup(layout.createParallelGroup()
                .addComponent(label)
                .addComponent(textField))
        );


        this.productsTable = table;
    }
}
