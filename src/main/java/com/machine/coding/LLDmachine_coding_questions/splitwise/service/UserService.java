package com.machine.coding.LLDmachine_coding_questions.splitwise.service;

import com.machine.coding.LLDmachine_coding_questions.splitwise.dto.dto.UserDto;

public interface UserService {

    void saveUser(UserDto userDto);
    void updateUser(UserDto userDto);
}
