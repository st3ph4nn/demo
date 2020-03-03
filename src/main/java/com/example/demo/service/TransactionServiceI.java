package com.example.demo.service;

import com.example.demo.model.BankAccountModel;
import com.example.demo.model.TransactionModel;

import java.util.List;

public interface TransactionServiceI {

    double getBalance(BankAccountModel bankAccountModel);
    List<TransactionModel> sendTransaction(TransactionModel transaction);
}
