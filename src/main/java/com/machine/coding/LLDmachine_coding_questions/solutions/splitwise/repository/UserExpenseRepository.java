package com.machine.coding.LLDmachine_coding_questions.solutions.splitwise.repository;

import com.machine.coding.LLDmachine_coding_questions.solutions.splitwise.models.UserExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserExpenseRepository extends JpaRepository<UserExpense, Long> {

    UserExpense findByNameOrPhoneNumber(String value);

}
