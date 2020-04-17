/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vanegas.angel.csvchapter1;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author angel
 */
public class BankTransaction {
    private final LocalDate date;
    private final double amount;
    private final String description;
    
    public BankTransaction(final LocalDate date, final Double amount, final String description){
        this.date = date;
        this.amount = amount;
        this.description = description;
    }
    
    public LocalDate getDate(){
        return date;
    }
    
    public Double getAmount(){
        return amount;
    }
    
    public String getDescription(){
        return description;
    }
    
    @Override
    public String toString(){
        return "BankTransaction{" + "date=" + date + ", amount=" + amount + ", description="
                + description + '\'' + '}';
    }
    
    @Override
    public boolean equals(Object o){
     if(this == o) return true;
     if( o == null || getClass() != o.getClass()) return false;
     BankTransaction that = (BankTransaction) o;
     
     return Double.compare(that.amount, amount) == 0 && date.equals(that.date) && 
             description.equals(that.description);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + Objects.hashCode(this.date);
        hash = 19 * hash + (int) (Double.doubleToLongBits(this.amount) ^ (Double.doubleToLongBits(this.amount) >>> 32));
        hash = 19 * hash + Objects.hashCode(this.description);
        return hash;
    }
}
