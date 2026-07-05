package com.machine.coding.LLDmachine_coding_questions.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SeatNotAvailableException extends RuntimeException{
    public SeatNotAvailableException(String message){
        super(message);
    }
}
