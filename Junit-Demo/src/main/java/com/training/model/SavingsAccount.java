package com.training.model;

public class SavingsAccount {
    private String name;
    private  double balance;
    public SavingsAccount(String name, double balance){
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return this.name;
    }

    public double getBalance() {
        return this.balance;
    }

    public double withdraw(double amount) throws InsufficientBalanceException {
        if(amount <= this.getBalance()){
            this.setBalance(this.getBalance()-amount);
            return amount;
        }
        else throw new InsufficientBalanceException("Insufficient Balance");
    }

    private void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        this.setBalance(this.getBalance()+ amount);
    }
}
