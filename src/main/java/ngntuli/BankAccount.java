package main.java.ngntuli;

public class BankAccount {
    private final String accountNumber;
    private final String accountName;
    private double balance;

    public BankAccount(String accountNumber, String accountName) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        balance = 0;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amountIn) {
        balance = balance + amountIn;
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            return false;
        } else {
            balance = balance - amount;
            return true;
        }
    }
}
