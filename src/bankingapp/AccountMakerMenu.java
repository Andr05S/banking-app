package bankingapp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


//lets new users make an account
//pulls the entered name to name the account and then makes a file named "accountName +Checking or +Savings depending on the user's choice
//stores this as a blank csv with the rest of the account data.

@SuppressWarnings("serial")
public class AccountMakerMenu extends JFrame {
	public void newAccount(String accountName) {
		JFrame frame = new JFrame();
		 JPanel pane = new JPanel(new FlowLayout());
		 pane.setPreferredSize(new Dimension(500,500));
		 pane.setBackground(Color.WHITE);
		 pane.setOpaque(true);
		 frame.getContentPane().add(pane, BorderLayout.CENTER);
		   JLabel label1 = new JLabel("Would you like to make a checking or savings account?");
		   JButton checkingButton = new JButton("Checking");
		   JButton savingsButton = new JButton("Savings");
		   JButton exitButton = new JButton("cancel");
		   pane.add(label1);
		   checkingButton.setFocusable(false);
		   savingsButton.setFocusable(false);
		   exitButton.setFocusable(false);
		   checkingButton.setPreferredSize(new Dimension(100,100));
		   savingsButton.setPreferredSize(new Dimension(100,100));
		   exitButton.setPreferredSize(new Dimension(100,100));
		   pane.add(checkingButton);
		   pane.add(savingsButton);
		   pane.add(exitButton);
		   checkingButton.addActionListener(e -> {
			   String accountType = "Checking";
			   this.accountWriter(accountName, accountType);
				});
		   savingsButton.addActionListener(e -> {
			   String accountType = "Savings";
			 this.accountWriter(accountName, accountType);
		});
		   exitButton.addActionListener(e -> frame.dispose());
		   frame.getRootPane().setDefaultButton(checkingButton);
		   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   frame.setLocationRelativeTo(null);
		   frame.pack();
		   frame.setVisible(true);
	}
	public void accountWriter(String accountName, String accountType) {
		 try {
			 	File newAccountFile = new File("src\\accountData\\" +accountName +accountType +".csv");
			 	if (newAccountFile.createNewFile()) {
			 		System.out.println("file created");
			 	}
				BufferedWriter accountCSVMaker = new BufferedWriter(new FileWriter("src\\accountData\\" +accountName +accountType +".csv"));
				accountCSVMaker.write("it works");
				accountCSVMaker.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
	}
	}
}
