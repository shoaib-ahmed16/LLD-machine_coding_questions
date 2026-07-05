package com.machine.coding.LLDmachine_coding_questions.solutions.splitwise.service;

import com.machine.coding.LLDmachine_coding_questions.solutions.splitwise.dto.UserDto;

public interface UserService {

    void saveUser(UserDto userDto);
    void updateUser(UserDto userDto);
}
