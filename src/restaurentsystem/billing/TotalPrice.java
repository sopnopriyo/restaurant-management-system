/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurentsystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Shahin
 */
public class TotalPrice {
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
    public TotalPrice()
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

    private void openFile()
    {
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

    private void readFile()
    {
        try{
            while(scan.hasNextLine())
            {
                
                
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
        catch(Exception e){
            System.out.println(e);
        }
        
        
                
        
    }

    private void closeFile()
    {
        scan.close();
        
    }   
}
