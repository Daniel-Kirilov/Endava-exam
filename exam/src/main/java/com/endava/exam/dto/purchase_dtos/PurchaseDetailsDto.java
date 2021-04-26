package com.endava.exam.dto.purchase_dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class PurchaseDetailsDto {

    private Double totalPrice;

    private Double returnedChange;

    private LocalDateTime timeOfExecutedPayment;
}
