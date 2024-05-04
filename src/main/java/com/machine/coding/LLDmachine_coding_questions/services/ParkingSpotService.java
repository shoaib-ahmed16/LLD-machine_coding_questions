package com.machine.coding.LLDmachine_coding_questions.services;

import com.machine.coding.LLDmachine_coding_questions.dto.CreateTicketRequest;
import com.machine.coding.LLDmachine_coding_questions.model.ParkingSpot;

public interface ParkingSpotService {
    ParkingSpot allocateSpot(CreateTicketRequest creatingTicketRequest);
    ParkingSpot update(ParkingSpot parkingSpot);
}

