/**
 * This class creates the object savings and maintains the variables service
 * fee, interest rate, and min balance functions @author CALV
 */
public class Savings extends Account {

	private double serviceFee;
	private double interestRate;
	private double minBalance;

	/** This method is the constructor for Savings @author CALV */
	public Savings(double balance, String account) {
		setBalance(balance);
		setAccount(account);
		setServiceFee(25.00);
		setMinBalance(200);
		setInterestRate(.06);
	}

	/** This method is the getter for service fees @author CALV */
	public double getServiceFee() {
		return serviceFee;
	}

	/** This method is the setter for service fees @author CALV */
	public void setServiceFee(double serviceFee) {
		this.serviceFee = serviceFee;
	}

	/** This method is the getter for interest rates @author CALV */
	public double getInterestRate() {
		return interestRate;
	}

	/** This method is the setter for interest rate @author CALV */
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	/** This method is the getter for min balance @author CALV */
	public double getMinBalance() {
		return minBalance;
	}

	/** This method is the setter for min balance @author CALV */
	public void setMinBalance(double minBalance) {
		this.minBalance = minBalance;
	}

}
