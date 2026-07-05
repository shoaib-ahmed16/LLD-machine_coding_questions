package com.machine.coding.LLDmachine_coding_questions.splitwise.service.strategy;

import com.machine.coding.LLDmachine_coding_questions.splitwise.models.Split;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class EqualSplitStrategy
        implements SplitStrategy {

    @Override
    public void validate(
            BigDecimal totalAmount,
            List<Split> splits) {

        if (splits == null || splits.isEmpty()) {
            throw new IllegalArgumentException(
                    "Splits cannot be empty"
            );
        }
    }

    @Override
    public void calculate(
            BigDecimal totalAmount,
            List<Split> splits) {

        int totalUsers = splits.size();

        BigDecimal splitAmount =
                totalAmount.divide(
                        BigDecimal.valueOf(totalUsers),
                        2,
                        RoundingMode.DOWN
                );

        BigDecimal consumed =
                splitAmount.multiply(
                        BigDecimal.valueOf(totalUsers)
                );

        BigDecimal remainder =
                totalAmount.subtract(consumed);

        for (Split split : splits) {
            split.setAmount(splitAmount);
        }

        // add remainder to first user
        if (remainder.compareTo(BigDecimal.ZERO) > 0) {

            Split firstSplit = splits.get(0);

            firstSplit.setAmount(
                    firstSplit.getAmount()
                            .add(remainder)
            );
        }
    }
}