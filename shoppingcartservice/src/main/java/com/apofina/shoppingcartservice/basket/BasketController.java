/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apofina.shoppingcartservice.basket;

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
public class BasketController {
    
    @Autowired
    private BasketService basketService;
    
    @RequestMapping("/baskets")
    public List<Basket> getAllBaskets() {
        return basketService.getAllBaskets();
    }
    
    @RequestMapping("/baskets/{basket.id}")
    public Basket getBasket(@PathVariable("basket.id") int id) {
        return basketService.getBasket(id)
                .orElseThrow(IllegalArgumentException::new);
    }
    
    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/baskets")
    public Basket addBasket(@RequestBody Basket basket) {
        return basketService.addbasket(basket);
    }
    
    @RequestMapping(method = RequestMethod.PUT, value = "baskets/{basket.id}")
    public void updateBasket(@RequestBody Basket basket) {
        basketService.updateBasket(basket);
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value = "/baskets/{basket.id}")
    public void deleteBasket(@PathVariable("basket.id") int id) {
        basketService.deleteBasket(id);
    }
}
