package org.followmay;

public class BankAccount {

    private double balance = 0;

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        validateAmount(amount);
        balance += amount;
    }

    public void withdraw(double amount) {
        validateAmount(amount);
        if (balance < amount) {
            throw new IllegalArgumentException("Insufficient Balance");
        }
        balance -= amount;
    }

    private static void validateAmount(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
    }
}
