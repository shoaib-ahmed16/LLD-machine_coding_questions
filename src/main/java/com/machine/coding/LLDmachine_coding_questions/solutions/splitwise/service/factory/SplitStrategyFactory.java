package com.machine.coding.LLDmachine_coding_questions.solutions.splitwise.service.factory;

import com.machine.coding.LLDmachine_coding_questions.solutions.splitwise.enums.SplitType;
import com.machine.coding.LLDmachine_coding_questions.solutions.splitwise.service.strategy.ExactSplitStrategy;
import com.machine.coding.LLDmachine_coding_questions.solutions.splitwise.service.strategy.PercentageSplitStrategy;
import com.machine.coding.LLDmachine_coding_questions.solutions.splitwise.service.strategy.SplitStrategy;
import com.machine.coding.LLDmachine_coding_questions.solutions.splitwise.service.strategy.EqualSplitStrategy;

public class SplitStrategyFactory {

    public static SplitStrategy getStrategy(SplitType type) {

        return switch (type) {
            case EQUAL -> new EqualSplitStrategy();
            case EXACT -> new ExactSplitStrategy();
            case PERCENTAGE ->
                    new PercentageSplitStrategy();
        };
    }
}
