package com.machine.coding.LLDmachine_coding_questions.splitwise.dto.dto;

import com.machine.coding.LLDmachine_coding_questions.splitwise.enums.ExpenseStatus;
import com.machine.coding.LLDmachine_coding_questions.splitwise.models.User;
import com.machine.coding.LLDmachine_coding_questions.splitwise.models.UserExpense;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseDto {

    private String description;
    private Double totalAmount;
    private String currencyCode;
    private List<User> users = new ArrayList<>();
    private List<UserExpense> paidBy = new ArrayList<>();
    private List<UserExpense> owedBy = new ArrayList<>();
    private ExpenseStatus status;
}
