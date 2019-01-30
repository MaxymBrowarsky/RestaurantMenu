import javax.swing.*;
import java.awt.event.ActionEvent;

public class ControlPanel {
    private JButton deleteButton;
    private JButton addButton;
    private JButton deleteAllButton;
    private JButton AddAllButton;
    private JTable menuTable;
    private JTable productsTable;
    public ControlPanel() {

    }
    private void initButtons() {
        deleteButton.addActionListener((ActionEvent e) -> {
            int rowIndex = this.menuTable.getSelectedRow();
            this.menuTable.remove(rowIndex);
            //TODO: update data structeres

        });
        
    }
}
