/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apofina.shoppingcartservice.saleitem;

import com.apofina.shoppingcartservice.basket.Basket;
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
public class SaleItemController {
    
    @Autowired
    private SaleItemService saleItemService;
    
    @RequestMapping("/baskets/{basket.id}/items")
    public List<SaleItem> getAllSaleItems(@PathVariable("basket.id") int basketId) {
        System.out.println("basket id: " + basketId);
        return saleItemService.getAllSaleItems(basketId);
    }
    
    @RequestMapping("/baskets/{basket.id}/items/{sale_item.id}")
    public SaleItem getSaleItem(@PathVariable("sale_item.id") int saleItemId) {
        return saleItemService.getSaleItem(saleItemId).orElseThrow(IllegalArgumentException::new);
    }
    
    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/baskets/{basket.id}/items")
    public SaleItem addSaleItem(@RequestBody SaleItem saleItem, @PathVariable("basket.id") int basketId) {
        saleItem.setBasket(new Basket(basketId));
        return saleItemService.addSaleItem(saleItem);
    }
    
    @RequestMapping(method = RequestMethod.PUT, value = "/baskets/{basket.id}/items/{sale_item.id}")
    public void updateSaleItem(@RequestBody SaleItem saleItem, @PathVariable("basket.id") int basketId) {
        saleItem.setBasket(new Basket(basketId));
        saleItemService.updateSaleItem(saleItem);
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value = "/baskets/{basket.id}/items/{sale_item.id}")
    public void deletesaleItem(@PathVariable("sale_item.id") int saleItemId) {
        saleItemService.deleteSaleItem(saleItemId);
    }
}
