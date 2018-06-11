/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apofina.shoppingcartservice.basket;

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
public class BasketService {
    
    @Autowired
    private BasketRepository basketRepository;
    
    public List<Basket> getAllBaskets() {
        List<Basket> baskets = new ArrayList<>();
        
        basketRepository.findAll()
                .forEach(baskets::add);
        
        return baskets;
    }
    
    public Optional<Basket> getBasket(int id) {
        return basketRepository.findById(id);
    }
    
    public Basket addbasket(Basket basket) {
        basket = basketRepository.save(basket);
        return basket;
    }
    
    public void updateBasket(Basket basket) {
        basketRepository.save(basket);
    }
    
    public void deleteBasket(int id) {
        basketRepository.deleteById(id);
    }
}
