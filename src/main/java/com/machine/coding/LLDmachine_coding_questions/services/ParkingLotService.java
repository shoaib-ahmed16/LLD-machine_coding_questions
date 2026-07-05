package com.machine.coding.LLDmachine_coding_questions.services;

import com.machine.coding.LLDmachine_coding_questions.model.ParkingLot;

public interface ParkingLotService {
    ParkingLot createParkingLot(ParkingLot parkingLot);
    ParkingLot getParkingLot(Long id);
}