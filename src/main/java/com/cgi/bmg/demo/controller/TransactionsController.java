package com.cgi.bmg.demo.controller;

import com.cgi.bmg.demo.model.BankAccountModel;
import com.cgi.bmg.demo.model.TransactionModel;
import com.cgi.bmg.demo.service.ITransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin(origins = "http://localhost:8000")
@RestController
public class TransactionsController {

    @Resource
    ITransactionService transactionService;

    @GetMapping(path = "/getbalance")
    public ResponseEntity getBankAccountBalance(BankAccountModel bankAccount) {
        // TODO: create custom exceptions getBankAccountBalance
        try {
            return ResponseEntity.ok(transactionService.getBankAccount(bankAccount));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Something is going wrong ");
        }
    }

    @PostMapping(path = "/transaction", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> sendTransaction(@RequestBody TransactionModel transaction) {
        // TODO: create custom exceptions sendTransaction


        return ResponseEntity.ok(transactionService.sendTransaction(transaction));
    }

}
