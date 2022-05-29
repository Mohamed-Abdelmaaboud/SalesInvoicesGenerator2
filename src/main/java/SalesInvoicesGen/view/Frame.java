package SalesInvoicesGen.view;



import SalesInvoicesGen.controller.InvoicesHeaderDialog;
import SalesInvoicesGen.controller.InvoicesLineDialog;
import SalesInvoicesGen.model.InvoiceHeader;
import SalesInvoicesGen.model.InvoiceHeaderJtableModel;
import SalesInvoicesGen.model.InvoiceLIne;
import SalesInvoicesGen.model.InvoiceLineJtableModel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Frame extends JFrame implements ActionListener, ListSelectionListener {
    private JLabel InvoiceTotalLbl2;
    private JMenuBar JMenuBar;
    private JButton createNewLineBtn;
    private JLabel customerNameLbl;
    private JTextField customerNameTxtFld;
    private JButton deleteInvoiceBtn;
    private JButton deleteLineBtn;
    private JLabel invoiceDateLbl;
    private JTextField invoiceDateTxtFld;
    private JLabel invoiceItemsLbl;
    private JScrollPane invoiceItemsScrlpn;
    private JTable invoiceItemsTbl;
    private JLabel invoiceNumberLbl;
    private JLabel invoiceNumberLbl2;
    private JLabel invoiceTotalLbl;
    private JLabel invoicesTableLbl;
    private JScrollPane invoicesTblScrlpn;
    private JTable invoicesTblTbl;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JMenuItem loadFileMenu;
    private JMenu menuBar;
    private JButton newInvoiceBtn;
    private JMenuItem saveFileMenu;
    private DateFormat dateFt = new SimpleDateFormat("dd-MM-yyyy");
    private List<InvoiceLIne> invoicesArray = new ArrayList();
    private InvoiceLineJtableModel invoicesTableTableModel;
    private InvoiceHeaderJtableModel invoicesItemsTableModel;
    private InvoicesLineDialog invoicesTblDialog;
    private InvoicesHeaderDialog invoicesItemsDialog;

    public Frame() {
        this.initComponents();
    }

    private void initComponents() {
        this.invoicesTableLbl = new JLabel();
        this.newInvoiceBtn = new JButton();
        this.newInvoiceBtn.addActionListener(this);
        this.deleteInvoiceBtn = new JButton();
        this.deleteInvoiceBtn.addActionListener(this);
        this.createNewLineBtn = new JButton();
        this.createNewLineBtn.addActionListener(this);
        this.deleteLineBtn = new JButton();
        this.deleteLineBtn.addActionListener(this);
        this.jPanel2 = new JPanel();
        this.jPanel1 = new JPanel();
        this.invoiceItemsScrlpn = new JScrollPane();
        this.invoiceItemsTbl = new JTable();
        this.invoiceItemsLbl = new JLabel();
        this.jPanel4 = new JPanel();
        this.invoicesTblScrlpn = new JScrollPane();
        this.invoicesTblTbl = new JTable();
        this.invoicesTblTbl.getSelectionModel().addListSelectionListener(this);
        this.jPanel3 = new JPanel();
        this.invoiceTotalLbl = new JLabel();
        this.customerNameLbl = new JLabel();
        this.invoiceDateLbl = new JLabel();
        this.invoiceNumberLbl = new JLabel();
        this.invoiceNumberLbl2 = new JLabel();
        this.InvoiceTotalLbl2 = new JLabel();
        this.invoiceDateTxtFld = new JTextField();
        this.customerNameTxtFld = new JTextField();
        this.JMenuBar = new JMenuBar();
        this.menuBar = new JMenu();
        this.loadFileMenu = new JMenuItem();
        this.loadFileMenu.addActionListener(this);
        this.saveFileMenu = new JMenuItem();
        this.saveFileMenu.addActionListener(this);
        this.setDefaultCloseOperation(3);
        this.setTitle("Sales Invoices Generator");
        this.invoicesTableLbl.setText("Invoices Table");
        this.newInvoiceBtn.setText("Create New Invoice");
        this.newInvoiceBtn.setActionCommand("CreateNewInvoice");
        this.deleteInvoiceBtn.setText("Delete Invoice");
        this.deleteInvoiceBtn.setActionCommand("DeleteInvoice");
        this.createNewLineBtn.setText("Save");
        this.createNewLineBtn.setActionCommand("Save");
        this.deleteLineBtn.setText("Cancel");
        this.deleteLineBtn.setActionCommand("Cancel");
        this.jPanel2.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        this.jPanel1.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153)));
        this.jPanel1.setForeground(new Color(204, 204, 204));
        this.invoiceItemsTbl.setModel(new DefaultTableModel(new Object[0][], new String[0]));
        this.invoiceItemsTbl.setGridColor(new Color(204, 204, 204));
        this.invoiceItemsTbl.setSelectionForeground(new Color(204, 204, 204));
        this.invoiceItemsTbl.setShowGrid(true);
        this.invoiceItemsScrlpn.setViewportView(this.invoiceItemsTbl);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.invoiceItemsScrlpn, -2, 526, -2));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.invoiceItemsScrlpn, -2, 85, -2).addGap(0, 206, 32767)));
        this.invoiceItemsLbl.setText("Invoice Items");
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.jPanel1, -2, -1, -2)).addComponent(this.invoiceItemsLbl)).addContainerGap(21, 32767)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.invoiceItemsLbl).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel1, -2, -1, -2).addContainerGap(20, 32767)));
        this.jPanel4.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153)));
        this.jPanel4.setForeground(new Color(204, 204, 204));
        this.invoicesTblTbl.setModel(new DefaultTableModel(new Object[0][], new String[0]));
        this.invoicesTblTbl.setGridColor(new Color(204, 204, 204));
        this.invoicesTblTbl.setSelectionForeground(new Color(204, 204, 204));
        this.invoicesTblTbl.setShowGrid(true);
        this.invoicesTblScrlpn.setViewportView(this.invoicesTblTbl);
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.invoicesTblScrlpn, -2, 491, -2));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.invoicesTblScrlpn, -2, 85, -2).addGap(0, 405, 32767)));
        this.jPanel3.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        this.invoiceTotalLbl.setText("Invoice Total");
        this.customerNameLbl.setText("Customer Name");
        this.invoiceDateLbl.setText("Invoice Date");
        this.invoiceNumberLbl.setText("Invoice Number");
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup().addContainerGap(18, 32767).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.invoiceNumberLbl).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.invoiceNumberLbl2)).addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.customerNameLbl).addComponent(this.invoiceTotalLbl).addComponent(this.invoiceDateLbl)).addGap(12, 12, 12).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.InvoiceTotalLbl2).addComponent(this.invoiceDateTxtFld, -2, 421, -2).addComponent(this.customerNameTxtFld, -2, 421, -2)))).addGap(9, 9, 9)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup().addContainerGap(8, 32767).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.invoiceNumberLbl).addComponent(this.invoiceNumberLbl2)).addGap(18, 18, 18).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.invoiceDateLbl).addComponent(this.invoiceDateTxtFld, -2, -1, -2)).addGap(3, 3, 3).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(16, 16, 16).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.customerNameLbl).addComponent(this.customerNameTxtFld, -2, -1, -2))).addGroup(jPanel3Layout.createSequentialGroup().addGap(63, 63, 63).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.invoiceTotalLbl).addComponent(this.InvoiceTotalLbl2)))).addGap(14, 14, 14)));
        this.menuBar.setText("File");
        this.menuBar.setActionCommand("menuBarCommand");
        this.loadFileMenu.setText("Load File");
        this.loadFileMenu.setActionCommand("loadFileMenuItem");
        this.menuBar.add(this.loadFileMenu);
        this.saveFileMenu.setActionCommand("SaveFileMenuItem");
        this.saveFileMenu.setText("Save File");
        this.menuBar.add(this.saveFileMenu);
        this.JMenuBar.add(this.menuBar);
        this.setJMenuBar(this.JMenuBar);
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(12, 12, 12).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.invoicesTableLbl).addGroup(layout.createSequentialGroup().addGap(64, 64, 64).addComponent(this.newInvoiceBtn).addGap(28, 28, 28).addComponent(this.deleteInvoiceBtn)).addComponent(this.jPanel4, -2, -1, -2)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jPanel2, -1, -1, 32767).addComponent(this.jPanel3, -1, -1, 32767))).addGroup(layout.createSequentialGroup().addGap(664, 664, 664).addComponent(this.createNewLineBtn, -2, 129, -2).addGap(42, 42, 42).addComponent(this.deleteLineBtn, -2, 126, -2))).addContainerGap(7, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(24, 24, 24).addComponent(this.invoicesTableLbl).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jPanel3, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.createNewLineBtn, -1, 35, 32767).addComponent(this.deleteLineBtn, -1, -1, 32767))).addGroup(layout.createSequentialGroup().addComponent(this.jPanel4, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.newInvoiceBtn, -1, 35, 32767).addComponent(this.deleteInvoiceBtn, -1, -1, 32767)))).addContainerGap(18, 32767)));
        this.pack();
    }

    public void actionPerformed(ActionEvent e) {
        String var2 = e.getActionCommand();
        byte var3 = -1;
        switch(var2.hashCode()) {
            case -1740579102:
                if (var2.equals("DeleteInvoice")) {
                    var3 = 3;
                }
                break;
            case -804307401:
                if (var2.equals("cancelCreateInvoice")) {
                    var3 = 7;
                }
                break;
            case -757279831:
                if (var2.equals("CreateNewInvoice")) {
                    var3 = 2;
                }
                break;
            case -537151393:
                if (var2.equals("DeleteLine")) {
                    var3 = 5;
                }
                break;
            case -24157973:
                if (var2.equals("SaveFileMenuItem")) {
                    var3 = 1;
                }
                break;
            case 154810864:
                if (var2.equals("confirmCreateLine")) {
                    var3 = 8;
                }
                break;
            case 595480824:
                if (var2.equals("CreateNewLine")) {
                    var3 = 4;
                }
                break;
            case 864067882:
                if (var2.equals("cancelCreateLine")) {
                    var3 = 9;
                }
                break;
            case 958965681:
                if (var2.equals("confirmCreateInvoice")) {
                    var3 = 6;
                }
                break;
            case 2048477876:
                if (var2.equals("loadFileMenuItem")) {
                    var3 = 0;
                }
        }

        switch(var3) {
            case 0:
                this.loadFile();
                break;
            case 1:
                this.saveFile();
                break;
            case 2:
                this.showCreateNewInvoiceDialog();
                break;
            case 3:
                this.deleteInv();
                break;
            case 4:
                this.showCreateNewLineDialog();
                break;
            case 5:
                this.deleteLine();
                break;
            case 6:
                this.confirmCreateInvoice();
                break;
            case 7:
                this.cancelCreateInvoice();
                break;
            case 8:
                this.confirmCreateLine();
                break;
            case 9:
                this.cancelCreateLine();
        }

    }

    private void loadFile() {
        JOptionPane.showMessageDialog(this, "Please, Choose Invoices Table file path.", "Help - Selecting Tables", 1);
        JFileChooser openFile = new JFileChooser();
        int result = openFile.showOpenDialog(this);
        if (result == 0) {
            File invoicesTableFile = openFile.getSelectedFile();

            try {
                BufferedReader invoicesTableBr = new BufferedReader(new FileReader(invoicesTableFile));
                String invoicesTableLines = null;

                String invoicesItemsLines;
                while((invoicesTableLines = invoicesTableBr.readLine()) != null) {
                    String[] invoicesTablesLinesSplit = invoicesTableLines.split(",");
                    String invoiceNumStr = invoicesTablesLinesSplit[0];
                    invoicesItemsLines = invoicesTablesLinesSplit[1];
                    String customerNameStr = invoicesTablesLinesSplit[2];
                    int invoiceNum = Integer.parseInt(invoiceNumStr);
                    Date invoiceDate = this.dateFt.parse(invoicesItemsLines);
                    InvoiceLIne invDetails = new InvoiceLIne(invoiceNum, customerNameStr, invoiceDate);
                    this.invoicesArray.add(invDetails);
                }

                JOptionPane.showMessageDialog(this, "Please, Choose Invoices Items Table file path.", "Help - Selecting Tables", 1);
                result = openFile.showOpenDialog(this);
                if (result == 0) {
                    File invoicesItemsFile = openFile.getSelectedFile();
                    BufferedReader invoicesItemsBr = new BufferedReader(new FileReader(invoicesItemsFile));
                    invoicesItemsLines = null;

                    while((invoicesItemsLines = invoicesItemsBr.readLine()) != null) {
                        String[] invoicesItemsLinesSplit = invoicesItemsLines.split(",");
                        String invoiceNumStr = invoicesItemsLinesSplit[0];
                        String itemName = invoicesItemsLinesSplit[1];
                        String itemPriceStr = invoicesItemsLinesSplit[2];
                        String CountStr = invoicesItemsLinesSplit[3];
                        int invoiceNum = Integer.parseInt(invoiceNumStr);
                        int Count = Integer.parseInt(CountStr);
                        double itemPrice = Double.parseDouble(itemPriceStr);
                        InvoiceLIne table = this.locateInvoiceByNum(invoiceNum);
                        InvoiceHeader invItems = new InvoiceHeader(itemName, itemPrice, Count, table);
                        table.getLines().add(invItems);
                    }

                    invoicesTableBr.close();
                    invoicesItemsBr.close();
                    this.invoicesTableTableModel = new InvoiceLineJtableModel(this.invoicesArray);
                    this.invoicesTblTbl.setModel(this.invoicesTableTableModel);
                    this.invoicesTblTbl.validate();
                }
            } catch (Exception var20) {
                JOptionPane.showMessageDialog(this, "Error:" + var20.getMessage(), "Error", 0);
            }
        }

    }

    private void saveFile() {
        String invoicesTableLines = "";
        String invoicesItemsLines = "";
        Iterator var3 = this.invoicesArray.iterator();

        while(var3.hasNext()) {
            InvoiceLIne table = (InvoiceLIne)var3.next();
            invoicesTableLines = invoicesTableLines + table.getFileAsExcel();
            invoicesTableLines = invoicesTableLines + "\n";

            for(Iterator var5 = table.getLines().iterator(); var5.hasNext(); invoicesItemsLines = invoicesItemsLines + "\n") {
                InvoiceHeader item = (InvoiceHeader)var5.next();
                invoicesItemsLines = invoicesItemsLines + item.getFileAsExcel();
            }
        }

        JOptionPane.showMessageDialog(this, "Please Select Your Invoices Table Save File Location!", "Help - Save File", 1);
        JFileChooser saveJFileChooser = new JFileChooser();
        int saveFile = saveJFileChooser.showSaveDialog(this);
        if (saveFile == 0) {
            File invoicesTableFile = saveJFileChooser.getSelectedFile();

            try {
                FileWriter invoicesTableFileWriter = new FileWriter(invoicesTableFile);
                invoicesTableFileWriter.write(invoicesTableLines);
                invoicesTableFileWriter.flush();
                invoicesTableFileWriter.close();
                JOptionPane.showMessageDialog(this, "Please Select Your Invoice Items Save File Location!", "Help - Save File", 1);
                saveFile = saveJFileChooser.showSaveDialog(this);
                if (saveFile == 0) {
                    File invoicesItemsFile = saveJFileChooser.getSelectedFile();
                    FileWriter invoiceItemsFileWriter = new FileWriter(invoicesItemsFile);
                    invoiceItemsFileWriter.write(invoicesItemsLines);
                    invoiceItemsFileWriter.flush();
                    invoiceItemsFileWriter.close();
                    JOptionPane.showMessageDialog(this, "Your Data has been saved successfully!", "Data Saved", 1);
                }
            } catch (Exception var9) {
                JOptionPane.showMessageDialog(this, "Error:" + var9.getMessage(), "Error", 0);
            }
        }

    }

    private InvoiceLIne locateInvoiceByNum(int invNum) {
        InvoiceLIne table = null;
        Iterator var3 = this.invoicesArray.iterator();

        while(var3.hasNext()) {
            InvoiceLIne invoice = (InvoiceLIne)var3.next();
            if (invNum == invoice.getInvNum()) {
                table = invoice;
                break;
            }
        }

        return table;
    }

    private void invoicesTableRowSelected() {
        int selectedRowIndex = this.invoicesTblTbl.getSelectedRow();
        if (selectedRowIndex >= 0) {
            InvoiceLIne row = (InvoiceLIne)this.invoicesTableTableModel.getInvoicesTableArray().get(selectedRowIndex);
            this.customerNameTxtFld.setText(row.getCustomerName());
            this.invoiceDateTxtFld.setText(this.dateFt.format(row.getInvDate()));
            this.invoiceNumberLbl2.setText("" + row.getInvNum());
            this.InvoiceTotalLbl2.setText("" + row.getInvTotal());
            ArrayList<InvoiceHeader> itemsLines = row.getLines();
            this.invoicesItemsTableModel = new InvoiceHeaderJtableModel(itemsLines);
            this.invoiceItemsTbl.setModel(this.invoicesItemsTableModel);
            this.invoicesItemsTableModel.fireTableDataChanged();
        }

    }

    public void valueChanged(ListSelectionEvent e) {
        System.out.println("Selected");
        this.invoicesTableRowSelected();
    }

    private void showCreateNewInvoiceDialog() {
        this.invoicesTblDialog = new InvoicesLineDialog(this);
        this.invoicesTblDialog.setVisible(true);
    }

    private void confirmCreateInvoice() {
        String customerName = this.invoicesTblDialog.getCustomerNameField().getText();
        String invoiceDateStr = this.invoicesTblDialog.getInvoiceDateField().getText();
        this.invoicesTblDialog.setVisible(false);
        this.invoicesTblDialog.dispose();
        this.invoicesTblDialog = null;

        try {
            Date invoiceDate = this.dateFt.parse(invoiceDateStr);
            int invoiceNumber = this.getNextInvoiceNumber();
            InvoiceLIne invoiceTable = new InvoiceLIne(invoiceNumber, customerName, invoiceDate);
            this.invoicesArray.add(invoiceTable);
            this.invoicesTableTableModel.fireTableDataChanged();
        } catch (ParseException var6) {
            var6.printStackTrace();
        }

    }

    private void cancelCreateInvoice() {
        this.invoicesTblDialog.setVisible(false);
        this.invoicesTblDialog.dispose();
        this.invoicesTblDialog = null;
    }

    private int getNextInvoiceNumber() {
        int maxinvoicesnumber = 0;
        Iterator var2 = this.invoicesArray.iterator();

        while(var2.hasNext()) {
            InvoiceLIne table = (InvoiceLIne)var2.next();
            if (table.getInvNum() > maxinvoicesnumber) {
                maxinvoicesnumber = table.getInvNum();
            }
        }

        return maxinvoicesnumber + 1;
    }

    private void deleteInv() {
        int removeInv = this.invoicesTblTbl.getSelectedRow();
        InvoiceLIne var10000 = (InvoiceLIne)this.invoicesTableTableModel.getInvoicesTableArray().get(removeInv);
        this.invoicesTableTableModel.getInvoicesTableArray().remove(removeInv);
        this.invoicesTableTableModel.fireTableDataChanged();
        this.invoicesItemsTableModel = new InvoiceHeaderJtableModel(new ArrayList());
        this.invoiceItemsTbl.setModel(this.invoicesItemsTableModel);
        this.invoicesItemsTableModel.fireTableDataChanged();
        this.customerNameTxtFld.setText("");
        this.invoiceDateTxtFld.setText("");
        this.invoiceNumberLbl2.setText("");
        this.InvoiceTotalLbl2.setText("");
    }

    private void deleteLine() {
        int removeLine = this.invoiceItemsTbl.getSelectedRow();
        InvoiceHeader totalLine = (InvoiceHeader)this.invoicesItemsTableModel.getInvoicesItemsArray().get(removeLine);
        this.invoicesItemsTableModel.getInvoicesItemsArray().remove(removeLine);
        this.invoicesItemsTableModel.fireTableDataChanged();
        this.invoicesTableTableModel.fireTableDataChanged();
        this.InvoiceTotalLbl2.setText("" + totalLine.getInvoicesTableHeader().getInvTotal());
    }

    private void showCreateNewLineDialog() {
        this.invoicesItemsDialog = new InvoicesHeaderDialog(this);
        this.invoicesItemsDialog.setVisible(true);
    }

    private void confirmCreateLine() {
        String itemName = this.invoicesItemsDialog.getItemNameJTextField().getText();
        String itemCountStr = this.invoicesItemsDialog.getItemCountJTextField().getText();
        String itemPriceStr = this.invoicesItemsDialog.getItemPriceJTextField().getText();
        this.invoicesItemsDialog.setVisible(false);
        this.invoicesItemsDialog.dispose();
        this.invoicesItemsDialog = null;
        int itemCount = Integer.parseInt(itemCountStr);
        double itemPrice = Double.parseDouble(itemPriceStr);
        int tableIndex = this.invoicesTblTbl.getSelectedRow();
        InvoiceLIne invoiceTable = (InvoiceLIne)this.invoicesTableTableModel.getInvoicesTableArray().get(tableIndex);
        InvoiceHeader invoicesItems = new InvoiceHeader(itemName, itemPrice, itemCount, invoiceTable);
        invoiceTable.addInvLine(invoicesItems);
        this.invoicesItemsTableModel.fireTableDataChanged();
        this.invoicesItemsTableModel.fireTableDataChanged();
        this.InvoiceTotalLbl2.setText("" + invoiceTable.getInvTotal());
    }

    private void cancelCreateLine() {
        this.invoicesItemsDialog.setVisible(false);
        this.invoicesItemsDialog.dispose();
        this.invoicesItemsDialog = null;
    }
}
