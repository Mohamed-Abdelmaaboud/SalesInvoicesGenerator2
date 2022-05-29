package SalesInvoicesGen.controller;

import SalesInvoicesGen.view.Frame;

import javax.swing.*;
import java.awt.*;

public class InvoicesHeaderDialog extends JDialog{
    private JTextField itemNameJTextField = new JTextField(20);
    private JTextField itemCountJTextField = new JTextField(20);
    private JTextField itemPriceJTextField = new JTextField(20);
    private JLabel itemNameLbl = new JLabel("Item Name:");
    private JLabel itemCountLbl = new JLabel("Item Count:");
    private JLabel itemPriceLbl = new JLabel("Item Price:");
    private JButton okBtn = new JButton("OK");
    private JButton cancelBtn = new JButton("Cancel");

    public InvoicesHeaderDialog(Frame f) {
        this.okBtn.setActionCommand("confirmCreateLine");
        this.cancelBtn.setActionCommand("cancelCreateLine");
        this.okBtn.addActionListener(f);
        this.cancelBtn.addActionListener(f);
        this.setLayout(new GridLayout(4, 2));
        this.add(this.itemNameLbl);
        this.add(this.itemNameJTextField);
        this.add(this.itemCountLbl);
        this.add(this.itemCountJTextField);
        this.add(this.itemPriceLbl);
        this.add(this.itemPriceJTextField);
        this.add(this.okBtn);
        this.add(this.cancelBtn);
        this.pack();
    }

    public JTextField getItemNameJTextField() {
        return this.itemNameJTextField;
    }

    public JTextField getItemCountJTextField() {
        return this.itemCountJTextField;
    }

    public JTextField getItemPriceJTextField() {
        return this.itemPriceJTextField;
    }
}


