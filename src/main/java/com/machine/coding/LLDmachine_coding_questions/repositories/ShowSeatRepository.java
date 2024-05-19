package com.machine.coding.LLDmachine_coding_questions.repositories;

import com.machine.coding.LLDmachine_coding_questions.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat,Long> {
}
