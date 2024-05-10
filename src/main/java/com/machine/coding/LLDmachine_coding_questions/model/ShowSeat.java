package com.machine.coding.LLDmachine_coding_questions.model;

import com.machine.coding.LLDmachine_coding_questions.model.enums.SeatStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShowSeat extends BaseModel {
    private Show show;
    private Seat seat;
    private SeatStatus status;

}