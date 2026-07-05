package com.machine.coding.LLDmachine_coding_questions.splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class GroupExpense extends BaseModel {

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @OneToOne
    private Expense expense;
}

// G1 Dinner(GE1) -> E1
// G1 Breakfast(GE2) -> E2