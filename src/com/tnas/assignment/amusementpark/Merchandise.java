/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tnas.assignment.amusementpark;

import java.util.Arrays;
import java.util.List;

/**
 *
 * Class that models merchandise available in the gift shop such as
 * t-shirts, sweatshirts, and stuffed animals.
 * 
 * @since November 30, 2018
 */
public class Merchandise {
    
    public static final String T_SHIRT        = "T-Shirt";
    public static final String SWEATSHIRT     = "Sweatshirt";
    public static final String STUFFED_ANIMAL = "Stuffed Animal";
    private static final String UNKNOWN       = "UNKNOWN";
    
    private static final List<String> supportedCategories = 
        Arrays.asList(new String[]{T_SHIRT, SWEATSHIRT, STUFFED_ANIMAL});
    
    private long id;
    private String category;
    private String description;
    private double price;
    private boolean inStock;

    /**
     * Constructor.
     * 
     * @param id - identify the specific merchandise item
     * @param category - specific type of merchandise
     * @param description - description of the merchandise
     * @param price - price of the merchandise
     * @param inStock - indicate if the merchandise is in stock or on-order
     */
    public Merchandise(long id, String category, String description, 
            double price, boolean inStock) {
        this.id          = id;
        
        if (supportedCategories.contains(category)) {
            this.category = category;
        }
        else {
            System.err.println("Unknown category.");
            this.category = UNKNOWN;
        }
        
        this.description = description;
        this.price       = price;
        this.inStock     = inStock;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setInStock(boolean newStatus) {
        this.inStock = newStatus;
    }

    public long getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public boolean isInStock() {
        return inStock;
    }

    @Override
    public String toString() {
        return "Merchandise{" + "id=" + id + ", category=" + category + 
                ", description=" + description + ", price=" + price + 
                ", inStock=" + inStock + '}';
    }
}
