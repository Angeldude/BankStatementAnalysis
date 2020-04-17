/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vanegas.angel.csvchapter1;

import java.time.Month;
import java.util.List;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author angel
 */
public class BankStatementProcessor {
    private final List<BankTransaction> bankTransactions;
    
    public BankStatementProcessor(List<BankTransaction> bankTransactions){
        this.bankTransactions = bankTransactions;
    }
    
    public double calculateTotalAmount(){
       return bankTransactions.stream().map(trans -> trans.getAmount())
               .reduce(0d, (acc, amount) -> acc + amount);
    }
    
    public List<BankTransaction> findTransactions(BankTransactionFilter transactionFilter){
        return bankTransactions.stream().filter(trans -> transactionFilter.test(trans))
                .collect(toList());
    }
}
