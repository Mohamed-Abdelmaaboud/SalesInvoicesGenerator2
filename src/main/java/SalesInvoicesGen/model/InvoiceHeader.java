package SalesInvoicesGen.model;


    public class InvoiceHeader {
        private String itemName;
        private double itemPrice;
        private int itemCount;
        private InvoiceLIne invTableHeader;

        public InvoiceHeader(String itemName, double itemPrice, int itemCount, InvoiceLIne invTableHeader) {
            this.itemName = itemName;
            this.itemPrice = itemPrice;
            this.itemCount = itemCount;
            this.invTableHeader = invTableHeader;
        }

        public String getItemName() {
            return this.itemName;
        }

        public void setItemName(String itemName) {
            this.itemName = itemName;
        }

        public double getItemPrice() {
            return this.itemPrice;
        }

        public void setItemPrice(double itemPrice) {
            this.itemPrice = itemPrice;
        }

        public int getItemCount() {
            return this.itemCount;
        }

        public void setItemCount(int itemCount) {
            this.itemCount = itemCount;
        }

        public InvoiceLIne getInvoicesTableHeader() {
            return this.invTableHeader;
        }

        public void setInvoicesTableHeader(InvoiceLIne header) {
            this.invTableHeader = header;
        }

        public String toString() {
            return "InvoicesItems{itemName=" + this.itemName + ", itemPrice=" + this.itemPrice + ", itemCount=" + this.itemCount + '}';
        }

        public double getLineTotal() {
            return (double)this.itemCount * this.itemPrice;
        }

        public String getFileAsExcel() {
            return "" + this.getInvoicesTableHeader().getInvNum() + "," + this.getItemName() + "," + this.getItemPrice() + "," + this.getItemCount();
        }
    }


