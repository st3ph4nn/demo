package com.example.demo.dao;

import com.example.demo.model.BankAccountModel;
import com.example.demo.model.TransactionModel;

import java.util.List;

public interface BankAccountDaoI {

    double getBalance(BankAccountModel bankAccountModel);
    List<TransactionModel> sendTransaction(TransactionModel transactionModel);

}