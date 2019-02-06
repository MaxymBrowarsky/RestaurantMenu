import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;
import java.util.ArrayList;

public class ProductsModel extends AbstractTableModel {
    private int columnCount;
    private int rowCount = 10;

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    private ArrayList<Product> products;
    private String[] colNames;
    private boolean editable;
    public ProductsModel(ArrayList<Product> _products, String[] colNames, boolean editable) {
        this.products = _products;
        this.columnCount = colNames.length;
        this.rowCount = _products.size();
        this.colNames = colNames;
        this.editable = editable;
    }



    @Override
    public int getRowCount() {
        return this.products.size();
    }

    @Override
    public int getColumnCount() {
        return this.columnCount;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object temp = null;
        switch(columnIndex) {
            case 0: temp = this.products.get(rowIndex).getId(); break;
            case 1: temp = this.products.get(rowIndex).getName(); break;
            case 2: temp = this.products.get(rowIndex).getDescription(); break;
            case 3: temp = this.products.get(rowIndex).getWeight(); break;
            case 4: temp = this.products.get(rowIndex).getPrice(); break;
            case 5: temp = this.products.get(rowIndex).getRating(); break;
        }
        return temp;
    }

    @Override
    public String getColumnName(int column) {
        return colNames[column];

    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex != 0) {
            return editable;
        }
        return false;

    }

    @Override
    public void fireTableDataChanged() {
        super.fireTableDataChanged();
    }
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {


        System.out.println(aValue);
        //super.setValueAt(aValue, rowIndex, columnIndex);
        switch(columnIndex) {
            case 0: this.products.get(rowIndex).setId(Integer.parseInt( aValue.toString())); break;
            case 1: this.products.get(rowIndex).setName(aValue.toString()); break;
            case 2: this.products.get(rowIndex).setDescription(aValue.toString()); break;
            case 3: this.products.get(rowIndex).setWeight(Integer.parseInt( aValue.toString())); break;
            case 4: this.products.get(rowIndex).setPrice(Integer.parseInt( aValue.toString())); break;
            case 5: this.products.get(rowIndex).setRating(Integer.parseInt( aValue.toString())); break;
        }
        products.get(rowIndex).update();


    }
    public void deleteRow(int index, ArrayList<Product> anotherList, JTable anotherTable) {
        Product product = this.products.remove(index);
        if (!anotherList.contains(product)) {
            ProductsModel pm = (ProductsModel) anotherTable.getModel();

            TableRowSorter<ProductsModel> rowSorter = (TableRowSorter<ProductsModel>) anotherTable.getRowSorter();
            pm.addRow(anotherList.size(),product, rowSorter);
        }
        fireTableRowsDeleted(index, index);


    }
    public void addRow(int index, Product product, TableRowSorter<ProductsModel> sorter) {
        this.products.add(product);
        this.fireTableDataChanged();
    }


}
