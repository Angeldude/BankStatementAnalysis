/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vanegas.angel.csvchapter1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author angel
 */
public class BankStatementCSVParser {
    private static final DateTimeFormatter DATE_PATTERN = 
            DateTimeFormatter.ofPattern("dd-MM-yyyy");
    
    private BankTransaction parseFromCSV(final String line) {
        final String[] columns = line.split(",");
        final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
        final Double amount = Double.parseDouble(columns[1]);
        final String description = columns[2];
        
        return new BankTransaction(date, amount, description);
    }
    
    public List<BankTransaction> parseLinesFromCSV(final List<String> lines){
        return lines.stream().map(this::parseFromCSV).collect(toList());
    }
}
