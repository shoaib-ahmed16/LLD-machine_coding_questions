package com.machine.coding.LLDmachine_coding_questions.services;

import com.machine.coding.LLDmachine_coding_questions.dtos.CreateHallDTO;
import com.machine.coding.LLDmachine_coding_questions.models.Hall;

import java.util.Optional;

public interface HallService {
    Hall createHall(Hall hall);
    Hall getHallById(Long id);
    Optional<Hall> getHallInternal(Long id);
}
