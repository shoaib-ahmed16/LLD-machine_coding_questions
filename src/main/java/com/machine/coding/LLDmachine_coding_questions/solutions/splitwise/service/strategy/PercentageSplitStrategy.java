package com.machine.coding.LLDmachine_coding_questions.solutions.splitwise.service.strategy;

import com.machine.coding.LLDmachine_coding_questions.solutions.splitwise.models.PercentageSplit;
import com.machine.coding.LLDmachine_coding_questions.solutions.splitwise.models.Split;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
public class PercentageSplitStrategy
        implements SplitStrategy {

    @Override
    public void validate(
            BigDecimal totalAmount,
            List<Split> splits) {

        BigDecimal percentageTotal =
                BigDecimal.ZERO;

        for (Split split : splits) {

            PercentageSplit percentageSplit =
                    (PercentageSplit) split;

            percentageTotal =
                    percentageTotal.add(
                            percentageSplit.getPercentage()
                    );
        }

        if (percentageTotal.compareTo(
                BigDecimal.valueOf(100)) != 0) {

            throw new IllegalArgumentException(
                    "Percentage should total 100"
            );
        }
    }

    @Override
    public void calculate(
            BigDecimal totalAmount,
            List<Split> splits) {

        BigDecimal totalCalculated =
                BigDecimal.ZERO;

        for (int i = 0; i < splits.size(); i++) {

            PercentageSplit split =
                    (PercentageSplit) splits.get(i);

            BigDecimal amount =
                    totalAmount.multiply(
                            split.getPercentage()
                    ).divide(
                            BigDecimal.valueOf(100),
                            2,
                            RoundingMode.DOWN
                    );

            split.setAmount(amount);

            totalCalculated =
                    totalCalculated.add(amount);
        }

        // handle remainder
        BigDecimal remainder =
                totalAmount.subtract(totalCalculated);

        if (remainder.compareTo(BigDecimal.ZERO) > 0) {

            Split firstSplit = splits.get(0);

            firstSplit.setAmount(
                    firstSplit.getAmount()
                            .add(remainder)
            );
        }
    }
}