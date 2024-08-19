package bankingapp;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.util.*;
public class newUser {

	public static void newUserCreator(String newName, String newPass) throws IOException { //accepts 2 strings
		HashMap<String, String> logins = LoginArray.getFile();
		
		if (logins.containsKey(newName)) { //if the username is already in use, user is directed to make a new one
			//plus formatting for jframe buttons
			try {
				
				 JFrame frame = new JFrame();
				 JPanel pane = new JPanel(new FlowLayout());
				 pane.setPreferredSize(new Dimension(500,500));
				 pane.setBackground(Color.WHITE);
				 pane.setOpaque(true);
				 frame.getContentPane().add(pane, BorderLayout.CENTER);
				   JLabel label1 = new JLabel("That username is in use already,\n please"
				   		+ "create a different one");
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
				e.printStackTrace(); //print errors that occur
			}
		}
		else {
			logins.put(newName, newPass); //stores the new login in the hashmap
		Set<String> keySet = logins.keySet();                               //these 4 lines are used to
		ArrayList<String> listOfKeys = new ArrayList<String>(keySet);       //convert the hashmap into an array that the writer can understand
		Collection<String> values = logins.values();
		ArrayList<String> listOfValues = new ArrayList<String>(values);
		//System.out.println(listOfKeys); test code
		//System.out.println(listOfValues); test code
			
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("src\\csvforlogins.csv")); //this writes the whole list back into the file
			int i = 0;                                               							// in order to store it in the original file that logins
			while (i<listOfKeys.size()) {														//are pulled from
				writer.write(listOfKeys.get(i).toString());
				writer.write(",");
				writer.write(listOfValues.get(i).toString());
				writer.write("\n");
				i++;
			}
			writer.close(); //closes the writer
		} catch (IOException e) {
			throw e;
		} 
		AccountMakerMenu accountMakerMenu = new AccountMakerMenu();
		accountMakerMenu.newAccount(newName); //launches the account maker for checking/savings
		return;
		}
	}
		
}
