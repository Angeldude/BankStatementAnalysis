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
    
    public double summarizeTransactions(final BankTransactionSummarizer bankTransSummary){
        double result = 0;
        for(final BankTransaction bankTransaction : bankTransactions){
            result = bankTransSummary.summarize(result, bankTransaction);
        }
        return result;
    }
    
    public double calculateTotalInMonth(final Month month){
       return summarizeTransactions((acc, trans) -> 
            month == trans.getDate().getMonth() ? acc + trans.getAmount() : acc);
    }
    
    public List<BankTransaction> findTransactions(final BankTransactionFilter transactionFilter){
        return bankTransactions.stream().filter(trans -> transactionFilter.test(trans))
                .collect(toList());
    }
    
    public List<BankTransaction> findTransactionsGreaterThanEquals(final double amount){
        return findTransactions(trans -> trans.getAmount() >= amount);
    }
}
