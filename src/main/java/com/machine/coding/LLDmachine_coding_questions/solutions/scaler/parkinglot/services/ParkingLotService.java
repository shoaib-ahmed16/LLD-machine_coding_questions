package com.machine.coding.LLDmachine_coding_questions.solutions.scaler.parkinglot.services;

import com.machine.coding.LLDmachine_coding_questions.solutions.scaler.parkinglot.model.ParkingLot;

public interface ParkingLotService {
    ParkingLot createParkingLot(ParkingLot parkingLot);
    ParkingLot getParkingLot(Long id);
}