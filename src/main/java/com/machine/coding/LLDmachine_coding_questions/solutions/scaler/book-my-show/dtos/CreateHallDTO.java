package com.machine.coding.LLDmachine_coding_questions.dtos;

import com.machine.coding.LLDmachine_coding_questions.models.Hall;
import lombok.Data;

@Data
public class CreateHallDTO {
    private String name;

    public Hall toEntity(){
        return Hall.builder()
                .name(this.name)
                .build();
    }
}
