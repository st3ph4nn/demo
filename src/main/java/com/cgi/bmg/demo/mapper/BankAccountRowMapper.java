package com.cgi.bmg.demo.mapper;

import com.cgi.bmg.demo.model.BankAccountModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BankAccountRowMapper implements RowMapper<BankAccountModel> {

    @Override
    public BankAccountModel mapRow(ResultSet rs, int arg1) throws SQLException {
        BankAccountModel bModel = new BankAccountModel();
        bModel.setBankAccountNr(rs.getString("bankaccountnr"));
        bModel.setBalance(rs.getDouble("balance"));
        return bModel;
    }

}
