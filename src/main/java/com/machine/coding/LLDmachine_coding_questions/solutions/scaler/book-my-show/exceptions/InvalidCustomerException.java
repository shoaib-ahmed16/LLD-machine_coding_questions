package com.machine.coding.LLDmachine_coding_questions.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InvalidCustomerException extends RuntimeException{
    public  InvalidCustomerException(String message){
        super(message);
    }
}
