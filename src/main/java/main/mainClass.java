package main;


import SalesInvoicesGen.model.FileOperations;
import SalesInvoicesGen.view.Frame;

public class mainClass {
    public static void main(String[] args) {

            Frame f = new Frame();
            f.setVisible(true);

        FileOperations fileOperations = new FileOperations();
        fileOperations.readFile();
        }
    }

