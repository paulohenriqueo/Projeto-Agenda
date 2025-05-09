package com.fatec.contact.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationErros extends StandardError {
    
    private List<String> errors = new ArrayList<>();

    public void addError(String error){
        this.errors.add(error);
    }
    public List<String> getErrors(){
        return this.errors;
    }

}
