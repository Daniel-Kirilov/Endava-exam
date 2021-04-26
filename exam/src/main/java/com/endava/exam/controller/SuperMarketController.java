package com.endava.exam.controller;

import com.endava.exam.dto.supermarket_dtos.ResponseGetSupermarketByIdDto;
import com.endava.exam.dto.supermarket_dtos.ResponseSuperMarketDto;
import com.endava.exam.dto.supermarket_dtos.ResponseSuperMarketWithItemsDto;
import com.endava.exam.model.Supermarket;
import com.endava.exam.service.SuperMarketService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/supermarkets")
@RequiredArgsConstructor
public class SuperMarketController {

    private final SuperMarketService superMarketService;
    private final ModelMapper modelMapper;


    @PostMapping(value = "/create-supermarket", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createSuperMarket(
            @Valid @RequestParam(value = "name") @NotBlank String name,
            @Valid @RequestParam(value = "address") @NotBlank String address,
            @Valid @RequestParam(value = "phoneNumber") String phoneNumber,
            @Valid @RequestParam(value = "workHours") String workHours) {

        Supermarket superMarket = superMarketService.createSupermarket(name, address, phoneNumber, workHours);
        return new ResponseEntity(modelMapper.map(superMarket, ResponseSuperMarketDto.class), HttpStatus.CREATED);
    }

    @PostMapping(value = "/add-items", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseSuperMarketWithItemsDto> addItemsInSuperMarket(
            @Valid @RequestParam @NotNull String superMarketId,
            @Valid @RequestParam @NotEmpty List<String> itemsId) {

        Supermarket superMarket = superMarketService.addItemsToSuperMarket(superMarketId, itemsId);
        return ResponseEntity.ok(modelMapper.map(superMarket, ResponseSuperMarketWithItemsDto.class));
    }

    @GetMapping(value = "/get-by-id/{superMarketId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseGetSupermarketByIdDto> getSuperMarket(
            @Valid @PathVariable(value = "superMarketId") String superMarketId) {

        Supermarket superMarket = superMarketService.getSuperMarketById(superMarketId);
        return ResponseEntity.ok(modelMapper.map(superMarket, ResponseGetSupermarketByIdDto.class));
    }

}
