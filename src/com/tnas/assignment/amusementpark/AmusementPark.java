/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tnas.assignment.amusementpark;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

/**
 *
 * Class that keeps track of tickets and gift shop inventory.
 * 
 * @since November 30, 2018
 */
public class AmusementPark {
    
    private ArrayList<Ticket> tickets;
    private ArrayList<Merchandise> merchandise;
    private String name;

    public AmusementPark(String name) {
        this.name = name;
        this.tickets = new ArrayList<Ticket>();
        this.merchandise = new ArrayList<Merchandise>();
    }

    /**
     * 
     * @return String - name of bookstore
     */
    public String getName() {
        return name;
    }
    
    /**
     * Show all the dates for which tickets are still available.
     * 
     * @return List of available tickets or empty otherwise
     */
    public ArrayList<Date> getTicketDates() {
        ArrayList<Date> datesList = new ArrayList<>();
        this.tickets.stream()
                .filter(ticket -> ticket.isAvailable())
                .forEach(ticket -> datesList.add(ticket.getDate()));
        return datesList;
    }
    
    /**
     * Returns an integer indicating the number of tickets available
     * for the specified date.
     * 
     * @param date
     * @return 
     */
    public int getTickets(Date date) {
        return (int) this.tickets.stream() 
                .filter(ticket -> ticket.getDate().equals(date))
                .filter(Ticket::isAvailable).count();
    }
    
    public Ticket getTicket(long id) {
        return this.tickets.stream()
                .filter(ticket -> ticket.getNumber() == id)
                .findFirst()
                .orElse(null);
    }
    
    /**
     * Return a list of all the inventory (in-stock and ordered).
     * @return 
     */
    public ArrayList<Merchandise> getMerchandise() {
        ArrayList<Merchandise> inventory = new ArrayList<>();
        this.merchandise.stream()
                .filter(merch -> merch.isInStock())
                .forEach(merch -> inventory.add(merch));
        inventory.sort(Comparator.comparingLong(Merchandise::getId));
        
        return inventory;
    }
    
    /**
     * Returns a list of merchandises whose category matches
     * the specified category.
     * 
     * @param category
     * @return 
     */
    public ArrayList<Merchandise> getMerchandise(String category) {
        ArrayList<Merchandise> merchandises = new ArrayList<>();
        this.merchandise.stream()
                .filter(merch -> merch.getCategory().equals(category))
                .forEach(merch -> merchandises.add(merch));
        return merchandises;
    }
    
    public Merchandise getMerchandise(long id) {
        return this.merchandise.stream()
                .filter(merch -> merch.getId() == id)
                .findAny()
                .orElse(null);
    }
    
    public void addTicket(Ticket ticket) {
        this.tickets.add(ticket);
    }
    
    public void addMerchandise(Merchandise merch) {
        this.merchandise.add(merch);
    }
    
    public void buyMerchandise(String id) throws Exception {
        if (!this.merchandise.removeIf(
                merch -> merch.getId() == Long.valueOf(id))) {
            throw new Exception(String.format(
                            "Merchandise %s not available.", id));
        }
    }
    
    public void buyTicket(String id) throws Exception {
        
        Ticket ticket = getTicket(Long.valueOf(id));
        if (ticket != null && ticket.isAvailable()) {
            this.tickets.removeIf(
                tick -> tick.getNumber() == Long.valueOf(id));
        }
        else {
            throw new Exception(String.format(
                            "Ticket %s not available.", id));
        }
    }
}
