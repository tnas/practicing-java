package com.tnas.assignment.converter;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * The program carries out two types of conversion:
 * 1. Temperature: from Fahrenheit to Celsius
 * 2. Distance: from Miles to Kilometers
 * 
 * It offers a user-friendly interface for both conversions.
 * 
 * @author Full Name
 * @since February 18, 2021
 *
 */
public class GUIConverter {

	private static final int FRAME_WIDTH  = 500;
	private static final int FRAME_HEIGHT = 300;
	
	private static final String WELCOME_MSG = "Welcome to converter";
	private static final String ERROR_MSG = "Invalid entered value";
	private static final String ERROR_TITLE = "Error";

	private static JButton buildConverterButton(Component parent, String buttonTitle, String inputTitle, 
			String convertedMsg, Converter converter) {
		JButton distButton = new JButton(buttonTitle);
		distButton.addActionListener(e -> {
			try {
				String input = JOptionPane.showInputDialog(inputTitle);
				
				// Handling cancel option
				if (input == null || input.trim().isEmpty()) return;
				
				// Converting the entered value
				double miles = Double.parseDouble(input);
				converter.setValue(miles);
				
				// Showing the conversion
				JOptionPane.showMessageDialog(parent, 
						String.format(convertedMsg, miles, converter.convert()));
			} catch (Exception ex) { 
				// For non-numeric inputs
				JOptionPane.showMessageDialog(parent, ERROR_MSG, ERROR_TITLE, 
						JOptionPane.ERROR_MESSAGE);
			}
		});
		
		return distButton;
	}
	
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.ENGLISH);
		
		Converter distConverter = new DistanceConverter();
		Converter tempConverter = new TemperatureConverter();

		JPanel panel = new JPanel(new BorderLayout());
		
		// Adding three buttons to the panel
		JButton distButton = buildConverterButton(panel, "Distance Converter", 
				"Input miles distance to convert", "%.1f miles equals %.4f Km", distConverter);
		panel.add(distButton, BorderLayout.WEST);
		
		JButton tempButton = buildConverterButton(panel, "Temperature Converter", 
				"Input fahrenheit temperature to convert", "%.1f F equals %.1f C", tempConverter);
		panel.add(tempButton, BorderLayout.CENTER);
		
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(e -> System.exit(0));
		panel.add(exitButton, BorderLayout.PAGE_END);
		
		// Main window of the system
		JFrame appFrame = new JFrame(WELCOME_MSG);
		appFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		appFrame.setLocale(Locale.ENGLISH);
		appFrame.add(panel);
		appFrame.setLocationRelativeTo(null); // centering window on screen
		appFrame.setVisible(true);
	}

}
