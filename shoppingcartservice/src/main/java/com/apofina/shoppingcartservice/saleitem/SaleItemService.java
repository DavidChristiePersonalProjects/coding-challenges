/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apofina.shoppingcartservice.saleitem;

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
public class SaleItemService {
    
    @Autowired
    private SaleItemRepository saleItemRepository;
    
    public List<SaleItem> getAllSaleItems(int basketId) {
        List<SaleItem> saleItems = new ArrayList<>();
        
        saleItemRepository.findByBasketId(basketId)
                .forEach(saleItems::add);
        
        return saleItems;
    }
    
    public Optional<SaleItem> getSaleItem(int id) {
        return saleItemRepository.findById(id);
    }
    
    public SaleItem addSaleItem(SaleItem saleItem) {
        saleItem = saleItemRepository.save(saleItem);
        return saleItem;
    }

    public void updateSaleItem(SaleItem saleItem) {
        saleItemRepository.save(saleItem);
    }
    
    public void deleteSaleItem(int id) {
        saleItemRepository.deleteById(id);
    }
}
