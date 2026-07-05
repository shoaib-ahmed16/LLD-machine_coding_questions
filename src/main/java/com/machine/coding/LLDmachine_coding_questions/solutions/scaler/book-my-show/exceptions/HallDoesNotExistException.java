package com.machine.coding.LLDmachine_coding_questions.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class HallDoesNotExistException extends RuntimeException{
    public HallDoesNotExistException(String message){
        super(message);
    }
}
