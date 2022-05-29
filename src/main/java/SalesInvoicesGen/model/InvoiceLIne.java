package SalesInvoicesGen.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;


    public class InvoiceLIne {
        private int invNum;
        private String customerName;
        private Date invDate;
        private ArrayList<InvoiceHeader> lines;
        private DateFormat dateFt = new SimpleDateFormat("dd-MM-yyyy");

        public InvoiceLIne(int invNum, String customerName, Date invDate) {
            this.invNum = invNum;
            this.customerName = customerName;
            this.invDate = invDate;
            this.lines = new ArrayList();
        }

        public int getInvNum() {
            return this.invNum;
        }

        public void setInvNum(int invNum) {
            this.invNum = invNum;
        }

        public String getCustomerName() {
            return this.customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }

        public Date getInvDate() {
            return this.invDate;
        }

        public void setInvDate(Date invDate) {
            this.invDate = invDate;
        }

        public String toString() {
            return "InvoicesTable{invNum=" + this.invNum + ", customerName=" + this.customerName + ", invDate=" + this.invDate + '}';
        }

        public ArrayList<InvoiceHeader> getLines() {
            return this.lines;
        }

        public void setLines(ArrayList<InvoiceHeader> lines) {
            if (lines == null) {
                lines = new ArrayList();
            }

            this.lines = lines;
        }

        public double getInvTotal() {
            double total = 0.0D;

            InvoiceHeader line;
            for(Iterator var3 = this.getLines().iterator(); var3.hasNext(); total += line.getLineTotal()) {
                line = (InvoiceHeader)var3.next();
            }

            return total;
        }

        public void addInvLine(InvoiceHeader line) {
            this.getLines().add(line);
        }

        public String getFileAsExcel() {
            return "" + this.getInvNum() + "," + this.dateFt.format(this.getInvDate()) + "," + this.getCustomerName();
        }
    }


