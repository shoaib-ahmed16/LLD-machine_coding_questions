package com.machine.coding.LLDmachine_coding_questions.model;

import com.machine.coding.LLDmachine_coding_questions.model.enums.PaymentMethodType;
import com.machine.coding.LLDmachine_coding_questions.model.enums.PaymentStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payment extends BaseModel {

    private String reference;
    private Double amount;

    private PaymentMethodType providerType;

    private PaymentStatus status;
}
