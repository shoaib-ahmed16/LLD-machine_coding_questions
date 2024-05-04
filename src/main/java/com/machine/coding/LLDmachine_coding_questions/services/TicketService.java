package com.machine.coding.LLDmachine_coding_questions.services;

import com.machine.coding.LLDmachine_coding_questions.dto.CreateTicketRequest;
import com.machine.coding.LLDmachine_coding_questions.model.Ticket;

public interface TicketService {
    public Ticket createTicket(CreateTicketRequest creatingTicketRequest);
}
