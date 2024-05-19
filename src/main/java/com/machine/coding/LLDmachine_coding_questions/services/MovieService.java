package com.machine.coding.LLDmachine_coding_questions.services;

import com.machine.coding.LLDmachine_coding_questions.models.Movie;
import com.machine.coding.LLDmachine_coding_questions.models.enums.Language;
import com.machine.coding.LLDmachine_coding_questions.models.enums.MovieFeature;

public interface MovieService {
    Movie createMovie(Movie movie);
    Movie getMovieById(Long id);
    Movie getMovieByNameAndLanguageAndFeature(String name, Language lang, MovieFeature feature);
}
