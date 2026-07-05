package com.machine.coding.LLDmachine_coding_questions.solutions.splitwise.controller;

import com.machine.coding.LLDmachine_coding_questions.solutions.splitwise.models.UserExpense;
import com.machine.coding.LLDmachine_coding_questions.solutions.splitwise.service.UserExpenseService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController("v1/api")
public class UserExpenseController {
    private static final Logger log = LoggerFactory.getLogger(UserExpenseController.class);
    @Autowired
    private final UserExpenseService userExpenseService;

    @GetMapping("/userExpense")
    public ResponseEntity<String> getUserExpenseDetails(@RequestParam String email){
        log.info("Get the user expense Details for: {}",email);
//        userExpenseService.addUserExpense(userExpense);
        return ResponseEntity.ok("User Expense is added Successfully");
    }

    @PostMapping("/userExpense/add")
    public ResponseEntity<String> addUserExpenseDetails(UserExpense userExpense){
        log.info("Initiating the user expense adding process: {}",userExpense);
        userExpenseService.addUserExpense(userExpense);
        return ResponseEntity.ok("User Expense is added Successfully");
    }


    @PutMapping("user/update")
    public ResponseEntity<String> updateUserDetails(UserExpense userExpense){
        log.info("Initiating the user updating process:{}",userExpense);
        userExpenseService.updateUserExpense(userExpense);
        return ResponseEntity.ok(String.format("User Expense for {} is updated Successfully",userExpense.getUser().toString()));
    }
}
