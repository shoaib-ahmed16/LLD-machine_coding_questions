package com.machine.coding.LLDmachine_coding_questions.solutions.splitwise.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_groups")
public class Group extends BaseModel {
    private String name;
    @ManyToOne
    private User createdBy;

    @OneToMany(mappedBy = "group")
    private List<GroupExpense> groupExpenses = new ArrayList<>();

    @ManyToMany
    private List<User> members = new ArrayList<>();

    @ManyToMany
    private List<User> admins = new ArrayList<>();
}
