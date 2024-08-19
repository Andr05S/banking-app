package bankingapp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import Classes.Account;
import Classes.Transactions;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AccountAccess {

	public void viewAccount(String enteredName, String accountType) {
		String fileName = "src\\accountdata\\"+enteredName+accountType+".csv";
		Account checking = new Account(); //initializes the account class from our classes file.
		TransactionReader reader = new TransactionReader(); //initializes the class TransactionReader which is used to read in the data from the CSV
		ArrayList<Transactions> transactionTableData = reader.readTransactions(enteredName+accountType); //this grabs the associated CSV file and makes it an
																										//array list
		checking.setTransactionHistory(transactionTableData); //makes our account equal to our array list
		JFrame holder = new JFrame();
		String[] columnNames = { "Date", "Amount", "Name", "New Balance", "Type"}; //column titles for the readability
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0); //formatting for the table
		JTable transactionTable = new JTable(tableModel);
		for (Transactions t : checking.getTransactionHistory()) { //in our table "t" we are now going to add each of these values to the matching columns
			Object[] data = {t.getTransactionDate(), t.getTransactionAmount(), t.getTransactionName(), t.getRemainingBalance(), t.getTransactionType()};
			tableModel.addRow(data);
		}
		transactionTable.setBounds(30, 40, 200, 300); //formatting for the display
		JScrollPane sp = new JScrollPane(transactionTable); 
		holder.add(sp);
		holder.setSize(500,200);
		holder.setVisible(true);
			 JFrame frame = new JFrame();
			 JPanel pane = new JPanel(new FlowLayout());
			 pane.setPreferredSize(new Dimension(500,500));
			 pane.setBackground(Color.WHITE);
			 pane.setOpaque(true);
			 frame.getContentPane().add(pane, BorderLayout.CENTER);
			   JButton deposit = new JButton("Deposit");
			   JButton withdraw = new JButton("Withdraw");
			   JButton exitButton = new JButton("Quit");
			   deposit.setFocusable(false);
			   withdraw.setFocusable(false);
			   exitButton.setFocusable(false);
			   deposit.setPreferredSize(new Dimension(100,100));
			   withdraw.setPreferredSize(new Dimension(100,100));
			   exitButton.setPreferredSize(new Dimension(100,100));
			   JTextField amount = new JTextField(10);
			   JTextField transactionName = new JTextField(10);
			   pane.add(deposit);
			   pane.add(withdraw);
			   //pane.add(exitButton);
			   pane.add(amount, BorderLayout.SOUTH);
			   pane.add(transactionName, BorderLayout.SOUTH);
			   deposit.addActionListener(e -> {
					depositWithdraw(amount.getText(), transactionName.getText(), "Deposit", fileName);});
			   withdraw.addActionListener(e -> {
				   depositWithdraw(amount.getText(), transactionName.getText(), "Withdrawal", fileName);
			});
			   exitButton.addActionListener(e -> frame.dispose());
			   frame.getRootPane().setDefaultButton(deposit);
			   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			   frame.setLocationRelativeTo(null);
			   frame.pack();
			   frame.setVisible(true);
			   
			   
			
	}
	public void depositWithdraw(String amount, String tName, String depoWith, String fileName) {
	try {
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
		System.out.println(fileName);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH);
		String formattedDate = LocalDate.now().format(formatter);
		writer.write("\n"+formattedDate+","+amount+","+tName+",1000,"+depoWith);
		writer.close();
		System.out.println("You have made a "+depoWith+" of $"+amount+" for "+tName);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
