package SalesInvoicesGen.controller;

import SalesInvoicesGen.view.Frame;

import javax.swing.*;
import java.awt.*;
public class InvoicesLineDialog extends JDialog {
private JTextField customerNameField = new JTextField(20);
private JTextField invoiceDateField = new JTextField(20);
private JLabel customerNameJLabel = new JLabel("Customer Name:");
private JLabel invoiceDateJLabel = new JLabel("Invoice Date:");
private JButton okBtn = new JButton("OK");
private JButton cancelBtn = new JButton("Cancel");

public InvoicesLineDialog(Frame f) {
        this.okBtn.setActionCommand("confirmCreateInvoice");
        this.cancelBtn.setActionCommand("cancelCreateInvoice");
        this.okBtn.addActionListener(f);
        this.cancelBtn.addActionListener(f);
        this.setLayout(new GridLayout(4, 2));
        this.add(this.customerNameJLabel);
        this.add(this.customerNameField);
        this.add(this.invoiceDateJLabel);
        this.add(this.invoiceDateField);
        this.add(this.okBtn);
        this.add(this.cancelBtn);
        this.pack();
        }

public JTextField getCustomerNameField() {
        return this.customerNameField;
        }

public JTextField getInvoiceDateField() {
        return this.invoiceDateField;
        }
        }
