package com.machine.coding.LLDmachine_coding_questions.splitwise.service;

import com.machine.coding.LLDmachine_coding_questions.splitwise.models.User;
import com.machine.coding.LLDmachine_coding_questions.splitwise.models.UserExpense;

public interface UserExpenseService {
    void addUserExpense(UserExpense userExpense);
    void updateUserExpense(UserExpense userExpense);

}
