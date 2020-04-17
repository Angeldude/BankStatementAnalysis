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
                + processor.calculateTotalAmount());
        
        var coop = processor.findTransactions(trans -> trans.getDate().getMonth() == Month.JANUARY);
        System.out.println("The transactions for January is: " 
                + new BankStatementProcessor(coop).calculateTotalAmount());
        
        var poop = processor.findTransactions(trans -> trans.getDate().getMonth() == Month.FEBRUARY);
        System.out.println("The transactions for February is: " 
                + new BankStatementProcessor(poop).calculateTotalAmount());
        
        var soop = processor.findTransactions(trans -> "Salary".equals(trans.getDescription()));
        System.out.println("The total salary received is: " 
                + new BankStatementProcessor(soop).calculateTotalAmount());
    }
}
