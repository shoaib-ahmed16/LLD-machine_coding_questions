package com.machine.coding.LLDmachine_coding_questions.repositories;

import com.machine.coding.LLDmachine_coding_questions.models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat,Long> {
    List<Seat> findAllByHall_Id(Long id);
}
