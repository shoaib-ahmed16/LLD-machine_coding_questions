package com.machine.coding.LLDmachine_coding_questions.splitwise.service.factory;

import com.machine.coding.LLDmachine_coding_questions.splitwise.enums.SplitType;
import com.machine.coding.LLDmachine_coding_questions.splitwise.service.strategy.EqualSplitStrategy;
import com.machine.coding.LLDmachine_coding_questions.splitwise.service.strategy.ExactSplitStrategy;
import com.machine.coding.LLDmachine_coding_questions.splitwise.service.strategy.PercentageSplitStrategy;
import com.machine.coding.LLDmachine_coding_questions.splitwise.service.strategy.SplitStrategy;

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
