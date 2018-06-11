/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apofina.shoppingcartservice.promotion;

import javax.persistence.Entity;
import javax.persistence.Id;
import com.apofina.shoppingcartservice.saleitem.SaleItem;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

/**
 *
 * @author David
 */
@Entity
public class Promotion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String promotionId;
    private String type;
    private int amount;
    private int requiredQuantity;
    private int freeQuantity;
    private int price;
    @ManyToOne
    @JsonIgnore
    private SaleItem saleItem;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(String promotionId) {
        this.promotionId = promotionId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getRequiredQuantity() {
        return requiredQuantity;
    }

    public void setRequiredQuantity(int requiredQuantity) {
        this.requiredQuantity = requiredQuantity;
    }

    public int getFreeQuantity() {
        return freeQuantity;
    }

    public void setFreeQuantity(int freeQuantity) {
        this.freeQuantity = freeQuantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public SaleItem getSaleItem() {
        return saleItem;
    }

    public void setSaleItem(SaleItem saleItem) {
        this.saleItem = saleItem;
    }

    public Promotion() {
    }

    public Promotion(int id, String promotionId, String type, int amount, int requiredQuantity, int freeQuantity, int price, SaleItem saleItem) {
        this.id = id;
        this.promotionId = promotionId;
        this.type = type;
        this.amount = amount;
        this.requiredQuantity = requiredQuantity;
        this.freeQuantity = freeQuantity;
        this.price = price;
        this.saleItem = saleItem;
    }
    
    
    
}
