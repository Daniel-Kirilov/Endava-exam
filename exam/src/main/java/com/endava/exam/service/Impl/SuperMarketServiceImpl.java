package com.endava.exam.service.Impl;

import com.endava.exam.model.Item;
import com.endava.exam.model.Supermarket;
import com.endava.exam.repository.ItemRepository;
import com.endava.exam.repository.SuperMarketRepository;
import com.endava.exam.service.SuperMarketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SuperMarketServiceImpl implements SuperMarketService {

    private final SuperMarketRepository superMarketRepository;
    private final ItemRepository itemRepository;

    @Override
    public Supermarket createSupermarket(String name, String address, String phoneNumber, String workHours) {
        if(superMarketRepository.existsByName(name)){
            throw new IllegalArgumentException("This name is already taken");
        }
        Supermarket superMarket = new Supermarket();
        superMarket.setName(name);
        superMarket.setAddress(address);
        superMarket.setPhoneNumber(phoneNumber);
        superMarket.setWorkHours(workHours);
        return superMarketRepository.save(superMarket);
    }

    @Override
    public Supermarket addItemsToSuperMarket(String superMarketId, List<String> itemsId) {
        Supermarket superMarket = superMarketRepository.findById(superMarketId).get();
        List<Item> items = itemRepository.findAllById(itemsId);
        superMarket.setItems(items);
        items.forEach(item -> item.setSuperMarket(superMarket));
        superMarketRepository.save(superMarket);
        return superMarket;
    }

    @Override
    public Supermarket getSuperMarketById(String id) {
        return superMarketRepository.findById(id).get();
    }
}
