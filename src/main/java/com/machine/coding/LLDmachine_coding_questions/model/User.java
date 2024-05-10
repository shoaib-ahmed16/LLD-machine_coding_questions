package com.machine.coding.LLDmachine_coding_questions.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseModel {
    private String name;
    private String email;
    private String password;
}