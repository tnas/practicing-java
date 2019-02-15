/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tnas.assignment.colorfulshapes;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class that implements the Part 2.6 of the specification.
 * 
 * @since October 30, 2018
 */
public class MyShapes {
    
    private static final String SHAPES_FILE_NAME = "shapes.txt";
    private static final String NO_SHAPES_MSG = 
            "There are no shapes in the collection";
    
    private Map<String, Shape> myShapes;
    
    public MyShapes() {
        this.myShapes = new HashMap<String, Shape>();
    }
        
    public void addOval(Oval oval) {
        this.myShapes.put(getShapeKey(oval), oval);
    }
    
    public void addRectangle(Rectangle rectangle) {
        this.myShapes.put(getShapeKey(rectangle), rectangle);
    }
    
    public String showShapes() {
        
        if (this.myShapes.isEmpty()) return NO_SHAPES_MSG;
        
        String shapesRepresentation = new String();
        StringWriter stringWriter = new StringWriter();
        
        try (PrintWriter writer = new PrintWriter(stringWriter, true)) {
            
            this.myShapes.values().forEach((shape) -> {
                writer.println(shape.toString());
            });

            shapesRepresentation = stringWriter.toString();
            stringWriter.close();
            
        } catch (IOException ex) {
            Logger.getLogger(MyShapes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return shapesRepresentation;
    }
    
    /**
     * Method which saves a String representation for all shapes
     * in the collection in a file on the PC.
     */
    public void saveShapesInFile() {
        
        try (PrintWriter fileWriter = new PrintWriter(SHAPES_FILE_NAME)) {
            String shapesRepresentation = showShapes();
            fileWriter.print(shapesRepresentation);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MyShapes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Method the creates the key of a Shape object by concatenating it's
     * type and it's counter.
     * 
     * @param shape - instance of Shape
     * @return String - shape's key
     */
    private String getShapeKey(Shape shape) {
        return shape.getClass().getTypeName().concat("-").
                concat(String.valueOf(shape.getCounter()));
    }
}
