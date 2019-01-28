import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;

public class DBPanel extends JPanel {
    private static final String ADD_ITEM_NAME = "ADD";
    private static final String REMOVE_ITEM_NAME = "REMOVE";
    private static final Object[] COL_NAMES = {
        "ID", "Name" , "Description", "Weight", "Price", "Rating"
    };
    public DBPanel(Object[][] cells) {
        TableModel model = new ProductsModel();

        JTable table = new JTable(model);

        JPopupMenu popupMenu = new JPopupMenu();

        JMenuItem menuItemAdd = new JMenuItem(ADD_ITEM_NAME);
        menuItemAdd.addActionListener((ActionEvent a) -> {
            cells[]
        });

        JMenuItem menuItemRemove = new JMenuItem(REMOVE_ITEM_NAME);
        popupMenu.add(menuItemAdd);
        popupMenu.add(menuItemRemove);
        table.setComponentPopupMenu(popupMenu);



        this.add(new JScrollPane(table));
    }
}
