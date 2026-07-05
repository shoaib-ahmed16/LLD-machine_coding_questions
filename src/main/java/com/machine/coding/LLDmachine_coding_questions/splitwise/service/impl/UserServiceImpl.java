package com.machine.coding.LLDmachine_coding_questions.splitwise.service.impl;

import com.machine.coding.LLDmachine_coding_questions.splitwise.dto.dto.UserDto;
import com.machine.coding.LLDmachine_coding_questions.splitwise.models.User;
import com.machine.coding.LLDmachine_coding_questions.splitwise.repository.UserRepository;
import com.machine.coding.LLDmachine_coding_questions.splitwise.service.UserService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private final UserRepository userRepository;
    @Override
    public void saveUser(UserDto userDto) {
        User user = User.builder()
                .email(userDto.getEmail())
                .phoneNumber(userDto.getPhoneNumber())
                .password(userDto.getPassword())
                .name(userDto.getName())
                .build();
        userRepository.save(user);
    }

    @Override
    public void updateUser(UserDto userDto) {
        log.info("Find user by User Id :{}", userDto.getId());
        User user = userRepository.findById(userDto.getId()).orElseThrow(
                ()-> new RuntimeException("User Details Not found for User Id: "+userDto.getId()));

        User user2 = User.builder()
                .name(user.getName().equals(userDto.getName())?user.getName():userDto.getName())
                .password(user.getPassword().equals(userDto.getPassword())?user.getPassword():userDto.getPassword())
                .email(user.getEmail().equals(userDto.getEmail())?user.getEmail():userDto.getEmail())
                .phoneNumber(user.getPhoneNumber().equals(userDto.getPhoneNumber())
                        ?user.getPhoneNumber():userDto.getPhoneNumber())
                .build();

        userRepository.save(user2);

    }
}
