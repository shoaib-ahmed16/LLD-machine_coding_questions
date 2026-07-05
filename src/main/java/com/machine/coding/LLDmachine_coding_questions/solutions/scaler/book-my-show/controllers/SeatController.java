package com.machine.coding.LLDmachine_coding_questions.controllers;

import com.machine.coding.LLDmachine_coding_questions.dtos.CreateSeatsOfHallDTO;
import com.machine.coding.LLDmachine_coding_questions.exceptions.MissMatchException;
import com.machine.coding.LLDmachine_coding_questions.models.Seat;
import com.machine.coding.LLDmachine_coding_questions.services.SeatService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/seat")
@AllArgsConstructor
public class SeatController {
    private final SeatService seatService;
    @PostMapping("/create")
    public ResponseEntity<List<Seat>> createSeatOfHall(@RequestBody CreateSeatsOfHallDTO request){Integer totalRowsMap=0;
        AtomicInteger totalRows= new AtomicInteger();
        request.getSeatTypeRows().forEach((k, v) -> totalRows.addAndGet(v));
        if(totalRows.get() != request.getTotalRow()){
            throw new MissMatchException(String.format("Sum of Rows per Seat type: %d is not equal to Total Rows: %d", totalRows.get(), request.getTotalRow()));
        }
        return new ResponseEntity<>(seatService.createSeatsByHall(request), HttpStatus.CREATED);
    }
    @GetMapping("/fetchBy")
    public ResponseEntity<List<Seat>> getSeatByHallId(@RequestParam("hall_id") Long hallId){
        return new ResponseEntity<>(seatService.getAllSeatsByHallId(hallId), HttpStatus.OK);
    }
}
