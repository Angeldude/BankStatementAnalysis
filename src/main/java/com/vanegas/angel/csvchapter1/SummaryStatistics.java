/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vanegas.angel.csvchapter1;

/**
 *
 * @author angel
 */
public class SummaryStatistics {
    private final double sum;
    private final double max;
    private final double min;
    private final double average;
    
    public SummaryStatistics(double sum, double max, double min, double average){
        this.sum = sum;
        this.max = max;
        this.average = average;
        this.min = min;
    }
    
    public double getSum(){
        return this.sum;
    }
    
    public double getMin(){
        return this.min;
    }
    
    public double getMax(){
        return this.max;
    }
    
    public double getAverage(){
        return this.average;
    }
}
