package com.machine.coding.LLDmachine_coding_questions.dtos;

import com.machine.coding.LLDmachine_coding_questions.models.enums.SeatType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.util.Map;

@Data
public class CreateSeatsOfHallDTO {

    private Integer totalRow;
    private Integer totalColumn;

    private Long hallId;

    private Map<SeatType,Integer> seatTypeRows;

}
