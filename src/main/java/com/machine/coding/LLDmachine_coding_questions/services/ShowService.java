package com.machine.coding.LLDmachine_coding_questions.services;

import com.machine.coding.LLDmachine_coding_questions.dtos.CreateShowDTO;
import com.machine.coding.LLDmachine_coding_questions.models.Show;

import java.util.Optional;

public interface ShowService {
    Show createShow(CreateShowDTO request);
    Optional<Show> getShowInternallyById(Long id);
    Show getShowById(Long id);

}
