/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tnas.assignment.colorfulshapes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * Class that implements a GUI for the Part 2.7 of the specification.
 * 
 * @since October 30, 2018
 */
public class GUIShapes {
    
    private final MyShapes shapesContext;
    
    public GUIShapes(MyShapes context) {
        
        this.shapesContext = context;
   
        JTextArea showShapesTextArea = new JTextArea(20,20);
        showShapesTextArea.setLineWrap(true);
        showShapesTextArea.setWrapStyleWord(true);
        showShapesTextArea.setMargin(new Insets(5, 5, 5,5));
        JLabel englishTextLabel = new JLabel("English Text");
        englishTextLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel controlPanel = getControlPanel(showShapesTextArea);
        mainPanel.add(controlPanel, BorderLayout.NORTH);
        mainPanel.add(getInstructionPanel(), BorderLayout.CENTER);
        mainPanel.add(showShapesTextArea, BorderLayout.SOUTH);
        
        JFrame frame = new JFrame();
        frame.setTitle("My Shapes App");
        frame.setLayout(new BorderLayout());
        frame.add(mainPanel, BorderLayout.CENTER);
        frame.setSize(new Dimension(800, 650));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
    
    
    private JSplitPane getInstructionPanel() {
        
        JSplitPane instructionPanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT, null, null);
        instructionPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        instructionPanel.add(new JLabel());
        instructionPanel.add(new JLabel(""
                + "<html><body>"
                + "* Project M257_TMA_FALL18_613531: My Shapes App - Version 1.0"
                + "<br><br>"
                + "*Instructions: <br>"
                + "(1) For the points coordinates, use just Integer values.<br>"
                + "(2) Fill all the fields related to a shape to be added before "
                + "to click on the respective add button."
                + "</bod></html>"));
        
        return instructionPanel;
    }
    
    private JPanel getControlPanel(JTextArea showShapesArea) {      
        
        //Button for listing shapes
        JButton listShapesBtn = new JButton("List All Shapes");
        listShapesBtn.addActionListener((e) -> {
            showShapesArea.setText(this.shapesContext.showShapes());
        });
       
        JPanel controlPanel = new JPanel(new GridLayout(1, 3));
        controlPanel.add(getOvalAddPanel(), BorderLayout.WEST);
        controlPanel.add(getRectangleAddPanel(), BorderLayout.CENTER);
        controlPanel.add(listShapesBtn, BorderLayout.EAST);
        
        return controlPanel;
    }
    
    private JPanel getOvalAddPanel() {
        
        JPanel inputOvalPanel = new JPanel(new GridLayout(3, 4));
        inputOvalPanel.add(new JLabel("P1:X"));
        JTextField ovalP1XInput = new JTextField();
        inputOvalPanel.add(ovalP1XInput);
        
        inputOvalPanel.add(new JLabel("P1:Y"));
        JTextField ovalP1YInput = new JTextField();
        inputOvalPanel.add(ovalP1YInput);
        
        inputOvalPanel.add(new JLabel("Width"));
        JTextField ovalWidthInput = new JTextField();
        inputOvalPanel.add(ovalWidthInput);
        
        inputOvalPanel.add(new JLabel("Height"));
        JTextField ovalHeightInput = new JTextField();
        inputOvalPanel.add(ovalHeightInput);
        
        inputOvalPanel.add(new JLabel("Color"));
        JTextField ovalColorInput = new JTextField();
        inputOvalPanel.add(ovalColorInput);
        
        JButton addOvalBtn = new JButton("Add Oval Shape");
        addOvalBtn.addActionListener((e) -> {
            
            Point p1 = new Point();
            p1.setUntilX(Integer.valueOf(ovalP1XInput.getText()));
            p1.setUntilY(Integer.valueOf(ovalP1YInput.getText()));
            Oval ovalShape = new Oval(p1);
            ovalShape.assignMyColour(ovalColorInput.getText());
            ovalShape.setWidth(Integer.valueOf(ovalWidthInput.getText()));
            ovalShape.setHeight(Integer.valueOf(ovalHeightInput.getText()));
            
            this.shapesContext.addOval(ovalShape);
            JOptionPane.showMessageDialog(null, 
                    "Oval shape has been added with success!", 
                    "Message", JOptionPane.INFORMATION_MESSAGE);
            
            ovalP1XInput.setText(null);
            ovalP1YInput.setText(null);
            ovalWidthInput.setText(null);
            ovalHeightInput.setText(null);
            ovalColorInput.setText(null);
        });
        
        JPanel addOvalPanel = new JPanel(new GridLayout(2, 1));
        addOvalPanel.add(addOvalBtn);
        addOvalPanel.add(inputOvalPanel);
        
        return addOvalPanel;
    }
    
    private JPanel getRectangleAddPanel() {
        
        JPanel inputRectanglePanel = new JPanel(new GridLayout(3, 4));
        
        inputRectanglePanel.add(new JLabel("P1:X"));
        JTextField rectangleP1XInput = new JTextField();
        inputRectanglePanel.add(rectangleP1XInput);
        
        inputRectanglePanel.add(new JLabel("P1:Y"));
        JTextField rectangleP1YInput = new JTextField();
        inputRectanglePanel.add(rectangleP1YInput);
        
        inputRectanglePanel.add(new JLabel("P2:X"));
        JTextField rectangleP2XInput = new JTextField();
        inputRectanglePanel.add(rectangleP2XInput);
        
        inputRectanglePanel.add(new JLabel("P2:Y"));
        JTextField rectangleP2YInput = new JTextField();
        inputRectanglePanel.add(rectangleP2YInput);
        
        inputRectanglePanel.add(new JLabel("Color"));
        JTextField rectangleColorInput = new JTextField();
        inputRectanglePanel.add(rectangleColorInput);
        
        JButton addRectangleBtn = new JButton("Add Rectangle Shape");
        addRectangleBtn.addActionListener((e) -> {
            
            Point p1 = new Point();
            p1.setUntilX(Integer.valueOf(rectangleP1XInput.getText()));
            p1.setUntilY(Integer.valueOf(rectangleP1YInput.getText()));
            
            Point p2 = new Point();
            p2.setUntilX(Integer.valueOf(rectangleP2XInput.getText()));
            p2.setUntilY(Integer.valueOf(rectangleP2YInput.getText()));
            
            String colourName = rectangleColorInput.getText();
            
            Rectangle rectangle = new Rectangle(p1, p2, colourName); 
            this.shapesContext.addRectangle(rectangle);
            
            JOptionPane.showMessageDialog(null, 
                    "Rectangle shape has been added with success!", 
                    "Message", JOptionPane.INFORMATION_MESSAGE);
            
            rectangleP1XInput.setText(null);
            rectangleP1YInput.setText(null);
            rectangleP2XInput.setText(null);
            rectangleP2YInput.setText(null);        
            rectangleColorInput.setText(null);
        });
        
        JPanel addRectanglePanel = new JPanel(new GridLayout(2, 1));
        addRectanglePanel.add(addRectangleBtn);
        addRectanglePanel.add(inputRectanglePanel);
        
        return addRectanglePanel;
    }
    
    
}
