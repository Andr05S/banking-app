package bankingapp;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.*;
import javax.swing.*;

/*
 * The following block of code is primarily formatting but lines 31-33, 48-58 are function related
 * this creates a menu from which a user can select one of the buttons described in 31-33.
 * 48-58 is the result of each button
 * login launches the userlogin class based on their entry into the textfields in lines 38-39.
 * new user launches a separate menu for creating a new username and password
 * quit closes the program.
 */
@SuppressWarnings("serial")
public class menuButtons extends JFrame  {
	  static void menuFirst() {
		try {
			
			 JFrame frame = new JFrame();
			 JPanel pane = new JPanel(new FlowLayout());
			 pane.setPreferredSize(new Dimension(500,500));
			 pane.setBackground(Color.WHITE);
			 pane.setOpaque(true);
			 frame.getContentPane().add(pane, BorderLayout.CENTER);
			   JLabel label1 = new JLabel("Welcome to RC Bank's user app, would you "
			   		+ "like to login or create a new account?");
			   JButton loginButton = new JButton("Login");
			   JButton newUserButton = new JButton("New User");
			   JButton exitButton = new JButton("Quit");
			   pane.add(label1);
			   loginButton.setFocusable(false);
			   newUserButton.setFocusable(false);
			   exitButton.setFocusable(false);
			   loginButton.setPreferredSize(new Dimension(100,100));
			   newUserButton.setPreferredSize(new Dimension(100,100));
			   exitButton.setPreferredSize(new Dimension(100,100));
			   JTextField userField = new JTextField(10);
			   JTextField passwordField = new JTextField(10);
			   pane.add(loginButton);
			   pane.add(newUserButton);
			   pane.add(exitButton);
			   pane.add(userField, BorderLayout.SOUTH);
			   pane.add(passwordField, BorderLayout.SOUTH);
			   loginButton.addActionListener(e -> {
					userLogin.userLLogin(userField.getText(), passwordField.getText());});
			   newUserButton.addActionListener(e -> {
				NewUserMenu.menuNewUser();
			});
			   exitButton.addActionListener(e -> frame.dispose());
			   frame.getRootPane().setDefaultButton(loginButton);
			   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			   frame.setLocationRelativeTo(null);
			   frame.pack();
			   frame.setVisible(true);
			   
			   
			
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
