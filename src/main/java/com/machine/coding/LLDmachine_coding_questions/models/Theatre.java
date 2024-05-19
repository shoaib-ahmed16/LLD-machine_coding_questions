package com.machine.coding.LLDmachine_coding_questions.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Theatre extends BaseModel {

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    private String name;
    private String address;

    @OneToMany
    private List<Hall> halls = new ArrayList<>();

    @OneToMany
    private List<Show> shows = new ArrayList<>();
}

// 1. Which is the parent entity
// - look at the cardinality
// - The M side will have the reference

// 2. Store the reference on the M side
// - @JoinColumn(foreign_key)

// 3. Connecting the bidirectional
// -  mappedBy