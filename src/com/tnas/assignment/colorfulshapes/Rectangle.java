/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tnas.assignment.colorfulshapes;

/**
 * Class that implements the Part 2.5 of the specification.
 * 
 * @since October 30, 2018
 */
public class Rectangle extends Shape {

    private static Integer counterR = 0;
    private static String RECTANGLE_TO_STRING =
            "The Rectangle starts at (%d, %d) and end at (%d, %d) "
            + "it's colour is %s";
    
    private Point p2;
    private String myColour;

    public Rectangle(Point point1) {
        super(point1);
        ++counterR;
    }
    
    public Rectangle(Point p1, Point p2, String colourName) {
        this(p1);
        this.p2 = p2;
        this.myColour = colourName;
    }
    
    @Override
    public void assignMyColour(String colour) {
        this.myColour = colour; 
    }

    @Override
    public Integer getCounter() {
        return counterR;
    }

    public static void setCounter(Integer counterR) {
        Rectangle.counterR = counterR;
    }

    public Point getP2() {
        return p2;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

    public String getMyColour() {
        return myColour;
    }

    public void setMyColour(String myColour) {
        this.myColour = myColour;
    }
    
    @Override
    public String toString() {
        return String.format(RECTANGLE_TO_STRING, 
                this.getP1().getUntilX(), this.getP1().getUntilY(),
                this.p2.getUntilX(), this.p2.getUntilY(), this.myColour);
    }
}
