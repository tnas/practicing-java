/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tnas.assignment.amusementpark;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Tester Class.
 * 
 * @since November 30, 2018
 */
public class AmusementParkTester {
    
    private static final String PARK_NAME = "Walden Amusement Park";
    
    private static final SimpleDateFormat DATE_FORMAT = 
            new SimpleDateFormat("yyyy-MM-dd");
    
    private static final int LOOKUP_TICKETS_ACTION     = 1;
    private static final int LOOKUP_MERCHANDISE_ACTION = 2;
    private static final int PURCHASE_ITEMS_ACTION     = 3;
    private static final int EXIT_STORE_ACTION         = 4;
    
    private static final int BUY_TICKET_ACTION         = 1;
    private static final int BUY_MERCHANDISE_ACTION    = 2;
    
    private static final int LOOKUP_TICKET_BY_DATE_ACTION  = 1;
    private static final int LIST_TICKETS_AVAILABLE_ACTION = 2;
    private static final int LOOKUP_TICKET_BY_ID_ACTION    = 3;
    
    private static final int LOOKUP_MERCHANDISE_BY_CATEGORY_ACTION  = 1;
    private static final int LIST_INVENTORY_ACTION = 2;
    
    private static boolean userActive = true;
    private static Scanner scanner = new Scanner(System.in);
    
    private static Map<Integer, String> mapCategory = 
            new HashMap<Integer, String>();
    static {
        mapCategory.put(1, Merchandise.T_SHIRT);
        mapCategory.put(2, Merchandise.SWEATSHIRT);
        mapCategory.put(3, Merchandise.STUFFED_ANIMAL);
    }
    
    public static void main(String[] args) throws ParseException {
        
        AmusementPark amusementPark = new AmusementPark(PARK_NAME);
        int userActionOption;
        
        // Loading Tickets
        loadTickets(amusementPark);
        
        // Loading Appareal
        loadMerchandises(amusementPark);
        
        System.out.println("==========================================");
        System.out.println(String.format("Welcome to %s!", PARK_NAME));
        System.out.println("==========================================");
        
        while (userActive) {
            showOptions();
            userActionOption = scanner.nextInt();
            
            switch (userActionOption) {
                
                case LOOKUP_TICKETS_ACTION :
                    lookupTicketAction(amusementPark);
                    break;
                    
                case LOOKUP_MERCHANDISE_ACTION : 
                    lookupMerchandiseAction(amusementPark);
                    break;
                    
                case PURCHASE_ITEMS_ACTION :
                    buyItemAction(amusementPark);
                    break;
                    
                case EXIT_STORE_ACTION :
                    userActive = false;
                    break;
                    
                default :
                    System.out.println("Invalid operation.");
            }
        }
        
        scanner.close();
    }
    
    public static void loadTickets(AmusementPark amusementPark) 
            throws ParseException {
        amusementPark.addTicket(new Ticket(1, Ticket.ADULT_CATEGORY, 
                "Julian Mercado", DATE_FORMAT.parse("2018-12-10"), 100.0, 
                Ticket.PURCHASED));
        amusementPark.addTicket(new Ticket(2, Ticket.ADULT_CATEGORY, 
                "Zephania Villarreal", DATE_FORMAT.parse("2018-12-11"), 100.0, 
                Ticket.PURCHASED));
        amusementPark.addTicket(new Ticket(3, Ticket.ADULT_CATEGORY, 
                null, DATE_FORMAT.parse("2018-12-12"), 100.0, null));
        amusementPark.addTicket(new Ticket(4, Ticket.ADULT_CATEGORY, 
                null, DATE_FORMAT.parse("2018-12-13"), 100.0, null));
        amusementPark.addTicket(new Ticket(5, Ticket.ADULT_CATEGORY, 
                null, DATE_FORMAT.parse("2018-12-14"), 100.0, null));
        amusementPark.addTicket(new Ticket(6, Ticket.ADULT_CATEGORY, 
                null, DATE_FORMAT.parse("2018-12-14"), 100.0, null));
    }
    
    public static void loadMerchandises(AmusementPark amusementPark) {
        amusementPark.addMerchandise(new Merchandise(
            10, Merchandise.T_SHIRT, "Polo Gray", 80.0, true));
        amusementPark.addMerchandise(new Merchandise(
            11, Merchandise.T_SHIRT, "Polo Brown", 80.0, true));
        amusementPark.addMerchandise(new Merchandise(
            20, Merchandise.SWEATSHIRT, "Neck Style White", 100.0, true));
        amusementPark.addMerchandise(new Merchandise(
            21, Merchandise.SWEATSHIRT, "Neck Style Black", 100.0, true));
        amusementPark.addMerchandise(new Merchandise(
            30, Merchandise.STUFFED_ANIMAL, "Long Sleeve Blue", 120.0, true));
        amusementPark.addMerchandise(new Merchandise(
            31, Merchandise.STUFFED_ANIMAL, "Long Sleeve Green", 120.0, true));
        amusementPark.addMerchandise(new Merchandise(
            41, "Electronic", "Personal Computer", 1200.0, true));
        amusementPark.addMerchandise(new Merchandise(
            51, Merchandise.T_SHIRT, "Fashiong Mix Colors", 80.0, false));
    }
    
    public static void showOptions() {
        System.out.print("Here are our services. ");
        System.out.println("Feel free to choose an option:");
        System.out.println("(1) Look up tickets");
        System.out.println("(2) Look up merchandise");
        System.out.println("(3) Purchase items");
        System.out.println("(4) Exit to the store");
    }
    
    public static void buyItemAction(AmusementPark amusement) {
        
        long idItem;
        System.out.println("Enter the type of the item to buy:");
        System.out.println("(1) Ticket");
        System.out.println("(2) Merchandise");
        
        switch (scanner.nextInt()) {
            
            case BUY_TICKET_ACTION : 
                System.out.println("Enter the id of Ticket:");
                idItem = scanner.nextLong();
        
                try {
                    amusement.buyTicket(String.valueOf(idItem));
                    System.out.println("Ticket has been succeeded bought");
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
        
                break;
                
            case BUY_MERCHANDISE_ACTION :
                System.out.println("Enter the id of Merchandise:");
                idItem = scanner.nextLong();
        
                try {
                    amusement.buyMerchandise(String.valueOf(idItem));
                    System.out.println("Merchandise has been succeeded bought");
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }

                break;
                
            default:
                System.out.println("Invalid option.");
        }
    }
    
    public static void lookupTicketAction(AmusementPark amusement) {
        
        System.out.println("Enter the form to lookup tickets:");
        System.out.println("(1) Show the number of avaiable tickets by date");
        System.out.println("(2) List all available dates");
        System.out.println("(2) Lookup ticket by identifier");
        
        switch (scanner.nextInt()) {
                
            case LOOKUP_TICKET_BY_DATE_ACTION :
                System.out.println("Inform the date (yyyy-MM-dd):");
        
                try {
                    int numTickets = 
                            amusement.getTickets(DATE_FORMAT.parse(scanner.next()));
                    System.out.println(String.format("There is %d tickets availables "
                            + "for the informed date.", numTickets));
                } catch (ParseException ex) {
                    System.out.println("Invalid date format.");
                }
        
                break;
                
            case LIST_TICKETS_AVAILABLE_ACTION :
                System.out.println("List of all available dates:");
                amusement.getTicketDates().stream()
                        .forEach(date -> System.out.println(DATE_FORMAT.format(date)));
                break;
                
            case LOOKUP_TICKET_BY_ID_ACTION :
                System.out.println("Inform the id of the ticket:");
                Ticket ticket = amusement.getTicket(scanner.nextLong());
                
                if (ticket != null) {
                    System.out.println(ticket.toString());
                }
                else {
                    System.out.println("Selected ticket not found.");
                }
            
                break;
                
            default :
                System.out.println("Invalid option.");
        }
    }
    
    public static void lookupMerchandiseAction(AmusementPark amusement) {
        
        System.out.println("Enter the form to lookup merchandises:");
        System.out.println("(1) List merchandises by category");
        System.out.println("(2) List all the inventory");
        
        switch (scanner.nextInt()) {
                
            case LOOKUP_MERCHANDISE_BY_CATEGORY_ACTION :
                System.out.println("Inform the category:");
                System.out.println("(1) T-Shirt");
                System.out.println("(2) Sweatshirt");
                System.out.println("(3) Stuffed Animal");
                amusement.getMerchandise(mapCategory.get(scanner.nextInt()))
                        .stream()
                        .forEach(merch -> System.out.println(merch.toString()));
                break;
                
            case LIST_INVENTORY_ACTION :
                System.out.println("Full inventory ordered by id:");
                amusement.getMerchandise().stream()
                        .forEach(merch -> System.out.println(merch.toString()));
                break;
                
            default :
                System.out.println("Invalid option.");
        }
    }
}

