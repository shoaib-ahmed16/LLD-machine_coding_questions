package com.machine.coding.LLDmachine_coding_questions.controllers;

import com.machine.coding.LLDmachine_coding_questions.dtos.CreateBookingDTO;
import com.machine.coding.LLDmachine_coding_questions.models.Booking;
import com.machine.coding.LLDmachine_coding_questions.services.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")
@AllArgsConstructor
public class BookingController {

    private final BookingService bookingService;
    @PostMapping("/create")
    public ResponseEntity<Booking> createBooking(@RequestBody CreateBookingDTO request){
        return new ResponseEntity<>(bookingService.createBooking(request), HttpStatus.CREATED);
    }

}
