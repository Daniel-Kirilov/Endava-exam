package com.endava.exam.controller;

import com.endava.exam.dto.item_dtos.ResponseItemsDto;
import com.endava.exam.model.Item;
import com.endava.exam.model.enums.ItemType;
import com.endava.exam.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping(value = "/v1/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;
    private final ModelMapper modelMapper;

    @PostMapping(value = "/create-item", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createItem(
            @Valid @RequestParam(value = "name") @NotBlank String name,
            @Valid @RequestParam(value = "price") @NotNull Double price,
            @Valid @RequestParam(value = "itemType") @NotNull(message = "asd") ItemType itemType) {

        Item item = itemService.createItem(name, price, itemType);
        return new ResponseEntity(modelMapper.map(item, ResponseItemsDto.class), HttpStatus.CREATED);
    }
}
