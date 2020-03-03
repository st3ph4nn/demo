package com.example.demo.service;

import com.example.demo.dao.BankAccountDaoI;
import com.example.demo.model.BankAccountModel;
import com.example.demo.model.TransactionModel;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class TransactionService implements  TransactionServiceI {

    @Resource
    BankAccountDaoI bankAccountDao;

    @Override
    public double getBalance(BankAccountModel bankAccountModel) {
        return bankAccountDao.getBalance(bankAccountModel);
    }

    @Override
    public List<TransactionModel> sendTransaction(TransactionModel transaction) {
        return bankAccountDao.sendTransaction(transaction);
    }

}
