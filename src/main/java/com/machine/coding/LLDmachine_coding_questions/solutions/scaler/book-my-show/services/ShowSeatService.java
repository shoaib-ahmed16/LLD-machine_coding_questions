package com.machine.coding.LLDmachine_coding_questions.services;

import com.machine.coding.LLDmachine_coding_questions.models.ShowSeat;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public interface ShowSeatService {
    void create(List<ShowSeat> showSeats);
    List<ShowSeat> getShowSeatInternally(List<Long> ids);
    void saveAllLockedSeats(List<ShowSeat> showSeats);
}
