package model.entities;

import exceptions.DomainException;

public class Account {
    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account() {
    }

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit(Double amount){
        this.balance += amount;
    }

    public void withdraw(Double amount) {
        validateWithdraw(amount);
        this.balance -= amount;

    }

    public void validateWithdraw(Double amount){
        if (amount > getWithdrawLimit() && amount > balance) {
            throw new DomainException("Not enough balance and the amount also exceeds withdraw limit");
        } else if (amount > getWithdrawLimit()) {
            throw new DomainException("The amount exceeds withdraw limit!");
        } else if (amount > this.balance) {
            throw new DomainException("Not enough balance");
        }
    }

}
