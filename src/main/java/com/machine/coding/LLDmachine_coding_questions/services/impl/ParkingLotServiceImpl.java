package com.machine.coding.LLDmachine_coding_questions.services.impl;


import com.machine.coding.LLDmachine_coding_questions.model.ParkingLot;
import com.machine.coding.LLDmachine_coding_questions.services.ParkingLotService;
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
