package com.npichuzhkin.javacodepractice.javaconcurrency.topic11;

import java.math.BigDecimal;

public class BankAccount {

    private BigDecimal balance;

    public BankAccount(BigDecimal balance){
        this.balance = balance;
    }

    public void deposit(BigDecimal amount){
        balance = balance.add(amount);
    }
    public void withdraw(BigDecimal amount){
        if (balance.compareTo(amount) < 0) throw new IllegalStateException("Insufficient funds");
        balance = balance.subtract(amount);
    }
    public BigDecimal getBalance(){
        return balance;
    }
}
