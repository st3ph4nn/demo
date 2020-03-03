package com.example.demo.dao;

import com.example.demo.model.BankAccountModel;
import com.example.demo.model.TransactionModel;

public interface BankAccountDaoI {

    BankAccountModel getBalance(BankAccountModel bankAccountModel);
    String sendTransaction(TransactionModel transactionModel);

}