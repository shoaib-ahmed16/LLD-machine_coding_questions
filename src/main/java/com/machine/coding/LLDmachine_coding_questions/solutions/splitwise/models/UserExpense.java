package com.machine.coding.LLDmachine_coding_questions.solutions.splitwise.models;

import com.machine.coding.LLDmachine_coding_questions.solutions.splitwise.enums.ExpenseType;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class UserExpense extends BaseModel {

    @ManyToOne
    private User user;

    @ManyToOne
    @JoinColumn(name = "expense_id")
    private Expense expense;

    private Double amount;

    @Enumerated
    private ExpenseType type;

    @Override
    public String toString() {
        return "User : {" +" name : "+user.getName() + " }";
    }
}

// UE1 A 150 PAID
// UE2 A 100 PAID

// Dinner 1000
// A B
// A 800 PAID UE1
// B 200 PAID UE2

// A 500 OWED UE3
// A 500 OWED UE4
