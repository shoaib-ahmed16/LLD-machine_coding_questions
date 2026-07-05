package com.machine.coding.LLDmachine_coding_questions.services.impls;

import com.machine.coding.LLDmachine_coding_questions.exceptions.MovieAllReadyExistException;
import com.machine.coding.LLDmachine_coding_questions.exceptions.MovieNotFoundException;
import com.machine.coding.LLDmachine_coding_questions.models.Movie;
import com.machine.coding.LLDmachine_coding_questions.models.enums.Language;
import com.machine.coding.LLDmachine_coding_questions.models.enums.MovieFeature;
import com.machine.coding.LLDmachine_coding_questions.repositories.MovieRepository;
import com.machine.coding.LLDmachine_coding_questions.services.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;
    @Override
    public Movie createMovie(Movie movie) {
        if(movieRepository.findByName(movie.getName()).isPresent()){
            throw new MovieAllReadyExistException(movie.getName());
        }
        return movieRepository.save(movie);
    }

    @Override
    public Movie getMovieById(Long id) {
        return movieRepository.findById(id)
                .orElseThrow(()-> new MovieNotFoundException("The Movie is not found for the Provided Id : "+id)
                );
    }

    @Override
    public Movie getMovieByNameAndLanguageAndFeature(String name, Language lang, MovieFeature feature) {
        return null;
    }

    @Override
    public Optional<Movie> getMovieInternalById(Long id) {
        return movieRepository.findById(id);
    }
}
