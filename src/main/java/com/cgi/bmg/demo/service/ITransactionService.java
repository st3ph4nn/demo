package com.cgi.bmg.demo.service;

import com.cgi.bmg.demo.model.BankAccountModel;
import com.cgi.bmg.demo.model.TransactionModel;

public interface ITransactionService {

    BankAccountModel getBankAccount(BankAccountModel bankAccountModel);

    String sendTransaction(TransactionModel transaction);
}
