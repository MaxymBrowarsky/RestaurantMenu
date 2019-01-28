import javax.swing.table.AbstractTableModel;

public class ProductsModel extends AbstractTableModel {
    private int columnCount;
    private int rowCount = 10;
    private Product[] products;
    @Override
    public int getRowCount() {
        return this.rowCount;
    }

    @Override
    public int getColumnCount() {
        return this.columnCount;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        super.setValueAt(aValue, rowIndex, columnIndex);
        products[rowIndex].update();
    }
}
