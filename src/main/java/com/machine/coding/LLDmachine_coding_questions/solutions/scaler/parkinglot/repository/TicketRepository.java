package com.machine.coding.LLDmachine_coding_questions.solutions.scaler.parkinglot.repository;


import com.machine.coding.LLDmachine_coding_questions.solutions.scaler.parkinglot.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long> {
}
