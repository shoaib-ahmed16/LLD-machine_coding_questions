package com.machine.coding.LLDmachine_coding_questions.solutions.splitwise.models;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public abstract class Split {

    protected User user;
    protected BigDecimal amount;
}
