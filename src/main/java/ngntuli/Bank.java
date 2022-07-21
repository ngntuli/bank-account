package main.java.ngntuli;

import java.util.ArrayList;

public class Bank {
    ArrayList<BankAccount> list = new ArrayList<>();

    private int search(String accountNumberIn) {
        for (int i = 0; i <= list.size() - 1; i++) {
            BankAccount tempAccount = list.get(i);
            String tempNumber = tempAccount.getAccountNumber();

            if (tempNumber.equals(accountNumberIn)) {
                return i;
            }
        }
        return -999;
    }

    public int getTotal() {
        return list.size();
    }

    public BankAccount getItem(String accountNumberIn) {
        int index = search(accountNumberIn);
        if (index != -999) {
            return list.get(index);
        } else {
            return null;
        }
    }

    public boolean addAccount(String accountNumberIn, String nameIn) {
        if (search(accountNumberIn) == -999) {
            list.add(new BankAccount(accountNumberIn, nameIn));
            return true;
        }
        return false;
    }

    public boolean depositMoney(String accountNumberIn, double amountIn) {
        BankAccount acc = getItem(accountNumberIn);
        if (acc != null) {
            acc.deposit(amountIn);
            return true;
        } else {
            return false;
        }
    }

    public boolean withdrawMoney(String accountNumberIn, double amountIn) {
        BankAccount acc = getItem(accountNumberIn);
        if (acc != null && acc.getBalance() >= amountIn) {
            acc.withdraw(amountIn);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeAccount(String accountNumberIn) {
        int index = search(accountNumberIn);
        if (index != -999) {
            list.remove(index);
            return true;
        } else {
            return false;
        }
    }
}
