package main.java.ngntuli;

import java.util.ArrayList;

public class Bank {
    ArrayList<BankAccount> list = new ArrayList<>();

    private int search(String accountNumber) {
        for (int i = 0; i <= list.size() - 1; i++) {
            BankAccount tempAccount = list.get(i);
            String tempNumber = tempAccount.getAccountNumber();

            if (tempNumber.equals(accountNumber)) {
                return i;
            }
        }
        return -999;
    }

    public int getTotal() {
        return list.size();
    }

    public BankAccount getItem(String accountNumber) {
        int index = search(accountNumber);
        if (index != -999) {
            return list.get(index);
        } else {
            return null;
        }
    }

    public boolean addAccount(String accountNumber, String name) {
        if (search(accountNumber) == -999) {
            list.add(new BankAccount(accountNumber, name));
            return true;
        }
        return false;
    }

    public boolean depositMoney(String accountNumber, double amount) {
        BankAccount acc = getItem(accountNumber);
        if (acc != null) {
            acc.deposit(amount);
            return true;
        } else {
            return false;
        }
    }

    public boolean withdrawMoney(String accountNumber, double amount) {
        BankAccount acc = getItem(accountNumber);
        if (acc != null && acc.getBalance() >= amount) {
            acc.withdraw(amount);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeAccount(String accountNumber) {
        int index = search(accountNumber);
        if (index != -999) {
            list.remove(index);
            return true;
        } else {
            return false;
        }
    }
}
