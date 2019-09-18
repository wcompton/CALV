import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Bank class will perform the display functions and allow end user interface to
 * perform the functionality contained within all classes and methods @author
 * CALV
 */
public class Bank {

	private String name = "GCU";
	Scanner sc = new Scanner(System.in);
	DecimalFormat DF = new DecimalFormat("0.00");

	/** This method is the constructor for the bank @author CALV */
	public Bank(String name) {

	}

	/**
	 * The displayMenu method is the display for the bank interface with the end
	 * user @author CALV
	 */
	protected void displayMenu(Checking checking, Savings savings) {

		int option;
		do {
			System.out.println("===================================");
			System.out.println(" MAIN MENU");
			System.out.println(" " + this.name.toUpperCase());
			System.out.println("===================================");
			System.out.println("Pick an option: ");
			System.out.println("---------------------");
			System.out.println(" 1: : Deposit to Checking");
			System.out.println(" 2: : Deposit to Savings");
			System.out.println(" 3: : Write a Check");
			System.out.println(" 4: : Withdraw from Savings");
			System.out.println(" 5: : Get balance");
			System.out.println(" 6: : Close month");
			System.out.println("---------------------");
			System.out.println(" 9: : Exit");
			option = sc.nextInt();
			this.doMenuAction(option, checking, savings);
		} while (option != 9);
	}

	/**
	 * This method will take the integer input from the end user, and translate it
	 * into a function for the program @author CALV
	 */
	private void doMenuAction(int option, Checking checking, Savings savings) {

		switch (option) {
		case 1:
			displayDepositChecking(checking);
			break;
		case 2:
			displayDepositSavings(savings);
			break;
		case 3:
			displayWithdrawChecking(checking);
			break;
		case 4:
			displayWithdrawSavings(savings);
			break;
		case 5:
			displayBalanceScreen(checking, savings);
			break;
		case 6:
			doEndMonth(checking, savings);
			break;
		case 9:
			displayExitScreen();
			break;
		default:
			System.out.println("INPUT ERROR");
			break;
		}
	}

	/**
	 * This method will perform a month end report for the end user
	 * 
	 * @author CALV
	 */
	protected void doEndMonth(Checking checking, Savings savings) {
		double rate = savings.getInterestRate();
		double fee = savings.getServiceFee();

		if (savings.balance < 200) {
			System.out.println("Savings balance is below $200");
			System.out.println("A service fee of $" + DF.format(fee) + " has been charged to your account.");
			savings.balance = savings.balance - 25;
		}
		double amount = savings.balance * rate * .083333;

		if (savings.balance > 0) {
			savings.balance = savings.balance + amount;
			System.out.println("You earned $" + DF.format(amount) + " on your Savings account!");
		}
	}

	/**
	 * This method will contain the functionality of option 9 in the user interface
	 * for exit @author CALV
	 */
	protected void displayExitScreen() {
		System.out.println("You have succesfully exited the system");
	}

	/**
	 * This method will display the checking and savings balance when the end user
	 * enters 5 in the interface, and after they make a withdraw or deposit @author
	 * CALV
	 */
	protected void displayBalanceScreen(Checking checking, Savings savings) {

		double checkBalance = checking.getBalance();
		double saveBalance = savings.getBalance();
		String checkAccount = checking.getAccount();
		String saveAccount = savings.getAccount();

		System.out.println("Your Checking **" + checkAccount.substring(checkAccount.length() - 4) + " balance is $"
				+ DF.format(checkBalance) + "!");
		System.out.println("Your Savings **" + saveAccount.substring(saveAccount.length() - 4) + " balance is $"
				+ DF.format(saveBalance) + "!");
	}

	/**
	 * This method will display the savings balance, provide a warning to the user
	 * about the minimum balance, and request a withdraw amount form the
	 * user @author CALV
	 */
	protected void displayWithdrawSavings(Savings savings) {

		double serviceFee = savings.getServiceFee();
		double minBalance = savings.getMinBalance();
		double balance = savings.getBalance();
		String account = savings.getAccount();

		double savingsWithdraw;
		System.out.println("WITHDRAW from Savings Account number **" + account.substring(account.length() - 4));
		System.out.println("Your Savings Account balance is $" + DF.format(balance));
		System.out.println("You will have a $" + DF.format(serviceFee) + " if the balance is below $"
				+ DF.format(minBalance) + " at the end of the month.");
		System.out.println("How much would you like to withdraw?");

		savingsWithdraw = sc.nextDouble();
		savings.withDraw(savingsWithdraw);
	}

	/**
	 * This method will display the checking balance, provide a warning to the user
	 * about overdraft fees, and request a withdraw amount form the user. If an
	 * overdraft occurs it will display an overdraft notice @author CALV
	 */
	protected void displayWithdrawChecking(Checking checking) {

		double overDraft = checking.getOverdraft();
		double balance = checking.getBalance();
		String account = checking.getAccount();

		double checkingWithdraw;
		System.out.println("WITHDRAW from Checking Account number **" + account.substring(account.length() - 4));
		System.out.println("Your Checking Account balance is $" + DF.format(balance));
		System.out.println(
				"You will have a $" + DF.format(overDraft) + " if the check amount is greater than your balance.");
		System.out.println("How much would you like to withdraw?");

		checkingWithdraw = sc.nextDouble();
		checking.doWithdraw(checkingWithdraw);
	}

	/**
	 * This method will display the current balance, account number, and request to
	 * know how much the user would like to deposit @author CALV
	 */
	protected void displayDepositSavings(Savings savings) {

		double balance2 = savings.getBalance();
		String account2 = savings.getAccount();

		double savingsDeposit;
		System.out.println("DEPOSIT into Savings Account number **" + account2.substring(account2.length() - 4));
		System.out.println("Your Savings balance is $" + DF.format(balance2));
		System.out.println("How much would you like to deposit?");

		savingsDeposit = sc.nextDouble();
		savings.doDeposit(savingsDeposit);
	}

	/**
	 * This method will display the current balance, account number, and request to
	 * know how much the user would like to deposit @author CALV
	 */
	protected void displayDepositChecking(Checking checking) {

		double balance = checking.getBalance();
		String account = checking.getAccount();
		double checkingDeposit;

		System.out.println("DEPOSIT into Checking Account number **" + account.substring(account.length() - 4));
		System.out.println("Your Checking balance is $" + DF.format(balance));
		System.out.println("How much would you like to deposit?");

		checkingDeposit = sc.nextDouble();
		checking.doDeposit(checkingDeposit);
	}
}