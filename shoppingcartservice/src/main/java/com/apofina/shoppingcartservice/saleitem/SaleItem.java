/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apofina.shoppingcartservice.saleitem;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

import com.apofina.shoppingcartservice.basket.Basket;
import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 *
 * @author David
 */
@Entity
public class SaleItem {
    
    @Id       
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String productId;
    private int quantity;
    private int pricePerUnit;
    private int unadjustedPrice;
    private int adjustedPrice;
    @ManyToOne
    @JsonIgnore
    private Basket basket;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(int pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public int getUnadjustedPrice() {
        return unadjustedPrice;
    }

    public void setUnadjustedPrice(int unadjustedPrice) {
        this.unadjustedPrice = unadjustedPrice;
    }

    public int getAdjustedPrice() {
        return adjustedPrice;
    }

    public void setAdjustedPrice(int adjustedPrice) {
        this.adjustedPrice = adjustedPrice;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public SaleItem() {
    }

    public SaleItem(int id, String productId, int quantity, int pricePerUnit, int unadjustedPrice, int adjustedPrice, Basket basket) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
        this.unadjustedPrice = unadjustedPrice;
        this.adjustedPrice = adjustedPrice;
        this.basket = basket;
    }

    public SaleItem(int id, int basketId) {
        this.id = id;
        this.productId = "";
        this.quantity = -1;
        this.pricePerUnit = -1;
        this.unadjustedPrice = -1;
        this.adjustedPrice = -1;
        this.basket = new Basket(basketId);
    }
    
}
