/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tnas.assignment.colorfulshapes;

/**
 * Class that implements the Part 2.4 of the specification.
 * 
 * @since October 30, 2018
 */
public class Oval extends Shape {

    private static Integer counter = 0;
    private static final Integer DEFAULT_WIDTH = 80;
    private static final Integer DEFAULT_HIGHT = 90;
    private static String OVAL_TO_STRING =
            "The Oval in (%d, %d) it's width is %d, it's height is %d,"
            + " and it's colour is %s";
            
    private Integer width;
    private Integer height;
    private String myColour;
    
    public Oval(Point point1) {
        super(point1);
        this.width  = DEFAULT_WIDTH;
        this.height = DEFAULT_HIGHT;
        ++counter;
    }
    
    public Oval(Integer width, Integer height, String colour) {
        this(new Point(width, height));
        this.width    = width;
        this.height   = height;
        this.myColour = colour;
    }
    
    @Override
    public void assignMyColour(String colour) {
        this.myColour = colour; 
    }

    @Override
    public Integer getCounter() {
        return counter;
    }

    public void setCounter(Integer counter) {
        Oval.counter = counter;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return String.format(OVAL_TO_STRING, 
                this.getP1().getUntilX(), this.getP1().getUntilY(),
                this.width, this.height, this.myColour);
    }
    
}
