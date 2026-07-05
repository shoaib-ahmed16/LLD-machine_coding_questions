package com.machine.coding.LLDmachine_coding_questions.dtos;

import com.machine.coding.LLDmachine_coding_questions.models.enums.Language;
import lombok.Data;

import java.util.Date;

@Data
public class CreateShowDTO {
    private Long hallId;
    private Long movieId;
    private Date startTime;
    private Language language;

}
