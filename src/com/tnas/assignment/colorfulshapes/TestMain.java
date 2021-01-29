/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tnas.assignment.colorfulshapes;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Class that implements the Part 2.7 of the specification.
 * 
 * @since October 30, 2018
 */
public class TestMain {
    
    private final MyShapes shapesContainer;
    
    public TestMain() {
        this.shapesContainer = new MyShapes();
    }

    public MyShapes getShapesContainer() {
        return shapesContainer;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        TestMain testMain = new TestMain();
        
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
        }

        SwingUtilities.invokeLater(() -> {
            new GUIShapes(testMain.getShapesContainer());
        });
    }
    
}
