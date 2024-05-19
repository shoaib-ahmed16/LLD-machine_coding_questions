package com.machine.coding.LLDmachine_coding_questions.controllers;

import com.machine.coding.LLDmachine_coding_questions.dtos.CreateCustomerDTO;
import com.machine.coding.LLDmachine_coding_questions.exceptions.InvalidCustomerException;
import com.machine.coding.LLDmachine_coding_questions.models.Customer;
import com.machine.coding.LLDmachine_coding_questions.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/customer")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Long id){
        return new ResponseEntity<>(customerService.getCustomer(id),HttpStatus.OK);
    }

    //Create a customer
    @PostMapping("/create")
    public ResponseEntity<Customer> createCustomer(@RequestBody CreateCustomerDTO request){
        validate(request);
        return new ResponseEntity<>(customerService.createCustomer(request), HttpStatus.CREATED);
    }
    private void validate(CreateCustomerDTO request){
        if(request.getEmail()==null || request.getEmail().isEmpty()){
            throw new InvalidCustomerException("Email cannot be a null or empty value");
        }
    }
}
