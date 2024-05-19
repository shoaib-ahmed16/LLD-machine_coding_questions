package com.machine.coding.LLDmachine_coding_questions.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CustomerWithEmailAllreadyExistException extends RuntimeException {
    public CustomerWithEmailAllreadyExistException(String message){
        super(message);
    }
}
