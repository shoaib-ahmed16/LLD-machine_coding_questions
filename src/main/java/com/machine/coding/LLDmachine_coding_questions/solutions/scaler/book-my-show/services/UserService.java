package com.machine.coding.LLDmachine_coding_questions.services;


import com.machine.coding.LLDmachine_coding_questions.models.User;

public interface UserService {
    User creatUser(String username, String password);
    User getUser(String userName);
}
