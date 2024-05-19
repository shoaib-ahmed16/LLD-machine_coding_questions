package com.machine.coding.LLDmachine_coding_questions.dtos;

import com.machine.coding.LLDmachine_coding_questions.models.Customer;
import com.machine.coding.LLDmachine_coding_questions.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CreateCustomerDTO {
    private String fullName;
    private String city;
    private String phoneNumber;
    private String email;
    private String userName;
    private String password;


    public Customer toEntity(User user){
       return Customer.builder()
               .city(this.city)
               .email(this.email)
               .fullName(this.fullName)
               .phoneNumber(this.phoneNumber)
               .user(user)
               .build();
    }

}
