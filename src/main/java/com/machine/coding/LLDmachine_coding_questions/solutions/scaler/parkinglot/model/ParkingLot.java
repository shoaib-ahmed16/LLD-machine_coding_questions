package com.machine.coding.LLDmachine_coding_questions.solutions.scaler.parkinglot.model;


import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class ParkingLot extends BaseModel{
    private String name;
    private String address;

    private List<ParkingFloor> floors= new ArrayList<>();
    private List<Gate> entryGates = new ArrayList<>();

    private List<Gate> exitGates= new ArrayList<>();
    private DisplayBoard displayBoard;

}
