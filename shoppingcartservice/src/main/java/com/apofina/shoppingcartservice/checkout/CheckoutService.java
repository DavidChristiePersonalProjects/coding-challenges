/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apofina.shoppingcartservice.checkout;

import com.apofina.shoppingcartservice.promotion.Promotion;
import com.apofina.shoppingcartservice.promotion.PromotionService;
import com.apofina.shoppingcartservice.saleitem.SaleItem;
import com.apofina.shoppingcartservice.saleitem.SaleItemService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author David
 */
@Service
public class CheckoutService {
    
    @Autowired
    SaleItemService saleItemService;
    @Autowired
    PromotionService promotionService;
    
    
    public List<SaleItem> checkout(int basketId) {
        // get all the sale items in the basket
        List<SaleItem> saleItems = saleItemService.getAllSaleItems(basketId);
        // for each sale item
        for(SaleItem saleItem : saleItems) {
            // check for promotions
            List<Promotion> promotions = promotionService.getAllPromotions(saleItem.getId());
            int price = saleItem.getUnadjustedPrice();
            
            for(Promotion promotion : promotions) {
                int result = promotionService.calculateAdjustedPrice(promotion);
                if(result != -1) {
                    price = result;
                }
            }
            
            saleItem.setAdjustedPrice(price);
        }
        
        return saleItems;
    }
}
