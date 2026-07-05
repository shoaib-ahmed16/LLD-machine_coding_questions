package com.machine.coding.LLDmachine_coding_questions.solutions.splitwise.repository;

import com.machine.coding.LLDmachine_coding_questions.solutions.splitwise.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmailORPhoneNumber(String value);

}
