package com.machine.coding.LLDmachine_coding_questions.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User extends BaseModel {
    private String username;
    private String password;

}