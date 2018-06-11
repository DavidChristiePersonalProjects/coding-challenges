/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apofina.shoppingcartservice.saleitem;

import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author David
 */
public interface SaleItemRepository extends CrudRepository<SaleItem, Integer> {
    
    public Iterable<SaleItem> findByBasketId(int id);
            
}
