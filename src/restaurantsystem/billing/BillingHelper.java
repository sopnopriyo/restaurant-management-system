/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package restaurantsystem.billing;

import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Shahin
 */
public class BillingHelper {
    private Scanner sc;
    private Scanner scan;
    private String name;
    private String price;
    private String quantity;
    private StringBuilder fullnames;
    private double dPrice;
    private int dQuantity;
    private double multi;
    private PrintWriter pw;
    public BillingHelper()
    {
        fullnames = new StringBuilder();
        openFile();
        readFile();
        closeFile();
    }
    
    public StringBuilder getFullNames()
    {
        return fullnames;
    }
    
    public String getTotal() {
        
        double totalPrice = 0;
        
        try {
            scan = new Scanner(new FileInputStream("order.txt"));
            while(scan.hasNextLine()) {
                scan.nextLine();
                scan.nextLine();
                price = scan.nextLine();
                totalPrice += Double.valueOf(price);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return String.valueOf("Total Price is : "+totalPrice);
    }
    
    private void openFile() {
        try
        {
            
            scan = new Scanner(new File("order.txt"));
            
            System.out.println("File found!");
        }
        
        catch(Exception e)
        {
            System.out.println("File not found");
        }
    }
    
    private void readFile() {
        try {
            while(scan.hasNextLine()) {
                name = scan.nextLine();
                System.out.println(name);
                // price = scan.nextLine();
               
                quantity=scan.nextLine();
                // dQuantity=Integer.decode(quantity);
                //multi=dPrice*dQuantity;
                price =scan.nextLine();
                fullnames.append(name + " \t"+quantity+"\t"+price+ "\n");
              }
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
    
    private void closeFile() {
        scan.close();
    }
}