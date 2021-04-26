package com.endava.exam.service;

import com.endava.exam.model.Item;
import com.endava.exam.model.enums.ItemType;

public interface ItemService {
    Item createItem(String name, Double price, ItemType itemType);
}
