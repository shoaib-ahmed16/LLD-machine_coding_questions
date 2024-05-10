package com.machine.coding.LLDmachine_coding_questions.model;

import com.machine.coding.LLDmachine_coding_questions.model.enums.BookingStatus;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Booking extends BaseModel {

    private User user;
    private Show show;
    private List<ShowSeat> seats = new ArrayList<>();

    private Double amount;
    private LocalDateTime bookedAt;

    private BookingStatus status;

    private List<Payment> payments = new ArrayList<>();
}