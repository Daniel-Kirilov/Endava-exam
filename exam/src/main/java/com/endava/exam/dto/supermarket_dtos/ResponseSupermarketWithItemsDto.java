package com.endava.exam.dto.supermarket_dtos;

import com.endava.exam.dto.item_dtos.ResponseItemsOnlyNamesDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ResponseSupermarketWithItemsDto {

    private String id;

    private List<ResponseItemsOnlyNamesDto> items;
}
