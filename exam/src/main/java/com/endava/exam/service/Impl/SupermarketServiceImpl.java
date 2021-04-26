package com.endava.exam.service.Impl;

import com.endava.exam.model.Item;
import com.endava.exam.model.Supermarket;
import com.endava.exam.repository.ItemRepository;
import com.endava.exam.repository.SupermarketRepository;
import com.endava.exam.service.SupermarketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupermarketServiceImpl implements SupermarketService {

    private final SupermarketRepository supermarketRepository;
    private final ItemRepository itemRepository;

    @Override
    public Supermarket createSupermarket(String name, String address, String phoneNumber, String workHours) {
        if(supermarketRepository.existsByName(name)){
            throw new IllegalArgumentException("This name is already taken");
        }
        Supermarket supermarket = new Supermarket();
        supermarket.setName(name);
        supermarket.setAddress(address);
        supermarket.setPhoneNumber(phoneNumber);
        supermarket.setWorkHours(workHours);
        return supermarketRepository.save(supermarket);
    }

    @Override
    public Supermarket addItemsToSuperMarket(String supermarketId, List<String> itemsId) {
        Supermarket supermarket = supermarketRepository.findById(supermarketId).get();
        List<Item> items = itemRepository.findAllById(itemsId);
        supermarket.setItems(items);
        items.forEach(item -> item.setSuperMarket(supermarket));
        supermarketRepository.save(supermarket);
        return supermarket;
    }

    @Override
    public Supermarket getSuperMarketById(String id) {
        return supermarketRepository.findById(id).get();
    }
}
