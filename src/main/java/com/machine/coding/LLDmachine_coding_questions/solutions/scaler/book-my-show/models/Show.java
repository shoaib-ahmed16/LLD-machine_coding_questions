package com.machine.coding.LLDmachine_coding_questions.models;

import com.machine.coding.LLDmachine_coding_questions.models.enums.Language;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "shows")
@NoArgsConstructor
@Builder(toBuilder = true)
@AllArgsConstructor
public class Show extends BaseModel {

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
    private Date startTime;
    private Double duration;

    @ManyToOne
    private Hall hall;

    @Enumerated(EnumType.ORDINAL)
    private Language language;


    @OneToMany(mappedBy = "show")
    private List<ShowSeat> showSeats = new ArrayList<>();
}
