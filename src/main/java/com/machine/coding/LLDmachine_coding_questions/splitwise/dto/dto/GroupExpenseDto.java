package com.machine.coding.LLDmachine_coding_questions.splitwise.dto.dto;

import com.machine.coding.LLDmachine_coding_questions.splitwise.models.Expense;
import com.machine.coding.LLDmachine_coding_questions.splitwise.models.Group;
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
