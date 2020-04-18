/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vanegas.angel.csvchapter1;

import java.io.IOException;
import java.nio.file.*;
import java.time.Month;
import java.util.List;
/**
 *
 * @author angel
 */
public class BankStatementAnalyzer {
    private static final String RESOURCES = "src/main/resources/";
    private static final BankStatementCSVParser bankStatementParser = 
                new BankStatementCSVParser();
    
    public static void main(final String... args) throws IOException {
        
        final Path path = Paths.get(RESOURCES + args[0]);
        final List<String> lines = Files.readAllLines(path);
        
        final List<BankTransaction> bankTransactions = 
                bankStatementParser.parseLinesFromCSV(lines);
        
        final BankStatementProcessor bankStatementProcessor =
                new BankStatementProcessor(bankTransactions);
        
        collectSummary(bankStatementProcessor);
    }
    
    private static void collectSummary(BankStatementProcessor processor){
        System.out.println("The total for all transactions is: " 
                + processor.summarizeTransactions((acc, trans)-> 
                acc + trans.getAmount()));
        
        System.out.println("The transactions for January is: " 
                + processor.calculateTotalInMonth(Month.JANUARY));
        
        System.out.println("The transactions for February is: " 
                + processor.calculateTotalInMonth(Month.FEBRUARY));
        
        var soop = processor.findTransactions(trans -> "Salary".equals(trans.getDescription()));
        System.out.println("The total salary received is: " 
                + new BankStatementProcessor(soop).summarizeTransactions((acc, trans) ->
                acc + trans.getAmount()));
    }
}
