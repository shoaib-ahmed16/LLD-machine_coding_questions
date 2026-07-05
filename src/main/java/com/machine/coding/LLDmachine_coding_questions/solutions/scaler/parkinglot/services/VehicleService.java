package com.machine.coding.LLDmachine_coding_questions.solutions.scaler.parkinglot.services;

import com.machine.coding.LLDmachine_coding_questions.solutions.scaler.parkinglot.model.Vehicle;

public interface VehicleService {
    Vehicle findOrCreate(String vehicleNumber);
}
