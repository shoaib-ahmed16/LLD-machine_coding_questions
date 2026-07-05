package com.machine.coding.LLDmachine_coding_questions.solutions.splitwise.service.impl;

import com.machine.coding.LLDmachine_coding_questions.solutions.splitwise.models.UserExpense;
import com.machine.coding.LLDmachine_coding_questions.solutions.splitwise.repository.UserExpenseRepository;
import com.machine.coding.LLDmachine_coding_questions.solutions.splitwise.service.UserExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserExpenseServiceImpl implements UserExpenseService {

    @Autowired
    private final UserExpenseRepository userExpenseRepository;

    @Override
    public void addUserExpense(UserExpense userExpense) {
        userExpenseRepository.save(userExpense);
    }

    @Override
    public void updateUserExpense(UserExpense userExpense) {
        userExpenseRepository.save(userExpense);
    }
}
