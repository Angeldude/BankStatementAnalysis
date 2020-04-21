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
    
    public void analyze(
            final String filename
            , final BankStatementCSVParser parser
            , final Exporter exporter) throws IOException {
        
        final Path path = Paths.get(RESOURCES + filename);
        final List<String> lines = Files.readAllLines(path);
        
        final List<BankTransaction> bankTransactions = 
                parser.parseLinesFromCSV(lines);
        
        final BankStatementProcessor bankStatementProcessor =
                new BankStatementProcessor(bankTransactions);
        
        final SummaryStatistics summaryStatistics = 
                bankStatementProcessor.summarizeTransactions();
        
        System.out.println(exporter.export(summaryStatistics));
    }
}