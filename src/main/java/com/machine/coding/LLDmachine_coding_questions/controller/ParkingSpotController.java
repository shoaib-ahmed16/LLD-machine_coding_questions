package com.machine.coding.LLDmachine_coding_questions.controller;


import com.machine.coding.LLDmachine_coding_questions.model.ParkingSpot;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/parking-spot")
public class ParkingSpotController {
    //Create a parking spot
    @PostMapping("/create")
    public ResponseEntity<ParkingSpot> createParkingSpot(@RequestBody ParkingSpot parkingSpot){
        return  new ResponseEntity<>(ParkingSpot.builder().build(), HttpStatus.CREATED);
    }

    //Update a parking spot
    @PutMapping("/update")
    public ResponseEntity<ParkingSpot> updateParkingSpot(@RequestParam("id") Integer id, @RequestBody ParkingSpot parkingSpot){
        return  new ResponseEntity<>(ParkingSpot.builder().build(), HttpStatus.CREATED);
    }

    //Get a parking Spot
    @GetMapping("/id")
    public ResponseEntity<ParkingSpot> getParkingSpot(@RequestParam("id") Integer id){
        return  new ResponseEntity<>(ParkingSpot.builder().build(), HttpStatus.CREATED);
    }
    //Get list of Parking spot
    @GetMapping("/all")
    public ResponseEntity<List<ParkingSpot>> getAllParkingSpot(){
        return  new ResponseEntity<>(List.of(ParkingSpot.builder().build()), HttpStatus.CREATED);
    }

    //delete a parking spot
    @DeleteMapping("/id")
    public ResponseEntity<ParkingSpot> deleteParkingSpot(@RequestParam("id") Integer id){
        return  new ResponseEntity<>(ParkingSpot.builder().build(), HttpStatus.CREATED);
    }

}
