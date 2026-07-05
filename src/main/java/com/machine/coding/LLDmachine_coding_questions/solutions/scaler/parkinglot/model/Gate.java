package com.machine.coding.LLDmachine_coding_questions.solutions.scaler.parkinglot.model;

import com.machine.coding.LLDmachine_coding_questions.solutions.scaler.parkinglot.model.enums.GateType;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Gate extends BaseModel {
    private GateType gateType;
}