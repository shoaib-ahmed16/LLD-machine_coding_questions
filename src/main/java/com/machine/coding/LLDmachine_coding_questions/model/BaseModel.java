package com.machine.coding.LLDmachine_coding_questions.model;


import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public abstract class BaseModel {
    private Long id;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}