package com.endava.exam.dto.supermarket_dtos;

import com.endava.exam.dto.item_dtos.ResponseItemsDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ResponseGetSupermarketByIdDto {

    private String name;

    private String address;

    private String phoneNumber;

    private String workHours;

    private List<ResponseItemsDto> items;
}
