package com.machine.coding.LLDmachine_coding_questions.splitwise.repository;

import com.machine.coding.LLDmachine_coding_questions.splitwise.models.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
