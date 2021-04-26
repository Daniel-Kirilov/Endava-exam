package com.endava.exam.service.Impl;

import com.endava.exam.dto.purchase_dtos.PurchaseDetailsDto;
import com.endava.exam.model.Item;
import com.endava.exam.model.Purchase;
import com.endava.exam.model.enums.PaymentType;
import com.endava.exam.repository.ItemRepository;
import com.endava.exam.repository.PurchaseRepository;
import com.endava.exam.service.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PurchaseServiceImpl implements PurchaseService {

    private final PurchaseRepository purchaseRepository;
    private final ItemRepository itemRepository;

    @Override
    public PurchaseDetailsDto byItemsFromSuperMarket(String superMarketId, List<String> itemsId, PaymentType paymentType, Double cashAmount) {
        List<Item> items = itemRepository.findAllById(itemsId);
        Purchase purchase = new Purchase();
        purchase.setSuperMarketId(superMarketId);
        purchase.setItems(items);
        purchase.setPaymentType(paymentType);
        purchase.setCashAmount(cashAmount);
        purchase = purchaseRepository.save(purchase);
        Purchase finalPurchase = purchase;
        items.forEach(item -> item.setPurchase(List.of(finalPurchase)));

        PurchaseDetailsDto details = new PurchaseDetailsDto();
        details.setTotalPrice(purchase.getItems().stream().mapToDouble(Item::getPrice).sum());
        details.setReturnedChange(cashAmount - details.getTotalPrice());
        details.setTimeOfExecutedPayment(LocalDateTime.now());
        return details;
    }

    @Override
    public List<Purchase> getAllPurchases() {
        return purchaseRepository.findAll();
    }
}
