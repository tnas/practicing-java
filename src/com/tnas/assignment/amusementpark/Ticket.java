/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tnas.assignment.amusementpark;

import java.util.Date;

/**
 *
 * Class responsible for admission tickets.
 * 
 * @since November 30, 2018
 */
public class Ticket {
    
    public static final boolean PURCHASED = true;
    public static final boolean RESERVED  = false;
    
    public static final String ADULT_CATEGORY  = "adult";
    public static final String CHILD_CATEGORY  = "child";
    public static final String SENIOR_CATEGORY = "senior";
    
    private long number;
    private String category;
    private String holder;
    private Date date;
    private double price;
    private Boolean purchaseStatus;

    /**
     * Constructor.
     * 
     * @param number - integer to identify the unique ticket
     * @param category - category of the ticket
     * @param holder - name of the person who purchased the ticket
     * @param date - admission date for the ticket
     * @param price - price of the ticket
     * @param status - indicate if the ticket has been purchased
     */
    public Ticket(long number, String category, String holder, Date date, 
            double price, Boolean status) {
        this.number         = number;
        this.category       = category;
        this.holder         = holder;
        this.date           = date;
        this.price          = price;
        this.purchaseStatus = status;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public void changePurchaseStatus(Boolean newStatus) {
        this.purchaseStatus = newStatus;
    }

    public boolean isAvailable() {
        return this.purchaseStatus == null;
    }
    
    public long getNumber() {
        return number;
    }

    public String getCategory() {
        return category;
    }

    public String getHolder() {
        return holder;
    }

    public Date getDate() {
        return date;
    }

    public double getPrice() {
        return price;
    }

    public Boolean getPurchaseStatus() {
        return purchaseStatus;
    }

    @Override
    public String toString() {
        return "Ticket{" + "number=" + number + ", category=" + category + 
                ", holder=" + holder + ", date=" + date + 
                ", price=" + price + ", status=" + purchaseStatus + '}';
    }
    
}
