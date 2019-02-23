/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurentsystem;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Shahin
 */
public class inTotal {
    public Scanner scan;
    public double total=0;
    public String price;

    public String getTotal() {
        
         try{
              scan = new Scanner(new FileInputStream("order.txt"));
            while(scan.hasNextLine())
            {
                
                
                scan.nextLine();
               scan.nextLine();
               price = scan.nextLine();
               total+=Double.valueOf(price);
               
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return String.valueOf("Total Price is : "+total);
    }
    
    
}
