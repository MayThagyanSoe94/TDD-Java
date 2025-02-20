package org.followmay;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankAccountTest {

    @Test
    public void newAccountHaveZeroBalance() {
        BankAccount bankAccount = new BankAccount();
        Assertions.assertEquals(0, bankAccount.getBalance());
    }

    @Test
    public void testDeposit() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.deposit(200);
        Assertions.assertEquals(200, bankAccount.getBalance());
    }

    @Test
    public void testWithdraw() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.deposit(200);
        bankAccount.withdraw(100);
        Assertions.assertEquals(100, bankAccount.getBalance());
    }

    @Test
    public void testOverDraft() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.deposit(200);
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            bankAccount.withdraw(300);
        });
        Assertions.assertEquals("Insufficient Balance", exception.getMessage());
    }

    @Test
    public void testNegativeDeposit() {
        BankAccount bankAccount = new BankAccount();
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            bankAccount.deposit(-200);
        });
        Assertions.assertEquals("Amount must be positive", exception.getMessage());
    }

    @Test
    public void testNegativeWithdraw() {
        BankAccount bankAccount = new BankAccount();
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            bankAccount.withdraw(-100);
        });
        Assertions.assertEquals("Amount must be positive", exception.getMessage());
    }
}
