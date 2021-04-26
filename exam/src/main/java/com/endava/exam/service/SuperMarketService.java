package com.endava.exam.service;

import com.endava.exam.model.Supermarket;

import java.util.List;
import java.util.Optional;

public interface SuperMarketService {
    Supermarket createSupermarket(String name, String address, String phoneNumber, String workHours);

    Supermarket addItemsToSuperMarket(String superMarketId, List<String> itemsId);

    Supermarket getSuperMarketById(String id);
}
