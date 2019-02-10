/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantsystem;

import restaurantsystem.auth.Login;

import javax.swing.JFrame;

/**
 * @author Shahin
 */
public class RestaurentSystem extends JFrame {

	public static void main(String[] args) {


		/**
		 * Boot the application with a Login Page
		 *
		 * Enter Username as shahin
		 * Enter Password as shahin
		 */

		Login logIn = new Login();
		logIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		logIn.setVisible(true);
	}
}
