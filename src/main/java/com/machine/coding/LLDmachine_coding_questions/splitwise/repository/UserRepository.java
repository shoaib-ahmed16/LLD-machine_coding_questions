package com.machine.coding.LLDmachine_coding_questions.splitwise.repository;

import com.machine.coding.LLDmachine_coding_questions.splitwise.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmailORPhoneNumber(String value);

}
