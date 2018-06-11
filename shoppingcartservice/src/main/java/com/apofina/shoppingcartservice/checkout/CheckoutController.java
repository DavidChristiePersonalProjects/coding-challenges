/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apofina.shoppingcartservice.checkout;

import com.apofina.shoppingcartservice.saleitem.SaleItem;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author David
 */
@RestController
public class CheckoutController {
    
    @Autowired
    CheckoutService checkoutService;
    
    @CrossOrigin
    @RequestMapping("/checkout/{basket.id}")
    public List<SaleItem> checkout(@PathVariable("basket.id") int basketId) {
        return checkoutService.checkout(basketId);
    }
}
