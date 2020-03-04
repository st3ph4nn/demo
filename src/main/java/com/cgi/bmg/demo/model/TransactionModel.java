package com.cgi.bmg.demo.model;

public class TransactionModel {

    private BankAccountModel fromBankAccount;
    private BankAccountModel toBankAccount;
    private double amount;

    public BankAccountModel getFromBankAccount() {
        return fromBankAccount;
    }

    public void setFromBankAccount(BankAccountModel fromBankAccount) {
        this.fromBankAccount = fromBankAccount;
    }

    public BankAccountModel getToBankAccount() {
        return toBankAccount;
    }

    public void setToBankAccount(BankAccountModel toBankAccount) {
        this.toBankAccount = toBankAccount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
