package com.npichuzhkin.javacodepractice.javaconcurrency.topic11;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class ConcurrentBank {

    private static List<BankAccount> accounts;

    private static final Object lock = new Object();

    public ConcurrentBank(){
        accounts = new LinkedList<>();
    }

    public BankAccount createAccount(BigDecimal balance){
        BankAccount newBankAccount = new BankAccount(balance);
        accounts.add(newBankAccount);
        return newBankAccount;
    }

    public void transfer(BankAccount acc1, BankAccount acc2, BigDecimal amount){
        synchronized (lock){
            acc1.withdraw(amount);
            acc2.deposit(amount);
        }
    }

    public BigDecimal getTotalBalance(){
        return accounts.stream().map(BankAccount::getBalance)
                                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
