
public class BankTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Bank bank = new Bank("GCU");
		Checking check = new Checking(5000.00, "991773");
		Savings save = new Savings(5000.00, "191923");

		bank.displayMenu(check, save);

	}

}
