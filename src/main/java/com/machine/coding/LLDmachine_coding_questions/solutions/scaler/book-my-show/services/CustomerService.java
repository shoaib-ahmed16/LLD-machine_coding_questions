package com.machine.coding.LLDmachine_coding_questions.services;

import com.machine.coding.LLDmachine_coding_questions.dtos.CreateCustomerDTO;
import com.machine.coding.LLDmachine_coding_questions.models.Customer;

import java.util.Optional;

public interface CustomerService {

    Customer createCustomer(CreateCustomerDTO dto);
    Customer getCustomer(Long id);
    Optional<Customer> getCustomerInternal(Long id);
}
