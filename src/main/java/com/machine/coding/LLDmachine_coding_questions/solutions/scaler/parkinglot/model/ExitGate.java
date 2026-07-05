package com.machine.coding.LLDmachine_coding_questions.solutions.scaler.parkinglot.model;


import com.machine.coding.LLDmachine_coding_questions.solutions.scaler.parkinglot.model.enums.GateType;
import lombok.*;

@Getter
@Builder
public class ExitGate extends Gate{
    private Integer gateNo;
    private Integer floorNo;
    public ExitGate(){
        super(GateType.EXIT);
    }

    public ExitGate(Integer gateNo,Integer floorNo){
        super(GateType.EXIT);
        this.gateNo=gateNo;
        this.floorNo=floorNo;
    }

}
