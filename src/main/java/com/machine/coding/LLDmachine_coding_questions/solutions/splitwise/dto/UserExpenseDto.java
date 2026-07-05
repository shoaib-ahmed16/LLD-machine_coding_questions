package com.machine.coding.LLDmachine_coding_questions.solutions.splitwise.dto;

import com.machine.coding.LLDmachine_coding_questions.solutions.splitwise.enums.ExpenseType;
import com.machine.coding.LLDmachine_coding_questions.solutions.splitwise.models.Expense;
import com.machine.coding.LLDmachine_coding_questions.solutions.splitwise.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserExpenseDto {

    private User user;
    private Expense expense;
    private Double amount;
    private ExpenseType type;


}
