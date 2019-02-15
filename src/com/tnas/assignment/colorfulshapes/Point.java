/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tnas.assignment.colorfulshapes;

/**
 * Class that implements the Part 2.2 of the specification.
 * 
 * @since October 30, 2018
 */
public class Point {
    
    private static final Integer DEFAULT_X = 1;
    private static final Integer DEFAUTL_Y = 1;
    
    private Integer untilX;
    private Integer untilY;
    
    public Point() {
        this(DEFAULT_X, DEFAUTL_Y);
    }
    
    public Point(Integer x, Integer y) {
        this.untilX = x;
        this.untilY = y;
    }

    public Integer getUntilX() {
        return untilX;
    }

    public void setUntilX(Integer untilX) {
        this.untilX = untilX;
    }

    public Integer getUntilY() {
        return untilY;
    }

    public void setUntilY(Integer untilY) {
        this.untilY = untilY;
    }
    
}
