package com.machine.coding.LLDmachine_coding_questions.model;

import com.machine.coding.LLDmachine_coding_questions.model.enums.SeatType;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Seat extends BaseModel {

    private Integer rowNo;
    private Integer columnNo;
    private SeatType seatType;
}
