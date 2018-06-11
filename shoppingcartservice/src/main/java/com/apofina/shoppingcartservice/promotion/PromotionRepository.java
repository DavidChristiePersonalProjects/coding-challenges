/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apofina.shoppingcartservice.promotion;

import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author David
 */
public interface PromotionRepository extends CrudRepository<Promotion, Integer> {
    
    public Iterable<Promotion> findBySaleItemId(int id);
    
}
