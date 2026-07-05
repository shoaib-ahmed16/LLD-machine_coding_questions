package com.machine.coding.LLDmachine_coding_questions.solutions.splitwise.service.strategy;

import com.machine.coding.LLDmachine_coding_questions.solutions.splitwise.models.Split;

import java.math.BigDecimal;
import java.util.List;

public interface SplitStrategy {

    void validate(
            BigDecimal totalAmount,
            List<Split> splits
    );

    void calculate(
            BigDecimal totalAmount,
            List<Split> splits
    );
}
