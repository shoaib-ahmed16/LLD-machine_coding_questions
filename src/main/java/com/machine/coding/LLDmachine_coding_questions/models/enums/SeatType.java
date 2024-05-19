package com.machine.coding.LLDmachine_coding_questions.models.enums;

public enum SeatType {
    SILVER(180.00),
    PLATINUM(230.00),
    GOLD(250.00),
    DIAMOND(530.00),
    VIP(750.00);
    private final Double amount;
    public  Double getAmount(){
        return  this.amount;
    }

    SeatType(Double amount) {
        this.amount = amount;
    }


}
