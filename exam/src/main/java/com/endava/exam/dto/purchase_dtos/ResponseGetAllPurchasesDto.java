package com.endava.exam.dto.purchase_dtos;

import com.endava.exam.dto.item_dtos.ResponseItemsDto;
import com.endava.exam.model.enums.PaymentType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ResponseGetAllPurchasesDto {

    private String id;

    private PaymentType paymentType;

    private String superMarketId;

    private List<ResponseItemsDto> items;

    private Double cashAmount;
}
