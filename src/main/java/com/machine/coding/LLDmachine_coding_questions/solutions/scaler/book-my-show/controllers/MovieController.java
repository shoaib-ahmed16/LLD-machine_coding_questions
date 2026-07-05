package com.machine.coding.LLDmachine_coding_questions.controllers;

import com.machine.coding.LLDmachine_coding_questions.dtos.CreateMovieDTO;
import com.machine.coding.LLDmachine_coding_questions.models.Movie;
import com.machine.coding.LLDmachine_coding_questions.models.enums.Language;
import com.machine.coding.LLDmachine_coding_questions.models.enums.MovieFeature;
import com.machine.coding.LLDmachine_coding_questions.services.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
@AllArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @PostMapping("/create")
    public ResponseEntity<Movie> createMovie(@RequestBody CreateMovieDTO request){
        return new ResponseEntity<>(movieService.createMovie(request.toEntity()), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable("id") Long movieId){
        return new ResponseEntity<>(movieService.getMovieById(movieId), HttpStatus.OK);
    }

    @GetMapping("/findBy")
    public ResponseEntity<Movie> getMovieById(@RequestParam(name = "movieName") String movieName, @RequestParam("lang") Language language, @RequestParam("feature") MovieFeature movieFeature){
        return new ResponseEntity<>(movieService.getMovieByNameAndLanguageAndFeature(movieName,language,movieFeature), HttpStatus.OK);
    }
}
