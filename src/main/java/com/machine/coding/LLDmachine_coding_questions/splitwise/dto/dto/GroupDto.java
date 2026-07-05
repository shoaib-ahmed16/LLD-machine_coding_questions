package com.machine.coding.LLDmachine_coding_questions.splitwise.dto.dto;

import com.machine.coding.LLDmachine_coding_questions.splitwise.models.GroupExpense;
import com.machine.coding.LLDmachine_coding_questions.splitwise.models.User;
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
public class GroupDto {

    private String name;
    private User createdBy;
    private List<GroupExpense> groupExpenses = new ArrayList<>();
    private List<User> members = new ArrayList<>();
    private List<User> admins = new ArrayList<>();
}
