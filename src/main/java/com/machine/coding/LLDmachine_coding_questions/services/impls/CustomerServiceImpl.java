package com.machine.coding.LLDmachine_coding_questions.services.impls;

import com.machine.coding.LLDmachine_coding_questions.dtos.CreateCustomerDTO;
import com.machine.coding.LLDmachine_coding_questions.exceptions.CustomerNotFoundException;
import com.machine.coding.LLDmachine_coding_questions.exceptions.CustomerWithEmailAllreadyExistException;
import com.machine.coding.LLDmachine_coding_questions.models.Customer;
import com.machine.coding.LLDmachine_coding_questions.models.User;
import com.machine.coding.LLDmachine_coding_questions.repositories.CustomerRepository;
import com.machine.coding.LLDmachine_coding_questions.services.CustomerService;
import com.machine.coding.LLDmachine_coding_questions.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final UserService userService;
    @Override
    public Customer getCustomer(Long id) {
        return customerRepository
                .findById(id)
                .orElseThrow(()-> new CustomerNotFoundException("No Customer record for the Customer Id :"+id));
    }

    @Override
    public Customer createCustomer(CreateCustomerDTO dto) {
        // Validate if the email is not present
        // if present, throw an error.
        if(customerRepository.findByEmail(dto.getEmail()).isPresent()){
            throw new CustomerWithEmailAllreadyExistException("Customer exist for the Email Id: "+dto.getEmail()+"Please Register Customer with other Email Id");
        }
        User user = userService.creatUser(dto.getUserName(),dto.getPassword());
        return customerRepository.save(dto.toEntity(user));
    }
}
