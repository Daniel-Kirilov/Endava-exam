package com.endava.exam.service.Impl;

import com.endava.exam.model.Item;
import com.endava.exam.model.enums.ItemType;
import com.endava.exam.repository.ItemRepository;
import com.endava.exam.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final ModelMapper modelMapper;


    @Override
    public Item createItem(String name, Double price, ItemType itemType) {
        Item item = new Item();
        item.setName(name);
        item.setPrice(price);
        item.setItemType(itemType);
        return itemRepository.save(item);
    }
}
