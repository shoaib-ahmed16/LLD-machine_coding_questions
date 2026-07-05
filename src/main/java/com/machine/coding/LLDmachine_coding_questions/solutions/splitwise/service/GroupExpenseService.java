package com.machine.coding.LLDmachine_coding_questions.solutions.splitwise.service;

import com.machine.coding.LLDmachine_coding_questions.solutions.splitwise.dto.GroupExpenseDto;

public interface GroupExpenseService {
     void addGroupExpenses(GroupExpenseDto dto);
     void updateGroupExpenses(GroupExpenseDto dto);

}
