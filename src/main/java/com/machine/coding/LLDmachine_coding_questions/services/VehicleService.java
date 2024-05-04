package com.machine.coding.LLDmachine_coding_questions.services;

import com.machine.coding.LLDmachine_coding_questions.model.Vehicle;

public interface VehicleService {
    Vehicle findOrCreate(String vehicleNumber);
}
