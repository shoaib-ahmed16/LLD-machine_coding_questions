package com.machine.coding.LLDmachine_coding_questions.models;

import com.machine.coding.LLDmachine_coding_questions.models.enums.SeatType;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Seat extends BaseModel {

    private Integer rowNo;
    private Integer columnNo;
    @Enumerated
    private SeatType seatType;

    @ManyToOne
    @JoinColumn(name = "hall_id")
    private Hall hall;

}