/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantsystem.order;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Sopnopriyo
 */
public class OrderHelper {
    //  protected OrderManagement o = new OrderManagement();

    private Scanner scan;
    private String srchName;
    private int num = 1;
    private String s1, s2;
    private String name;
    private int cngQuantity;

    private String price;
    private String quantity;
    private StringBuilder fullnames;
    private String itemName[];
    private StringBuilder reciptName;

    public OrderHelper() {
        fullnames = new StringBuilder();
        openFile();
        readFile();
        closeFile();
    }

    public StringBuilder getFullNames() {
        return fullnames;
    }

    public StringBuilder getReciptName() {
        return reciptName;
    }

    private void openFile() {
        try {
            scan = new Scanner(new File("item.txt"));
            System.out.println("File found!");
        } catch (Exception e) {
            System.out.println("File not found");
        }
    }

    public void setSrchName(String srchName) {
        this.srchName = srchName;
    }

    public String getSrchName() {
        return srchName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public String getQuantity() {
        return quantity;
    }

    private void readFile() {
        try {
            while (scan.hasNextLine()) {
                name = scan.nextLine();
                price = scan.nextLine();
                quantity = scan.nextLine();
                fullnames.append(num + "\t" + name + " \t" + price + " \t" + quantity + "\n");
                num++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void closeFile() {
        scan.close();
    }

    public void ModifyItem() {
        String srcKey = getSrchName();
        System.out.println(srcKey + " is going to be changed in quantity");

        System.out.println(srcKey + "will be modified");

        int c = 0, track, cnt = 0, temp = 0;

        try {
            Scanner sc = new Scanner(new FileInputStream("item.txt"));
            while (sc.hasNextLine()) {
                cnt++;
                sc.nextLine();

            }
            itemName = new String[cnt];
            sc.close();
            sc = new Scanner(new FileInputStream("item.txt"));
            while (sc.hasNextLine()) {
                itemName[c] = sc.nextLine();
                if (itemName[c].equalsIgnoreCase(srcKey)) {
                    temp = c;
                    System.out.println("Index will be deleted" + c);
                }
                c++;

            }

        } catch (Exception e) {
            System.out.println(e);

        }

        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream("item.txt"));
            for (int i = 0; i < c; i++) {
                if (i == temp + 2) {
                    cngQuantity = Integer.decode(itemName[i]);

                    cngQuantity = cngQuantity - Integer.decode(getQuantity());
                    pw.println(cngQuantity);
                    System.out.println("Value has been changed ");

                } else {
                    pw.println(itemName[i]);
                }

            }
            System.out.println("Your item has been deleted.");
            pw.close();
        } catch (Exception e) {
        }

    }

    public int checkQuantity(int n) {
        int i = 1;
        int quantity;
        int count;
        try {
            Scanner sc = new Scanner(new FileInputStream("item.txt"));
            while (sc.hasNextLine()) {
                if (i == n) {
                    sc.nextLine();
                    sc.nextLine();
                    quantity = Integer.decode(sc.nextLine());
                    return quantity;
                } else {
                    sc.nextLine();
                    sc.nextLine();
                    sc.nextLine();
                }
                i++;
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e);

        }
        return 0;
    }

    public void temp(int n, int i) {

        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream("temp.txt", true));

            Scanner sc = new Scanner(new FileInputStream("Item.txt"));
            for (int j = 1; sc.hasNextLine(); j++) {
                if (j == n) {
                    s1 = sc.nextLine();
                    pw.println(s1);

                    s2 = sc.nextLine();
                    pw.println(i);
                    sc.nextLine();
                } else {
                    sc.nextLine();
                    sc.nextLine();
                    sc.nextLine();
                }
            }
            sc.close();
            pw.close();
            /*         
        
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream("temp.txt",true));
            pw.println(s1);
            pw.println(s2);
            pw.close();
            
        } catch (Exception e) {
            System.out.println("New File has been created with values ");
        }
             */

        } catch (Exception e) {
        }
        //delete();
    }

    public void delete() {
        String name = "";
        String quantity = "";
        try {
            Scanner sc = new Scanner(new FileInputStream("temp.txt"));
            while (sc.hasNextLine()) {
                name = sc.nextLine();
                quantity = sc.nextLine();
                setSrchName(name);
                setQuantity(quantity);
                ModifyItem();

            }
            System.out.println("End of reading temp file");
            sc.close();
        } catch (Exception e) {
        }

    }

    public void readRecipt() {

        try {
            Scanner sc = new Scanner(new FileInputStream("temp.txt"));
            while (sc.hasNextLine()) {
                name = sc.nextLine();
                //price = scan.nextLine();
                quantity = sc.nextLine(); // + " \t"+quantity+
                reciptName.append(name + " \t" + quantity + "\n");
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
