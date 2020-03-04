package com.cgi.bmg.demo.service;

import com.cgi.bmg.demo.dao.IBankAccountDao;
import com.cgi.bmg.demo.model.BankAccountModel;
import com.cgi.bmg.demo.model.TransactionModel;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class TransactionService implements ITransactionService {

    @Resource
    IBankAccountDao bankAccountDao;

    @Override
    public BankAccountModel getBankAccount(BankAccountModel bankAccountModel) {
        return bankAccountDao.getBalance(bankAccountModel);
    }

    @Override
    public String sendTransaction(TransactionModel transaction) {
        return bankAccountDao.sendTransaction(transaction);
    }

}
