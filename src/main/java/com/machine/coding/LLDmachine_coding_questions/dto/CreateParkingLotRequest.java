package com.machine.coding.LLDmachine_coding_questions.dto;


import com.machine.coding.LLDmachine_coding_questions.model.*;
import com.machine.coding.LLDmachine_coding_questions.model.enums.GateType;
import lombok.Data;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Data
public class CreateParkingLotRequest {

    //    @NotBlank(message = "Name field Cannot Be Blank")
//    @NotNull(message = "Name field Cannot Be null")
//    @Min(value = 8, message = "Name field must have 8 character at Least")
    private String name;
    //    @NotBlank(message = "Address field Cannot Be Blank")
//    @NotNull(message = "Address field Cannot Be null")
//    @Min(value = 8, message = "Address field must have 8 character at Least")
    private String address;

    //    @NotNull(message = "Number of Floors value Cannot Be null")
//    @Min(value = 1, message = "Number of Floor value should be greater than equal to 1")
    private Integer numberOfFloors;
    //    @NotNull(message = "Number  of Spot per Floors value Cannot Be null")
//    @Min(value = 1, message = "Number of Spot per Floor  value should be greater than equal to 1")
    private Integer numberOfSpotsPerFloor;

    //    @NotNull(message = "Number  of Entry Gate value Cannot Be null")
//    @Min(value = 1, message = "Number  of Entry Gate  value should be greater than equal to 1")
    private Integer numberOfEntryGates;
    //    @NotNull(message = "Number  of Exit Gate value Cannot Be null")
//    @Min(value = 1, message = "Number  of Exit Gate  value should be greater than equal to 1")
    private Integer numberOfExitGates;

    public ParkingLot toParkingLot(){
        AtomicInteger spotId= new AtomicInteger(1);
        AtomicLong floorId= new AtomicLong(1);
        return ParkingLot.builder()
                .name(this.name)
                .address(this.address)
                .floors(Stream.generate(() -> {
                            List<ParkingSpot> spots = Stream.generate(() -> ParkingSpot.builder()
                                            .spotId(spotId.getAndAdd(1)).build())
                                    .limit(this.numberOfSpotsPerFloor)
                                    .collect(Collectors.toList());
                            return ParkingFloor.builder()
                                    .id(floorId.getAndAdd(1))
                                    .spots(spots)
                                    .displayBoard(new DisplayBoard())
                                    .paymentCounter(new PaymentCounter())
                                    .build();
                        })
                        .limit(this.numberOfFloors)
                        .collect(Collectors.toList()))
                .entryGates(Stream.generate(()-> Gate.builder().gateType(GateType.ENTRY).build()).limit(this.numberOfEntryGates).collect(toList()))
                .exitGates(Stream.generate(()-> Gate.builder().gateType(GateType.EXIT).build()).limit(this.numberOfExitGates).collect(toList()))
                .build();
    }

}

