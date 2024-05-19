package com.machine.coding.LLDmachine_coding_questions.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ShowNotFoundException extends RuntimeException{
    public ShowNotFoundException(String message){
        super(message);
    }
}
