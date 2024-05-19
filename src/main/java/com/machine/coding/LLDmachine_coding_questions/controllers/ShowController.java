package com.machine.coding.LLDmachine_coding_questions.controllers;

import com.machine.coding.LLDmachine_coding_questions.dtos.CreateShowDTO;
import com.machine.coding.LLDmachine_coding_questions.models.Show;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/show")
public class ShowController {
//    Show API
//    Create Method
//    Create a show
//    -- validate the hall
//    -- Validate Movie
//      -- Persist the show
//     -- fetch the show seats
//    -- Persist the show seats

    @PostMapping("/create")
    public ResponseEntity<Show> createShow(@RequestBody CreateShowDTO request){
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }
}

