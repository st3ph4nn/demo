package com.cgi.bmg.demo.controller;

import com.cgi.bmg.demo.model.BankAccountModel;
import com.cgi.bmg.demo.model.TransactionModel;
import com.cgi.bmg.demo.service.ITransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Endpoint for retrieval of balance and sending an transaction
 */
@CrossOrigin(origins = "http://localhost:8000")
@RestController
public class TransactionsController {

    @Resource
    ITransactionService transactionService;

    /**
     * Get balance for a certain bankaccount
     * @param bankAccount
     * @return BankAccountModel
     */
    @GetMapping(path = "/getbalance")
    public ResponseEntity getBankAccountBalance(BankAccountModel bankAccount) {
        // TODO: create custom exceptions getBankAccountBalance
        try {
            return ResponseEntity.ok(transactionService.getBankAccount(bankAccount));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Cannot get balance at the moment");
        }
    }

    /**
     * send a transacction from a bankaccount to another certain amount
     * @param transaction
     * @return if the transaction was succesful or not
     */
    @PostMapping(path = "/transaction", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> sendTransaction(@RequestBody TransactionModel transaction) {
        // TODO: create custom exceptions sendTransaction
        try {
            return ResponseEntity.ok(transactionService.sendTransaction(transaction));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Cannot send transaction");
        }
    }

}
