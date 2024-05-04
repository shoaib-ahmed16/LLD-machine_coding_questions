package com.machine.coding.LLDmachine_coding_questions.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SlotNotAvailableException extends RuntimeException{
    public SlotNotAvailableException(String message){
        super(message);
    }
}
