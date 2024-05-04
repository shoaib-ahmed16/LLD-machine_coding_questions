package com.machine.coding.LLDmachine_coding_questions.services.impl;


import com.machine.coding.LLDmachine_coding_questions.dto.CreateTicketRequest;
import com.machine.coding.LLDmachine_coding_questions.exception.SlotNotAvailableException;
import com.machine.coding.LLDmachine_coding_questions.model.ParkingSpot;
import com.machine.coding.LLDmachine_coding_questions.model.Ticket;
import com.machine.coding.LLDmachine_coding_questions.model.Vehicle;
import com.machine.coding.LLDmachine_coding_questions.model.enums.SpotStatus;
import com.machine.coding.LLDmachine_coding_questions.repository.TicketRepository;
import com.machine.coding.LLDmachine_coding_questions.services.ParkingSpotService;
import com.machine.coding.LLDmachine_coding_questions.services.TicketService;
import com.machine.coding.LLDmachine_coding_questions.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private ParkingSpotService parkingSpotService;
    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private TicketRepository ticketRepository;
    @Override
    public Ticket createTicket(CreateTicketRequest creatingTicketRequest) {
        //Check if the spot is available
        // Allocate a spot
        // If null, throw an Exception
        ParkingSpot parkingSpot = parkingSpotService.allocateSpot(creatingTicketRequest);
        if(Objects.isNull(parkingSpot)){
            throw new SlotNotAvailableException("Slot is Occupied with the Vehicle Type:"+creatingTicketRequest.getVehicleType().toString());
        }

        // Update The Slot -> Field
        parkingSpot.setSpotStatus(SpotStatus.OCCUPIED);
        ParkingSpot updatedSlot=parkingSpotService.update(parkingSpot);

        // Save it in the database

        //Fetch or create
        //If vehicle number and type present, use that
        // Else create a new one
        Vehicle vehicle = vehicleService.findOrCreate(creatingTicketRequest.getVehicleNumber());

        //Create a ticket and save it
        Ticket ticket = Ticket.builder()
                .entryTime(LocalDateTime.now())
                .parkingSpot(updatedSlot)
                .vehicleNumberPlate(creatingTicketRequest.getVehicleNumber())
                .entryGateId(creatingTicketRequest.getEntryGateId())
                .build();
        return ticketRepository.save(ticket);
    }
}

