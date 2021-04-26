package com.endava.exam.dto.item_dtos;

import com.endava.exam.model.enums.ItemType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseItemsDto {

    private String name;

    private Double price;

    private ItemType itemType;
}
