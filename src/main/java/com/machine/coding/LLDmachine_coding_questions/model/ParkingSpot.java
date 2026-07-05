package com.machine.coding.LLDmachine_coding_questions.model;


import com.machine.coding.LLDmachine_coding_questions.model.enums.SpotStatus;
import com.machine.coding.LLDmachine_coding_questions.model.enums.VehicleType;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "parking_spot")
//@Data
//@AttributeOverrides({
//        @AttributeOverride(name = "id", column = @Column(name = "spot_id")),
//        @AttributeOverride(name = "createdAt", column = @Column(name = "created_at")),
//        @AttributeOverride(name = "updatedAt", column = @Column(name = "updated_at"))
//})
@SuperBuilder
public class ParkingSpot extends BaseModel {
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "floor_id", referencedColumnName = "floor_id")
//    private ParkingFloor parkingFloor;

//    @Enumerated(EnumType.STRING)
//    @Column(name = "vehicle_type")
    private VehicleType vehicleType;

//    @Enumerated(EnumType.STRING)
//    @Column(name = "spot_status")
    private SpotStatus spotStatus;

}
