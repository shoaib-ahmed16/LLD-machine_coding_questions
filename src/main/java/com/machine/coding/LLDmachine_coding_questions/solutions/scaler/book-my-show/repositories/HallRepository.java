package com.machine.coding.LLDmachine_coding_questions.repositories;

import com.machine.coding.LLDmachine_coding_questions.models.Hall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HallRepository extends JpaRepository<Hall,Long> {
}
