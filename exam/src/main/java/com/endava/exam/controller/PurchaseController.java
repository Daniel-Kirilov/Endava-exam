package com.endava.exam.controller;

import com.endava.exam.dto.purchase_dtos.PurchaseDetailsDto;
import com.endava.exam.dto.purchase_dtos.ResponseGetAllPurchasesDto;
import com.endava.exam.model.enums.PaymentType;
import com.endava.exam.service.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/v1/purchases")
@RequiredArgsConstructor
public class PurchaseController {

    private final PurchaseService purchaseService;

    private final ModelMapper modelMapper;

    @PostMapping(value = "/buy-items", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity buyItemsFromSuperMarket(
            @Valid @RequestParam @NotBlank String superMarketId,
            @Valid @RequestParam @NotEmpty List<String> itemsId,
            @Valid @RequestParam @NotNull PaymentType paymentType,
            @Valid @RequestParam @Nullable Double cashAmount) {

        PurchaseDetailsDto purchase = purchaseService.byItemsFromSuperMarket(superMarketId, itemsId, paymentType, cashAmount);

        return new ResponseEntity(purchase, HttpStatus.CREATED);

    }

    @GetMapping(value = "/get-all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAll() {

        List<ResponseGetAllPurchasesDto> purchases = purchaseService.getAllPurchases()
                .stream()
                .map(purchase -> modelMapper.map(purchase, ResponseGetAllPurchasesDto.class))
                .collect(Collectors.toList());

        return new ResponseEntity(purchases,
                HttpStatus.OK);
    }

}
