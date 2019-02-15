/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tnas.assignment.colorfulshapes;

/**
 * Class that implements the Part 2.3 of the specification.
 * 
 * @since October 30, 2018
 */
public abstract class Shape implements Colourful {

    private Point p1;
    
    public Shape(Point point1) {
        this.p1 = point1;
    }
    
    @Override
    public abstract void assignMyColour(String colour);
    
    public abstract Integer getCounter();

    public Point getP1() {
        return p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }
    
    @Override
    public String toString() {
        if (this.p1 != null)
            return String.format("(%d, %d)", 
                    this.p1.getUntilX(), this.p1.getUntilY());
        else
            return "(null, null)";
    }
    
}
