package com.machine.coding.LLDmachine_coding_questions.solutions.scaler.parkinglot.dto;


import com.machine.coding.LLDmachine_coding_questions.solutions.scaler.parkinglot.model.ParkingFloor;
import com.machine.coding.LLDmachine_coding_questions.solutions.scaler.parkinglot.model.ParkingLot;
import com.machine.coding.LLDmachine_coding_questions.solutions.scaler.parkinglot.model.ParkingSpot;
import com.machine.coding.LLDmachine_coding_questions.solutions.scaler.parkinglot.model.enums.SpotStatus;
import com.machine.coding.LLDmachine_coding_questions.solutions.scaler.parkinglot.model.enums.VehicleType;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class CreateParkingLotRequest {
    private String name;
    private String address;
    private Integer numberOfFloors;

    private Map<VehicleType,Integer> numberOfSpotPerFloorWithType;
    private Integer numberOfEntryGatesPerFloor;
    private Integer numberOfExitGatesPerFloor;

    public ParkingLot toParkingLot(){
       Long spotID=1L;
       List<ParkingFloor> parkingFloors = new ArrayList<>();
       for(long floor=1L;floor<=this.numberOfFloors;floor++){
           List<ParkingSpot> parkingSpots= new ArrayList<>();
           for(Map.Entry<VehicleType,Integer> m:this.numberOfSpotPerFloorWithType.entrySet()){
               helper(parkingSpots,m.getValue(),m.getKey(),spotID);
           }
           floorHelper(parkingFloors,parkingSpots,floor,this.numberOfEntryGatesPerFloor,this.numberOfExitGatesPerFloor);
       }
        return new ParkingLot();
    }
      
    private void helper(List<ParkingSpot> parkingSpots,int value, VehicleType type, Long spotID){
        while(value!=0){
            parkingSpots.add(ParkingSpot.builder()
                    .spotStatus(SpotStatus.AVAILABLE)
                    .vehicleType(type)
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .id(spotID)
                    .build());
            value--;
            spotID++;
        }
    }
    private void floorHelper(List<ParkingFloor> parkingFloors,List<ParkingSpot> parkingSpots,Long floor, int entry,int exists){

    }

}

