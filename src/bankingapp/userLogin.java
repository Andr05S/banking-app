package bankingapp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.io.File;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class userLogin {

	public static void userLLogin(String enteredName, String passWord) { //pulls in 2 given strings from the jframe textfields in the class that called this one
		//System.out.println(enteredName);
		//System.out.println(passWord);
		
		HashMap<String, String> logins = LoginArray.getFile(); //recreates the logins hashmap seen in loginArray in order to make use of the CSV file.
		if (!logins.containsKey(enteredName.toString())) { //this entire if statement tests if the username is in the hashmap.  If its not, a button pops up letting
			//the user know their mistake. Once they hit "Okay" the window closes and they can try again.
			try {
				
				 JFrame frame = new JFrame();
				 JPanel pane = new JPanel(new FlowLayout());
				 pane.setPreferredSize(new Dimension(200,200));
				 pane.setBackground(Color.WHITE);
				 pane.setOpaque(true);
				 frame.getContentPane().add(pane, BorderLayout.CENTER);
				   JLabel label1 = new JLabel("Username is incorrect");
				   JButton exitButton = new JButton("Okay");
				   pane.add(label1);
				   exitButton.setFocusable(false); 
				   exitButton.setPreferredSize(new Dimension(100,100));
				   pane.add(exitButton);
				   exitButton.addActionListener(e -> frame.dispose());
				   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				   frame.setLocationRelativeTo(null);
				   frame.pack();
				   frame.setVisible(true);
				   
				   
				
			} catch (HeadlessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace(); //catch errors and print them
			}	
		}
		else if (logins.containsKey(enteredName.toString())) //when we have a correct username
		{
			if (!logins.get(enteredName).equals(passWord)) { //we now test if the password given matches that username
															//if it doesn't, we have a pop-up similar to the one described above for the incorrect username
				try {
					
					 JFrame frame = new JFrame();
					 JPanel pane = new JPanel(new FlowLayout());
					 pane.setPreferredSize(new Dimension(200,200));
					 pane.setBackground(Color.WHITE);
					 pane.setOpaque(true);
					 frame.getContentPane().add(pane, BorderLayout.CENTER);
					   JLabel label1 = new JLabel("Password is incorrect");
					   JButton exitButton = new JButton("Okay");
					   pane.add(label1);
					   exitButton.setFocusable(false); 
					   exitButton.setPreferredSize(new Dimension(100,100));
					   pane.add(exitButton);
					   exitButton.addActionListener(e -> frame.dispose());
					   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					   frame.setLocationRelativeTo(null);
					   frame.pack();
					   frame.setVisible(true);
					   
					   
					
				} catch (HeadlessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace(); //catch errors and print them
				}
			}
			else if (logins.get(enteredName).equals(passWord)) {  //when the username and password are both correct
																	//we call the account associated with the username.
				try {
					
					 JFrame frame = new JFrame();
					 JPanel pane = new JPanel(new FlowLayout());
					 pane.setPreferredSize(new Dimension(500,500));
					 pane.setBackground(Color.WHITE);
					 pane.setOpaque(true);
					 frame.getContentPane().add(pane, BorderLayout.CENTER);
					   JLabel label1 = new JLabel("Please select the Account you would like to access");
					   JButton checkingButton = new JButton("Checking");
					   JButton savingsButton = new JButton("Savings");
					   JButton exitButton = new JButton("Logout");
					   pane.add(label1);
					   checkingButton.setFocusable(false);
					   savingsButton.setFocusable(false);
					   exitButton.setFocusable(false);
					   checkingButton.setPreferredSize(new Dimension(100,100));
					   savingsButton.setPreferredSize(new Dimension(100,100));
					   exitButton.setPreferredSize(new Dimension(100,100));
					   boolean doesFileExist = false;
					   doesFileExist = fileChecker(enteredName, "Checking");
					   if (doesFileExist) {
					   pane.add(checkingButton);
					   }
					   doesFileExist = fileChecker(enteredName, "Savings");
					   if (doesFileExist) {
					   pane.add(savingsButton);
					   }
					   pane.add(exitButton);
					   
					   checkingButton.addActionListener(e -> {
						   AccountAccess callAccount = new AccountAccess();
						   String accountType = "Checking";
						   callAccount.viewAccount(enteredName, accountType);
					   });
					   savingsButton.addActionListener(e -> {
						   AccountAccess callAccount = new AccountAccess();
						   String accountType = "Savings";
						   callAccount.viewAccount(enteredName, accountType);
					});
					   exitButton.addActionListener(e -> frame.dispose());
					   frame.getRootPane().setDefaultButton(checkingButton);
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
		
	}
	public static boolean fileChecker(String enteredName, String accountType) {
		File fileChecked = new File("src\\accountdata\\"+enteredName+accountType+".csv");
		
		if (fileChecked.exists()) {
			return true;
		}
		else {
		return false;
		}
	}
}

