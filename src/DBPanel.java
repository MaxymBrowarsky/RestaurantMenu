import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class DBPanel extends JPanel {
    private static final String ADD_ITEM_NAME = "Додати";
    private static final String REMOVE_ITEM_NAME = "Видалити";
    private static final String[] COL_NAMES = {
        "ІД", "Назва" , "Опис", "Вага", "Ціна", "Рейтинг"
    };
    public DBPanel(ArrayList<Product> products) {
        TableModel model = new ProductsModel(products, COL_NAMES, true);

        JTable table = new JTable(model);

        JPopupMenu popupMenu = new JPopupMenu();

        JMenuItem menuItemAdd = new JMenuItem(ADD_ITEM_NAME);
        menuItemAdd.addActionListener((ActionEvent a) -> {
            AddingProductFrame addFrame = new AddingProductFrame();
        });

        JMenuItem menuItemRemove = new JMenuItem(REMOVE_ITEM_NAME);
        menuItemRemove.addActionListener((ActionEvent a) -> {
            int index = table.getSelectedRow();
            Product product = products.remove(index);
            product.delete();
        });
        popupMenu.add(menuItemAdd);
        popupMenu.add(menuItemRemove);
        table.setComponentPopupMenu(popupMenu);



        this.add(new JScrollPane(table));
    }
}
