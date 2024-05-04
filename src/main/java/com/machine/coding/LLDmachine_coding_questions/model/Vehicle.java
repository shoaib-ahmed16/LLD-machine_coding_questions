package com.machine.coding.LLDmachine_coding_questions.model;

import com.machine.coding.LLDmachine_coding_questions.model.enums.VehicleType;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
public class Vehicle extends BaseModel{
    private  String ownerName;
    private String vehicleNumber;
    private String vehicleBrand;
    private String vehicleName;
    private VehicleType vehicleType;
    private String ownerContactNumber;

}
