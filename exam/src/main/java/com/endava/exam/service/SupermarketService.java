package com.endava.exam.service;

import com.endava.exam.model.Supermarket;

import java.util.List;

public interface SupermarketService {
    Supermarket createSupermarket(String name, String address, String phoneNumber, String workHours);

    Supermarket addItemsToSuperMarket(String superMarketId, List<String> itemsId);

    Supermarket getSuperMarketById(String id);
}
