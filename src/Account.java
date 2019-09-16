/**
 * This class will maintain the account balance and account number in string
 * format for each instance of account @author CALV
 */
public class Account {

	protected double balance;
	protected String account;

	/**
	 * This method will complete withdraw functions for checking and savings
	 * objects @author CALV
	 */
	public void withDraw(double amount) {
		balance = balance - amount;
	}

	/**
	 * This method will complete deposit functions for checking and savings
	 * objects @author CALV
	 */
	public void doDeposit(double amount) {
		balance = balance + amount;
	}

	/** This method is a getter method for the Balance @author CALV */
	public double getBalance() {
		return balance;
	}

	/** This method is a setter method for the Balance @author CALV */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/** This method is a getter method for the Account @author CALV */
	public String getAccount() {
		return account;
	}

	/** This method is a setter method for the Account @author CALV */
	public void setAccount(String account) {
		this.account = account;
	}
}
