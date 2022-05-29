package SalesInvoicesGen.model;

import javax.swing.table.AbstractTableModel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;


    public class InvoiceHeaderJtableModel extends AbstractTableModel {
        private List<InvoiceHeader> invoicesItemsArray;
        private DateFormat dateFt = new SimpleDateFormat("dd-MM-yyyy");

        public InvoiceHeaderJtableModel(List<InvoiceHeader> invoicesItemsArray) {
            this.invoicesItemsArray = invoicesItemsArray;
        }

        public List<InvoiceHeader> getInvoicesItemsArray() {
            return this.invoicesItemsArray;
        }

        public int getRowCount() {
            return this.invoicesItemsArray.size();
        }

        public int getColumnCount() {
            return 4;
        }

        public String getColumnName(int columnIndex) {
            switch(columnIndex) {
                case 0:
                    return "Item Name";
                case 1:
                    return "Item Price";
                case 2:
                    return "Item Count";
                case 3:
                    return "Items Total";
                default:
                    return "";
            }
        }

        public Class<?> getColumnClass(int columnIndex) {
            switch(columnIndex) {
                case 0:
                    return String.class;
                case 1:
                    return Double.class;
                case 2:
                    return Integer.class;
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
            InvoiceHeader row = (InvoiceHeader)this.invoicesItemsArray.get(rowIndex);
            switch(columnIndex) {
                case 0:
                    return row.getItemName();
                case 1:
                    return row.getItemPrice();
                case 2:
                    return row.getItemCount();
                case 3:
                    return row.getLineTotal();
                default:
                    return "";
            }
        }
    }


