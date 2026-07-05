package com.machine.coding.LLDmachine_coding_questions.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Entity
@SuperBuilder
public class Ticket extends BaseModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String vehicleNumberPlate;
    private Long parkingSpotId;
    private ParkingSpot parkingSpot;
    private LocalDateTime entryTime;

    private Long issuerId;
    private ParkingOperator issuedBy;
    private Long entryGateId;
    private Gate entryGate;
    public Ticket(){
        super.setId(this.Id);
    }

}
