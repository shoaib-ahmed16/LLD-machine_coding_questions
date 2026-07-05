package com.machine.coding.LLDmachine_coding_questions.splitwise.controller;

import com.machine.coding.LLDmachine_coding_questions.splitwise.dto.dto.UserDto;
import com.machine.coding.LLDmachine_coding_questions.splitwise.service.UserService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
@AllArgsConstructor
@RestController("v1/api")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private final UserService userService;

    @PostMapping("/user/save")
    public ResponseEntity<String> saveUserDetails(UserDto userDto){
        log.info("Initiating the user saving process:b{}",userDto);
        userService.saveUser(userDto);
        return ResponseEntity.ok("User is saved Successfully");
    }

    @PutMapping("user/update")
    public ResponseEntity<String> updateUserDetails(UserDto userDto){
        log.info("Initiating the user updating process:{}",userDto);
        userService.updateUser(userDto);
        return ResponseEntity.ok(String.format("User Details for {} is updated Successfully",userDto.getEmail()));
    }
}
