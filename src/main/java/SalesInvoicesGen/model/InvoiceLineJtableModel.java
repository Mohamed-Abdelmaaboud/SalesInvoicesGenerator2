package SalesInvoicesGen.model;

import javax.swing.table.AbstractTableModel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class InvoiceLineJtableModel extends AbstractTableModel {
    private List<InvoiceLIne> invoicesTableArray;
    private DateFormat dateFt = new SimpleDateFormat("dd-MM-yyyy");

    public InvoiceLineJtableModel(List<InvoiceLIne> invoicesArray) {
        this.invoicesTableArray = invoicesArray;
    }

    public List<InvoiceLIne> getInvoicesTableArray() {
        return this.invoicesTableArray;
    }

    public int getRowCount() {
        return this.invoicesTableArray.size();
    }

    public int getColumnCount() {
        return 4;
    }

    public String getColumnName(int columnIndex) {
        switch(columnIndex) {
            case 0:
                return "Invoice Number";
            case 1:
                return "Customer Name";
            case 2:
                return "Invoice Date";
            case 3:
                return "Invoice Total";
            default:
                return "";
        }
    }

    public Class<?> getColumnClass(int columnIndex) {
        switch(columnIndex) {
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return Double.class;
            default:
                return Object.class;
        }
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceLIne row = (InvoiceLIne)this.invoicesTableArray.get(rowIndex);
        switch(columnIndex) {
            case 0:
                return row.getInvNum();
            case 1:
                return row.getCustomerName();
            case 2:
                return this.dateFt.format(row.getInvDate());
            case 3:
                return row.getInvTotal();
            default:
                return "";
        }
    }
}
