/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apofina.shoppingcartservice.promotion;

import com.apofina.shoppingcartservice.saleitem.SaleItem;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author David
 */
@RestController
public class PromotionController {
    
    @Autowired
    private PromotionService promotionService;
    
    @RequestMapping("/baskets/{basket.id}/items/{sale_item.id}/promotions")
    public List<Promotion> getAllPromotions(@PathVariable("sale_item.id") int saleItemId) {
        return promotionService.getAllPromotions(saleItemId);
    }
    
    @RequestMapping("/baskets/{basket.id}/items/{sale_item.id}/promotions/{promotion.id}")
    public Promotion getPromotion(@PathVariable("promotion.id") int promotionId) {
        return promotionService.getPromotion(promotionId).orElseThrow(IllegalArgumentException::new);
    }
    
    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/baskets/{basket.id}/items/{sale_item.id}/promotions")
    public Promotion addPromotion(@RequestBody Promotion promotion, @PathVariable("sale_item.id") int saleItemId, @PathVariable("basket.id") int basketId) {
        promotion.setSaleItem(new SaleItem(saleItemId, basketId));
        return promotionService.addPromotion(promotion);
    }
    
    @RequestMapping(method = RequestMethod.PUT, value = "/baskets/{basket.id}/items/{sale_item.id}/promotions/{promotion.id}")
    public void updatePromotion(@RequestBody Promotion promotion, @PathVariable("sale_item.id") int saleItemId, @PathVariable("promotion.id") int promotionId) {
        promotion.setSaleItem(new SaleItem(saleItemId, promotionId));
        promotionService.updatePromotion(promotion);
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value = "/baskets/{basket.id}/items/{sale_item.id}/promotions/{promotion.id}")
    public void deletePromotion(@PathVariable("promotion.id") int promotionId) {
        promotionService.deletePromotion(promotionId);
    }
}
