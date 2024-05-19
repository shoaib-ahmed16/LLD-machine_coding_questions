package com.machine.coding.LLDmachine_coding_questions.dtos;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CreateBookingDTO {
    private Long customerId;
    private Long showId;
    private List<Long> showSeatIDs= new ArrayList<>();
}
