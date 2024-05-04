package com.machine.coding.LLDmachine_coding_questions.model;


import com.machine.coding.LLDmachine_coding_questions.model.enums.SpotStatus;
import com.machine.coding.LLDmachine_coding_questions.model.enums.VehicleType;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
public class ParkingSpot extends BaseModel{
    private Integer spotId;
    private Integer floorNumber;
    private VehicleType vehicleType;
    private SpotStatus spotStatus;
}
