package com.example.demo.dao;

import com.example.demo.mapper.BankAccountRowMapper;
import com.example.demo.model.BankAccountModel;
import com.example.demo.model.TransactionModel;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
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
    public BankAccountModel getBalance(BankAccountModel bankAccountModel) {
        final String SELECT_BY_BANKACCOUNTNR = "select * from bankaccount where bankaccountnr =:bankaccountnr";
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("bankaccountnr", bankAccountModel.getBankAccountNr());
        List<BankAccountModel> bankAccountModelList = template.query(SELECT_BY_BANKACCOUNTNR, param, new BankAccountRowMapper());
        return bankAccountModelList.get(0);
    }

    @Override
    public String sendTransaction(TransactionModel transactionModel) {
        final String INSERT_TRANSACTION = "insert into transactions (bankaccountnr, amount, tobankaccountnr) " +
                "values (:bankaccountnr, :amount, :tobankaccountnr)";
        final String GET_TRANSACTIONS = "select * from transactions where bankaccountnr =:fromBankAccount";
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource sqlParamInsertTransaction = new MapSqlParameterSource()
                .addValue("bankaccountnr", transactionModel.getFromBankAccount().getBankAccountNr())
                .addValue("amount", transactionModel.getAmount())
                .addValue("tobankaccountnr", transactionModel.getToBankAccount().getBankAccountNr());
        template.update(INSERT_TRANSACTION,sqlParamInsertTransaction, holder);

        return "transaction completed";
    }
}
