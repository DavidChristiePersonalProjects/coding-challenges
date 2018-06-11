/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apofina.shoppingcartservice.promotion;

import com.apofina.shoppingcartservice.basket.Basket;
import com.apofina.shoppingcartservice.saleitem.SaleItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

/**
 *
 * @author David
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PromotionServiceTests {
    
    @Autowired
    PromotionService promotionService;
    
    @Test
    public void testCalculateAdjustedPrice_UNKNOWN() {
        System.out.println("calculateAdjustedPrice_UNKNOWN");
        SaleItem saleItem = new SaleItem(1, "Product id", 5, 999, 4995, -1, new Basket(1));
        Promotion promotion = new Promotion(1, "promotion id", "UNKNOWN", -1, -1, -1, -1, saleItem);
        int expResult = -1;
        int actualResult = promotionService.calculateAdjustedPrice(promotion);
        
        assertThat(actualResult).isEqualTo(expResult);
    }
    
    @Test
    public void testCalculateAdjustedPrice_BUY_X_GET_Y_FREE() {
        System.out.println("calculateAdjustedPrice_BUY_X_GET_Y_FREE");
        SaleItem saleItem = new SaleItem(1, "Product id", 5, 999, 4995, -1, new Basket(1));
        Promotion promotion = new Promotion(1, "promotion id", "BUY_X_GET_Y_FREE", -1, 2, 1, -1, saleItem);
        int expResult = 2997;
        int actualResult = promotionService.calculateAdjustedPrice(promotion);
        
        assertThat(actualResult).isEqualTo(expResult);
        
        saleItem.setQuantity(1);
        saleItem.setUnadjustedPrice(999);
        expResult = -1;
        actualResult = promotionService.calculateAdjustedPrice(promotion);
        
        assertThat(actualResult).isEqualTo(expResult);
        
        saleItem.setQuantity(7);
        saleItem.setUnadjustedPrice(6993);
        promotion.setRequiredQuantity(3);
        promotion.setFreeQuantity(1);
        expResult = 4995;
        actualResult = promotionService.calculateAdjustedPrice(promotion);
        
        assertThat(actualResult).isEqualTo(expResult);
        
        // TODO add more rigourous tests i.e. test the handling of unexpected numbers
    }
    
    @Test
    public void testCalculateAdjustedPrice_QTY_BASED_PRICE_OVERRIDE() {
        System.out.println("calculateAdjustedPrice_QTY_BASED_PRICE_OVERRIDE");
        SaleItem saleItem = new SaleItem(1, "Product id", 5, 999, 4995, -1, new Basket(1));
        Promotion promotion = new Promotion(1, "promotion id", "QTY_BASED_PRICE_OVERRIDE", -1, 2, -1, 1799, saleItem);
        int expResult = 4597;
        int actualResult = promotionService.calculateAdjustedPrice(promotion);
        
        assertThat(actualResult).isEqualTo(expResult);
        
        saleItem.setQuantity(1);
        saleItem.setUnadjustedPrice(999);
        expResult = -1;
        actualResult = promotionService.calculateAdjustedPrice(promotion);
        
        assertThat(actualResult).isEqualTo(expResult);
        
        saleItem.setQuantity(7);
        saleItem.setUnadjustedPrice(6993);
        promotion.setRequiredQuantity(3);
        promotion.setPrice(2500);
        expResult = 5999;
        actualResult = promotionService.calculateAdjustedPrice(promotion);
        
        assertThat(actualResult).isEqualTo(expResult);
        
        // TODO add more rigourous tests i.e. test the handling of unexpected numbers
    }

    @Test
    public void testCalculateAdjustedPrice_FLAT_PERCENT() {
        System.out.println("calculateAdjustedPrice_FLAT_PERCENT");
        SaleItem saleItem = new SaleItem(1, "Product id", 5, 999, 4995, -1, new Basket(1));
        Promotion promotion = new Promotion(1, "promotion id", "FLAT_PERCENT", 10, -1, -1, -1, saleItem);
        int expResult = 4495;
        int actualResult = promotionService.calculateAdjustedPrice(promotion);
        
        assertThat(actualResult).isEqualTo(expResult);
        
        saleItem.setQuantity(1);
        saleItem.setUnadjustedPrice(999);
        expResult = 899;
        actualResult = promotionService.calculateAdjustedPrice(promotion);
        
        assertThat(actualResult).isEqualTo(expResult);
        
        saleItem.setQuantity(7);
        saleItem.setUnadjustedPrice(6993);
        promotion.setAmount(15);
        expResult = 5943;
        actualResult = promotionService.calculateAdjustedPrice(promotion);
        
        assertThat(actualResult).isEqualTo(expResult);
        
        // TODO add more rigourous tests i.e. test the handling of unexpected numbers
    }
    
}
