package com.machine.coding.LLDmachine_coding_questions.dto;

import com.machine.coding.LLDmachine_coding_questions.model.enums.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CreateTicketRequest {
    private Long parkingLotId;
    private String vehicleNumber;
    private VehicleType vehicleType;
    private Long entryGateId;
    private Long issuerId;

}
