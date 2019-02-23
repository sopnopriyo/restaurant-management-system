/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantsystem;

import javax.swing.JFrame;
import restaurentsystem.auth.LogIn;
/**
 *
 * @author Shahin
 */
public class Main extends JFrame{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LogIn im = new LogIn();
        im.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        im.setVisible(true);
        
    }
    
}
