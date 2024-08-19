package Classes;

import java.time.LocalDate;
//establishes classes involving transactional data, allowing for ease of coding common functions with said data.
public class Transactions {

	
	private LocalDate transactionDate;
	private Integer transactionAmount;
	private String transactionName;
	private Integer remainingBalance;
	private String transactionType;
	public Transactions(LocalDate parsedDate, Integer transactionAmount, String transactionName,
			Integer remainingBalance, String transactionType) {
		super();
		this.transactionDate = parsedDate;
		this.transactionAmount = transactionAmount;
		this.transactionName = transactionName;
		this.remainingBalance = remainingBalance;
		this.transactionType = transactionType;
	}
	public LocalDate getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}
	public Integer getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(Integer transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public String getTransactionName() {
		return transactionName;
	}
	public void setTransactionName(String transactionName) {
		this.transactionName = transactionName;
	}
	public Integer getRemainingBalance() {
		return remainingBalance;
	}
	public void setRemainingBalance(Integer remainingBalance) {
		this.remainingBalance = remainingBalance;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	

}
