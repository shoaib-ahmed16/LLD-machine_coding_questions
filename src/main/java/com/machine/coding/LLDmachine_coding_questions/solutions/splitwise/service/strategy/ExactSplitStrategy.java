package com.machine.coding.LLDmachine_coding_questions.solutions.splitwise.service.strategy;

import com.machine.coding.LLDmachine_coding_questions.solutions.splitwise.models.Split;

import java.math.BigDecimal;
import java.util.List;

public class ExactSplitStrategy
        implements SplitStrategy {

    @Override
    public void validate(
            BigDecimal totalAmount,
            List<Split> splits) {

        BigDecimal total = splits.stream()
                .map(Split::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        if (total.compareTo(totalAmount) != 0) {

            throw new IllegalArgumentException(
                    "Invalid exact split"
            );
        }
    }

    @Override
    public void calculate(
            BigDecimal totalAmount,
            List<Split> splits) {

        // No calculation needed
        // amounts already provided
    }
}