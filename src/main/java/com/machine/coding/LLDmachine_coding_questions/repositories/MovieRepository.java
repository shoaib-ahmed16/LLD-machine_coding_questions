package com.machine.coding.LLDmachine_coding_questions.repositories;

import com.machine.coding.LLDmachine_coding_questions.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {
    Optional<Movie> findByName(String name);

}
