package com.endava.exam.service;

import com.endava.exam.dto.purchase_dtos.PurchaseDetailsDto;
import com.endava.exam.model.Purchase;
import com.endava.exam.model.enums.PaymentType;

import java.util.List;

public interface PurchaseService {
    PurchaseDetailsDto byItemsFromSuperMarket(String superMarketId, List<String> itemsId, PaymentType paymentType, Double cashAmount);

    List<Purchase> getAllPurchases();
}
