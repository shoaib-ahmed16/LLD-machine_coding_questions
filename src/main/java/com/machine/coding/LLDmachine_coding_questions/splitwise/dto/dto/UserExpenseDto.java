package com.machine.coding.LLDmachine_coding_questions.splitwise.dto.dto;

import com.machine.coding.LLDmachine_coding_questions.splitwise.enums.ExpenseType;
import com.machine.coding.LLDmachine_coding_questions.splitwise.models.Expense;
import com.machine.coding.LLDmachine_coding_questions.splitwise.models.User;
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
