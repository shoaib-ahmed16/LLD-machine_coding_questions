package com.machine.coding.LLDmachine_coding_questions.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "parking_floor")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "floor_id")),
        @AttributeOverride(name = "createdAt", column = @Column(name = "created_at")),
        @AttributeOverride(name = "updatedAt", column = @Column(name = "updated_at"))
})
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ParkingFloor extends BaseModel {
    @Column(name = "floor_number")
    private Integer floorNumber;
    @OneToMany(mappedBy = "parkingFloor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ParkingSpot> spots = new ArrayList<>();
    @OneToOne(mappedBy = "floor", cascade = CascadeType.ALL, orphanRemoval = true)
    private DisplayBoard displayBoard;
    @OneToOne(mappedBy = "floor", cascade = CascadeType.ALL, orphanRemoval = true)
    private PaymentCounter paymentCounter;
}

