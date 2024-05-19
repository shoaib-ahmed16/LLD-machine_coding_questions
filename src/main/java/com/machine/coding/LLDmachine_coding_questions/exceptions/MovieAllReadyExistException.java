package com.machine.coding.LLDmachine_coding_questions.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MovieAllReadyExistException extends RuntimeException{
    private final static String msg="The Movie is already Exist for the Name: ";
    public MovieAllReadyExistException(String message){
        super(msg+message);
    }
}
