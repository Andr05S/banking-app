package Classes;

public class User {

	private String username;
	private String password;
	private Account checking;
	private Account savings;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Account getChecking() {
		return checking;
	}
	public void setChecking(Account checking) {
		this.checking = checking;
	}
	public Account getSavings() {
		return savings;
	}
	public void setSavings(Account savings) {
		this.savings = savings;
	}
	
}
