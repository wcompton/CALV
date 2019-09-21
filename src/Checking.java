/**
 * This class will create the object checking and maintain the overdraft fee
 * amount. It will also perform the dowithdraw function for checking
 * 
 * @author CALV
 */
public class Checking extends Account {

	private double overdraft;

	/** This method is the constructor checking @author CALV */
	Checking(double balance, String account) {
		setBalance(balance);
		setAccount(account);
		setOverDraft(45.00);
	}

	/**
	 * This method may perform withdraw functions in checking. This method appears
	 * to be a duplicate in Account Class and may not be necessary @author CALV
	 */
	public void doWithdraw(double amount, Checking checking) {
		double withdraw = amount;
		double balance = checking.getBalance();
		balance = balance - withdraw;

		if (balance < 0)
			checking.setBalance(balance - checking.getOverdraft());
		else
			checking.setBalance(balance);

	}

	/** This method is the getter for overdraft @author CALV */
	public double getOverdraft() {
		return overdraft;
	}

	/** This method is the setter for overdraft @author CALV */
	public void setOverDraft(double overdraft) {
		this.overdraft = overdraft;
	}

}
