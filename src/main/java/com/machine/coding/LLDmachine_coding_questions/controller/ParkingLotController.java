package com.machine.coding.LLDmachine_coding_questions.controller;


import com.machine.coding.LLDmachine_coding_questions.dto.CreateParkingLotRequest;
import com.machine.coding.LLDmachine_coding_questions.model.ParkingLot;
import com.machine.coding.LLDmachine_coding_questions.services.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/parking-lot")
public class ParkingLotController {

    @Autowired
    private ParkingLotService parkingLotService;

    @PostMapping("/create")
    public ResponseEntity<ParkingLot> createParkingLot(@RequestBody CreateParkingLotRequest parkingLotRequest){
        ParkingLot parkingLot = transform(parkingLotRequest);
        return  new ResponseEntity<>(parkingLotService.createParkingLot(parkingLot), HttpStatus.CREATED);
    }
    private ParkingLot transform(CreateParkingLotRequest request){
        return request.toParkingLot();
    }
    @GetMapping("/{id}")
    public ResponseEntity<ParkingLot> getParkingLot(@PathVariable("id") Long id){
        return  new ResponseEntity<>(parkingLotService.getParkingLot(id), HttpStatus.OK);
    }

}
