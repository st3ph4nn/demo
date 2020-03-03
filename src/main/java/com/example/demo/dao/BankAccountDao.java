package com.example.demo.dao;

import com.example.demo.mapper.BankAccountRowMapper;
import com.example.demo.model.BankAccountModel;
import com.example.demo.model.TransactionModel;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BankAccountDao implements BankAccountDaoI {

    NamedParameterJdbcTemplate template;

    public BankAccountDao(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    @Override
    public double getBalance(BankAccountModel bankAccountModel) {
        final String SELECT_BY_BANKACCOUNTNR = "select * from bankaccount where bankaccountnr =:bankaccountnr";
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("bankaccountnr", bankAccountModel.getBankAccountNr());
        List<BankAccountModel> bankAccountModelList = template.query(SELECT_BY_BANKACCOUNTNR, param, new BankAccountRowMapper());
        return bankAccountModelList.get(0).getBalance();
    }

    @Override
    public List<TransactionModel> sendTransaction(TransactionModel transactionModel) {
//        final String SELECT_BY_BANKACCOUNTNR = "select * from transactions where bankaccountnr=:bankaccountnr";
//        SqlParameterSource param = new MapSqlParameterSource()
//                .addValue("bankaccountnr", bankAccountModel.getBankAccountNr());
//        List<TransactionModel> bankAccountModelList = template.query(SELECT_BY_BANKACCOUNTNR, new BankAccountRowMapper());
        return new ArrayList<TransactionModel>();
    }
}
