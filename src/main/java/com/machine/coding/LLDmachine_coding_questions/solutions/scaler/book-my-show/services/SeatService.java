package com.machine.coding.LLDmachine_coding_questions.services;

import com.machine.coding.LLDmachine_coding_questions.dtos.CreateSeatsOfHallDTO;
import com.machine.coding.LLDmachine_coding_questions.models.Seat;

import java.util.List;

public interface SeatService {
    List<Seat> getAllSeatsByHallId(Long id);
    List<Seat> createSeatsByHall(CreateSeatsOfHallDTO request);
}
