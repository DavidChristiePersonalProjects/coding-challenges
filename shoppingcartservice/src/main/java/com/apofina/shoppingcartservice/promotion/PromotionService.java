/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apofina.shoppingcartservice.promotion;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author David
 */
@Service
public class PromotionService {
    
    @Autowired
    private PromotionRepository promotionRepository;
    
    public List<Promotion> getAllPromotions(int saleItemId) {
        List<Promotion> promotions = new ArrayList<>();
        
        promotionRepository.findBySaleItemId(saleItemId)
                .forEach(promotions::add);
        
        return promotions;
    }
    
    public Optional<Promotion> getPromotion(int id) {
        return promotionRepository.findById(id);
    }
    
    public Promotion addPromotion(Promotion promotion) {
        promotion = promotionRepository.save(promotion);
        return promotion;
    }
    
    public void updatePromotion(Promotion promotion) {
        promotionRepository.save(promotion);
    }
    
    public void deletePromotion(int id) {
        promotionRepository.deleteById(id);
    }
    
    public int calculateAdjustedPrice(Promotion promotion) {
        int result = -1;
        int quantity = promotion.getSaleItem().getQuantity();
        int requiredQuantity = promotion.getRequiredQuantity();
        int pricePerUnit = promotion.getSaleItem().getPricePerUnit();

        switch(promotion.getType()) {
            case "BUY_X_GET_Y_FREE" :
                if(quantity >= requiredQuantity) {
                    int numFreeUnits = (quantity / requiredQuantity) * promotion.getFreeQuantity();
                    result = (quantity - numFreeUnits) * pricePerUnit;
                }
                break;
            case "QTY_BASED_PRICE_OVERRIDE" :
                if(quantity >= requiredQuantity) {
                    int numPromotions = quantity / requiredQuantity;
                    result = numPromotions * promotion.getPrice();
                    if(quantity % requiredQuantity != 0) {
                        int numUnitsNotIncluded = quantity - (numPromotions * requiredQuantity);
                        result += numUnitsNotIncluded * pricePerUnit;
                    }
                }
                break;
            case "FLAT_PERCENT" : 
                double multiplier = ((double)promotion.getAmount()) / 100;
                pricePerUnit -= pricePerUnit * multiplier;
                result = pricePerUnit * quantity;
                break;
        }
        
        return result;
    }
}
