package com.machine.coding.LLDmachine_coding_questions.dtos;

import com.machine.coding.LLDmachine_coding_questions.models.Movie;
import com.machine.coding.LLDmachine_coding_questions.models.enums.Language;
import com.machine.coding.LLDmachine_coding_questions.models.enums.MovieFeature;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CreateMovieDTO {

    private String name;
    private Double rating;

    private List<Language> languages = new ArrayList<>();

    private List<MovieFeature> features = new ArrayList<>();

    public Movie toEntity(){
        return Movie.builder()
                .name(this.name)
                .rating(this.rating)
                .languages(this.languages)
                .features(this.features)
                .build();
    }
}
