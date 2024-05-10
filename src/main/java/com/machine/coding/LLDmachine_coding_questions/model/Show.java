package com.machine.coding.LLDmachine_coding_questions.model;


import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Builder(toBuilder = true)
@AllArgsConstructor
public class Show extends BaseModel {

    private Movie movie;
    private Date startTime;
    private Integer duration;
    private List<ShowSeat> showSeats = new ArrayList<>();

    private Screen screen;
}