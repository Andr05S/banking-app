package Classes;

import java.util.ArrayList;

public class Account {
	
	private Integer balance;
	private ArrayList<Transactions> transactionHistory;
	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	public ArrayList<Transactions> getTransactionHistory() {
		return transactionHistory;
	}
	public void setTransactionHistory(ArrayList<Transactions> transactionHistory) {
		this.transactionHistory = transactionHistory;
	}
	
}
