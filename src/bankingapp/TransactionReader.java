package bankingapp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;



import Classes.Transactions;
/*
 * this class when given a filename will turn that file into an array that the rest of our program can read.
 * the datetimeformatter sets a specified format for all dates in the csv
 * finally, in the transactions object, we are adding a new transaction listing. this will be done for each individual transaction until the whole list is printed
 * for the user to read. the use of parse is a simple conversion of the data into a legible string
 */
public class TransactionReader{
public ArrayList<Transactions> readTransactions(String fileName) { 
	String file = "src\\accountdata\\" +fileName+".csv";
	String line;
	ArrayList<Transactions> transactionList = new ArrayList<Transactions>();
	try {
	BufferedReader transactionReader = new BufferedReader(new FileReader(file));
	while ((line = transactionReader.readLine()) != null) {
		String[] transactionArray = line.split(",");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH);
		LocalDate parsedDate = LocalDate.parse(transactionArray[0], formatter);
		Transactions newTransactions = new Transactions(parsedDate, Integer.parseInt(transactionArray[1]), 
				transactionArray[2], Integer.parseInt(transactionArray[3]) , transactionArray[4]);
		//System.out.println(newTransactions.getTransactionDate().format(formatter));
		//System.out.println(newTransactions.getTransactionAmount());
		//System.out.println(newTransactions.getTransactionName());
		//System.out.println(newTransactions.getRemainingBalance());
		//System.out.println(newTransactions.getTransactionType());
		transactionList.add(newTransactions); //stores the new transaction in our arraylist to be called elsewhere.
		
		
	}
	transactionReader.close();
	} catch(IOException e1) {
		e1.printStackTrace(); //catches errors and prints them out
	}
	
	return transactionList;} //returns the arraylist made at the beginning with the new transaction added on.
}
