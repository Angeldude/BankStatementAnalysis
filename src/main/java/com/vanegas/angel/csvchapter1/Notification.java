/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vanegas.angel.csvchapter1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author angel
 */
public class Notification {
    private final List<String> errors = new ArrayList<>();
    
    public void addError(String message){
        errors.add(message);
    }
    
    public boolean hasErrors(){
        return !errors.isEmpty();
    }
    
    public String errorMessage(){
        return errors.toString();
    }
    
    public List<String> getErrors(){
        return this.errors;
    }
}
