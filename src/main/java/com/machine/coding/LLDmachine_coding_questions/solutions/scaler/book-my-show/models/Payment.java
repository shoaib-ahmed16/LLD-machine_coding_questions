package com.machine.coding.LLDmachine_coding_questions.models;

import com.machine.coding.LLDmachine_coding_questions.models.enums.PaymentMethodType;
import com.machine.coding.LLDmachine_coding_questions.models.enums.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment extends BaseModel {

    private String reference;
    private Double amount;

    @Enumerated
    private PaymentMethodType providerType;

    @Enumerated
    private PaymentStatus status;
}