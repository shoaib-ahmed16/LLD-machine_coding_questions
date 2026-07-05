package com.machine.coding.LLDmachine_coding_questions.strategies;

import com.machine.coding.LLDmachine_coding_questions.models.Booking;
import com.machine.coding.LLDmachine_coding_questions.models.ShowSeat;

import java.util.List;

public interface PricingStrategy {
    public Double calculatePrice(Booking booking, List<ShowSeat> lockedShowSeats);
}
