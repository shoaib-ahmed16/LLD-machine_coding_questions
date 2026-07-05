package com.machine.coding.LLDmachine_coding_questions.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MissMatchException  extends RuntimeException{
    public MissMatchException(String message){
        super(message);
    }
}
