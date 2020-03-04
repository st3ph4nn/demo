package com.cgi.bmg.demo.dao;

import com.cgi.bmg.demo.model.BankAccountModel;
import com.cgi.bmg.demo.model.TransactionModel;

public interface IBankAccountDao {

    BankAccountModel getBalance(BankAccountModel bankAccountModel);

    String sendTransaction(TransactionModel transactionModel);

}