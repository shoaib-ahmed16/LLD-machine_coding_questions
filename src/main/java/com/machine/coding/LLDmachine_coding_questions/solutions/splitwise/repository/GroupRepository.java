package com.machine.coding.LLDmachine_coding_questions.solutions.splitwise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<GroupRepository, Long> {
}
