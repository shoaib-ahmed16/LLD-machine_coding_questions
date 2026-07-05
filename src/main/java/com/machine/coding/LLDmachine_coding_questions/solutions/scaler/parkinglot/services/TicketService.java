package com.machine.coding.LLDmachine_coding_questions.solutions.scaler.parkinglot.services;

import com.machine.coding.LLDmachine_coding_questions.solutions.scaler.parkinglot.dto.CreateTicketRequest;
import com.machine.coding.LLDmachine_coding_questions.solutions.scaler.parkinglot.model.Ticket;

public interface TicketService {
    public Ticket createTicket(CreateTicketRequest creatingTicketRequest);
}
