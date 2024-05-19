package com.machine.coding.LLDmachine_coding_questions.services;

import com.machine.coding.LLDmachine_coding_questions.dtos.CreateBookingDTO;
import com.machine.coding.LLDmachine_coding_questions.models.Booking;

public interface BookingService {

    Booking createBooking(CreateBookingDTO request);
}
