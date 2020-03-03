package com.example.demo.service;

import com.example.demo.model.BankAccountModel;
import com.example.demo.model.TransactionModel;

public interface TransactionServiceI {

    BankAccountModel getBankAccount(BankAccountModel bankAccountModel);
    String sendTransaction(TransactionModel transaction);
}
