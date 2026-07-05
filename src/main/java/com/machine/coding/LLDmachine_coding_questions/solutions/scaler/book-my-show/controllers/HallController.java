package com.machine.coding.LLDmachine_coding_questions.controllers;

import com.machine.coding.LLDmachine_coding_questions.dtos.CreateHallDTO;
import com.machine.coding.LLDmachine_coding_questions.dtos.CreateShowDTO;
import com.machine.coding.LLDmachine_coding_questions.models.Hall;
import com.machine.coding.LLDmachine_coding_questions.models.Show;
import com.machine.coding.LLDmachine_coding_questions.services.HallService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hall")
@AllArgsConstructor
public class HallController {
    private final HallService hallService;
    @PostMapping("/create")
    public ResponseEntity<Hall> createHall(@RequestBody CreateHallDTO request){
        return new ResponseEntity<>(hallService.createHall(request.toEntity()), HttpStatus.CREATED);
    }
}
