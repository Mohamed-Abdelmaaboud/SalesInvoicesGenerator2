package SalesInvoicesGen.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileOperations {



   public   void readFile() {

       String path = "SheetFIles/InvoiceHeader.csv";
       String line = "";

       try {
           BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

           while ((line = bufferedReader.readLine())!=null){
               String value []=line.split(",");

              System.out.println("Invoice1Date : "  +  value[1]  +   "customer1Name : "  +   value[2]);
           }
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }


   }


}
