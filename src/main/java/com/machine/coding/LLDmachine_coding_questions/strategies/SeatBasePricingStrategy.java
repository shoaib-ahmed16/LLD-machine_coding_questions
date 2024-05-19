package com.machine.coding.LLDmachine_coding_questions.strategies;

import com.machine.coding.LLDmachine_coding_questions.models.Booking;
import com.machine.coding.LLDmachine_coding_questions.models.ShowSeat;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SeatBasePricingStrategy implements PricingStrategy{
    @Override
    public Double calculatePrice(Booking booking, List<ShowSeat> lockedShowSeats) {
        return lockedShowSeats.stream()
                .mapToDouble(seat ->seat.getSeat().getSeatType().getAmount())
                .sum();
    }
}
