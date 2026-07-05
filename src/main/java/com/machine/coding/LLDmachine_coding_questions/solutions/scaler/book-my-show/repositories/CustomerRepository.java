package com.machine.coding.LLDmachine_coding_questions.repositories;

import com.machine.coding.LLDmachine_coding_questions.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    public Optional<Customer> findByEmail(String email);
}
