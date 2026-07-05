package com.machine.coding.LLDmachine_coding_questions.solutions.scaler.parkinglot.services;

import com.machine.coding.LLDmachine_coding_questions.solutions.scaler.parkinglot.dto.CreateTicketRequest;
import com.machine.coding.LLDmachine_coding_questions.solutions.scaler.parkinglot.model.ParkingSpot;

public interface ParkingSpotService {
    ParkingSpot allocateSpot(CreateTicketRequest creatingTicketRequest);
    ParkingSpot update(ParkingSpot parkingSpot);
}

