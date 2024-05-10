package com.machine.coding.LLDmachine_coding_questions.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class City extends BaseModel {

    private String name;

    private List<Theatre> theatres = new ArrayList<>();
}