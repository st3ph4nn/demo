package com.example.demo.controller;

import com.example.demo.model.BankAccountModel;
import com.example.demo.model.TransactionModel;
import com.example.demo.service.TransactionServiceI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TransactionsController {

    @Resource
    TransactionServiceI transactionService;

    @CrossOrigin(origins = "http://localhost:8000")
    @GetMapping(path = "/getbalance")
    public ResponseEntity<Double> getBankAccountBalance(BankAccountModel bankAccount){
        return ResponseEntity.ok(transactionService.getBalance(bankAccount));
    }

    @PostMapping(path = "/transaction", consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<TransactionModel>> getUserByUserName(@RequestBody TransactionModel transaction) {
        return ResponseEntity.ok(transactionService.sendTransaction(transaction));
    }



}
