package com.machine.coding.LLDmachine_coding_questions.model;

import com.machine.coding.LLDmachine_coding_questions.model.enums.GateType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntryGate extends Gate{
    private Integer gateNo;
    private Integer floorNo;
    public EntryGate(){
        super(GateType.ENTRY);
    }

    public EntryGate(Integer gateNo,Integer floorNo){
        super(GateType.ENTRY);
        this.gateNo=gateNo;
        this.floorNo=floorNo;
    }

}
