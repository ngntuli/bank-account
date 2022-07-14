package main.java.ngntuli;

public class BankAccountTester {

	public static void main(String[] args) {
		String accountNumber;
		double amount;
		char reply;

		BankAccount acc1 = new BankAccount("1990", "Nkosinathi");
		BankAccount acc2 = new BankAccount("2017", "Uthando");

		do {
			System.out.println();
			System.out.println("*** Deposit ***");
			System.out.print("Enter account number: ");

			accountNumber = EasyScanner.nextString();

			if (accountNumber.equals(acc1.getAccountNumber()) || accountNumber.equals(acc2.getAccountNumber())) {
				System.out.print("Enter amount: ");
				amount = EasyScanner.nextDouble();
				if (accountNumber.equals(acc1.getAccountNumber())) {
					acc1.deposit(amount);
				} else {
					acc2.deposit(amount);
				}
			} else {
				System.out.println("Account does not exist");
			}

			System.out.print("Press [Y/n] if you wish to make another deposit: ");
			reply = EasyScanner.nextChar();
		} while (reply != 'N' && reply != 'n');

		displayAccountsDetails(acc1, acc2);
	}

	static void displayAccountsDetails(BankAccount... accounts) {
		for (BankAccount bankAccount : accounts) {
			System.out.println();
			System.out.println("######################################");
			System.out.println("Account number ==> " + bankAccount.getAccountNumber());
			System.out.println("Account name ==> " + bankAccount.getAccountName());
			System.out.println("Balance ==> " + bankAccount.getBalance());
			System.out.println("######################################");
		}

	}

}
