package com.machine.coding.LLDmachine_coding_questions.solutions.splitwise.dto;

import com.machine.coding.LLDmachine_coding_questions.solutions.splitwise.models.Expense;
import com.machine.coding.LLDmachine_coding_questions.solutions.splitwise.models.Group;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GroupExpenseDto {
    private Group group;
    private Expense expense;
}
