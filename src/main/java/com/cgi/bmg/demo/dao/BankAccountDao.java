package com.cgi.bmg.demo.dao;

import com.cgi.bmg.demo.mapper.BankAccountRowMapper;
import com.cgi.bmg.demo.model.BankAccountModel;
import com.cgi.bmg.demo.model.TransactionModel;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Data Access ofject to get data from database
 */
@Repository
public class BankAccountDao implements IBankAccountDao {

    final NamedParameterJdbcTemplate template;

    public BankAccountDao(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    /**
     * get bank account information for a certain bankaccoutnr
     * @param bankAccountModel
     * @return bankAccountModel
     */
    @Override
    public BankAccountModel getBalance(BankAccountModel bankAccountModel) {
        final String SELECT_BY_BANKACCOUNTNR = "select * from bankaccount where bankaccountnr =:bankaccountnr";
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("bankaccountnr", bankAccountModel.getBankAccountNr());
        List<BankAccountModel> bankAccountModelList = template.query(SELECT_BY_BANKACCOUNTNR, param, new BankAccountRowMapper());
        return bankAccountModelList.get(0);
    }

    /**
     * update transactions tabel with a bankaccountnr that sends an amount X to another bankaccountnr.
     * @param transactionModel
     * @return String
     */
    @Override
    public String sendTransaction(TransactionModel transactionModel) {
        final String INSERT_TRANSACTION = "insert into transactions (bankaccountnr, amount, tobankaccountnr) " +
                "values (:bankaccountnr, :amount, :tobankaccountnr)";
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource sqlParamInsertTransaction = new MapSqlParameterSource()
                .addValue("bankaccountnr", transactionModel.getFromBankAccount().getBankAccountNr())
                .addValue("amount", transactionModel.getAmount())
                .addValue("tobankaccountnr", transactionModel.getToBankAccount().getBankAccountNr());
        template.update(INSERT_TRANSACTION, sqlParamInsertTransaction, holder);

        return "transaction completed";
    }
}
