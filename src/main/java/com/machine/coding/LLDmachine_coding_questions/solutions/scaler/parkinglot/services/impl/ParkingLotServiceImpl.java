package com.machine.coding.LLDmachine_coding_questions.solutions.scaler.parkinglot.services.impl;


import com.machine.coding.LLDmachine_coding_questions.solutions.scaler.parkinglot.model.ParkingLot;
import com.machine.coding.LLDmachine_coding_questions.solutions.scaler.parkinglot.services.ParkingLotService;
import org.springframework.stereotype.Service;

@Service
public class ParkingLotServiceImpl implements ParkingLotService {
    @Override
    public ParkingLot createParkingLot(ParkingLot parkingLot) {
        return parkingLot;
    }

    @Override
    public ParkingLot getParkingLot(Long id) {
        return null;
    }
}
