package com.machine.coding.LLDmachine_coding_questions.solutions.scaler.parkinglot.model;

import com.machine.coding.LLDmachine_coding_questions.solutions.scaler.parkinglot.model.enums.GateType;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EntryGate extends Gate{
    private Integer gateNo;
    private Integer floorNo;
    public EntryGate(){
        super( GateType.ENTRY);
    }

    public EntryGate(Integer gateNo,Integer floorNo){
        super(GateType.ENTRY);
        this.gateNo=gateNo;
        this.floorNo=floorNo;
    }

}
