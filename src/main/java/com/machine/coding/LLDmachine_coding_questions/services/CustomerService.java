package com.machine.coding.LLDmachine_coding_questions.services;

import com.machine.coding.LLDmachine_coding_questions.dtos.CreateCustomerDTO;
import com.machine.coding.LLDmachine_coding_questions.models.Customer;

public interface CustomerService {
    Customer getCustomer(Long id);
    Customer createCustomer(CreateCustomerDTO dto);
}
