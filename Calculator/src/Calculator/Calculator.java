package Calculator;

import java.awt.*; //essential for visual components
import javax.swing.*; //essential for componets and to set our visual feel.
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener{

	JPanel[] row = new JPanel[5];
	JButton[] button = new JButton[19];
	
	String[] buttonString = {"7", "8", "9", "+",
							"4", "5", "6", "-",
							"1", "2", "3", "*",
							".", "/", "C", "√",
							"+/-", "=", "0"}; 
	int[] dimW = {300, 45, 100, 90};
	int[] dimH = {35, 40}; // our heights will be 35 for display and 40 for buttons.
							
	//Declare and intialize dimensions.
	
	Dimension displayDimension = new Dimension(dimW[0], dimH[0]); //Uses the first integer with width, and the first
																 // integer in height.
	Dimension regularDimension = new Dimension(dimW[1], dimH[1]); // Uses the second integer in the widtth, and 
																  // second integer in the height.
	Dimension rColumnDimension = new Dimension(dimW[2], dimH[1]); //Uses the third integer in the width, and the second
																  // integer in the height.
	Dimension zeroButDimension = new Dimension(dimW[3], dimH[1]); //Uses the 4th integer in width, second integer in height.
							
	//Declare booleans for our functions - adding, subtacting, multiplying, and dividing.
	//Use an array.
	
	boolean[] function = new boolean[4]; // not intialized yet.
	
	//Declare dobules for our calculations
	double[] temporary = {0, 0};
	
	//Create display using JTextArea
	JTextArea display = new JTextArea(1, 20);
	
	//For design purpose
	Font font = new Font("Times new Roman", Font.BOLD, 14);
	
	//Declare the constructor
	Calculator() {
		super("Calculator");
		setDesign();
		setSize(380, 250);
		setResizable(false); //Make it so the frame cannot be resized, which can cause layout to be messed up.
		setDefaultCloseOperation(EXIT_ON_CLOSE); // to exit the frame when closed.
		GridLayout grid = new GridLayout(5, 5); //first 5 in number of rows, second 5 for up to how many componets we allow in row.
		setLayout(grid);
		
		for(int i = 0; i < 4; i++){
			function[i] = false;
		}
		
		FlowLayout f1 = new FlowLayout(FlowLayout.CENTER);
		FlowLayout f2 = new FlowLayout(FlowLayout.CENTER, 1, 1);
	
		for(int i = 0; i < 5; i++){
			row[i] = new JPanel();
		}
		
		row[0].setLayout(f1);
		for(int i = 1; i < 5; i++){
			row[i].setLayout(f2);
		}
		
		for(int i = 0; i < 19; i++){
			button[i] = new JButton();
			button[i].setText(buttonString[i]);
			button[i].setFont(font);
			button[i].addActionListener(this);
		}
		
		display.setFont(font);
		display.setEditable(false);
		display.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		display.setPreferredSize(displayDimension);
		for(int i = 0; i < 14; i++){
			button[i].setPreferredSize(regularDimension);
			
		}
		for(int i = 14; i < 18; i++){
			button[i].setPreferredSize(rColumnDimension);
		}
		button[18].setPreferredSize(zeroButDimension);
		
		row[0].add(display);
		add(row[0]);
		
		//To add the component to the panel use panel.add(component)
		//row[0].add(display) this adds our display to row1.
		
		for(int i = 0; i < 4; i++){
			row[1].add(button[i]);
		}
		row[1].add(button[14]);
		add(row[1]);
		
		for(int i=4; i < 8; i++){
			row[2].add(button[i]);
		}
		row[2].add(button[15]);
		add(row[2]);
		
		for(int i=8; i < 12; i++){
			row[3].add(button[i]);
		}
		row[3].add(button[16]);
		add(row[3]);
		
		row[4].add(button[18]);
		for(int i = 12; i<14; i++){
			row[4].add(button[i]);
		}
		row[4].add(button[17]);
		add(row[4]);
		
		setVisible(true);
		
	}
	
	public final void setDesign(){
		try{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		}
		catch(Exception e){
			
		}
	}
	
	/*
	 * To make our button work
	 * (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource() == button[0]){
			display.append("7");
		}
		if(ae.getSource() == button[0]){
			display.append("8");
		}
		if(ae.getSource() == button[2]){
			display.append("9");
		}
		if(ae.getSource() == button[3]){
			//add function [0]
			temporary[0] = Double.parseDouble(display.getText());
			function[0] = true;
			display.setText("");
		}
		
		if(ae.getSource() == button[4]){
			display.append("4");
		}
		if(ae.getSource() == button[5]){
			display.append("5");
		}
		if(ae.getSource() == button[6]){
			display.append("6");
		}
		if(ae.getSource() == button[7]){
			//add function [0]
			temporary[0] = Double.parseDouble(display.getText());
			function[1] = true;
			display.setText("");
		}
		
		if(ae.getSource() == button[8]){
			display.append("1");
		}
		if(ae.getSource() == button[9]){
			display.append("2");
		}
		if(ae.getSource() == button[10]){
			display.append("3");
		}
		if(ae.getSource() == button[11]){
			//add function [0]
			temporary[0] = Double.parseDouble(display.getText());
			function[2] = true;
			display.setText("");
		}
		
		if(ae.getSource() == button[12]){
			display.append(".");
		}
		if(ae.getSource() == button[13]){
			temporary[0] = Double.parseDouble(display.getText());
			function[3] = true;
			display.setText("");
		}
		
		if(ae.getSource() == button[14]){
			clear();
		}
		if(ae.getSource() == button[15]){
			getSqrt();
		}
		if(ae.getSource() == button[16]){
			getPosNeg();
		}
		if(ae.getSource() == button[17]){
			getResult();
		}
		if(ae.getSource() == button[18]){
			display.append("0");
		}
		
	}
	
	public void clear(){
		try{
			display.setText(""); //Sets the display blank
			for(int i = 0; i < 4; i++){
				function[i] = false; // Sets the function back to false
			}
			for(int i = 0; i < 2; i++){
				temporary[i] = 0; //Set our temporary variablees back to 0
			} 
			
		}
		catch(NullPointerException e){
			
		}
	}
	
	/*
	 *  method for square root
	 */
	public void getSqrt(){
		try{
			double value = Math.sqrt(Double.parseDouble(display.getText())); // Create a variable for value, and use 
														 // Math's squre root to find value.
			display.setText(Double.toString(value));
		}
		catch(NumberFormatException e){
			
		}
		
	}
	
	//Positive negative method
	public void getPosNeg(){
		try{
			double value = Double.parseDouble(display.getText());
			// we create a variable for our current value
			if (value != 0){
				value = value * (-1);
				display.setText(Double.toString(value));
			}
		}
		catch(NumberFormatException e){
			
		}
	}
	
	/*
	 * Result method
	 */
	
	public void getResult(){
		double result = 0; // variable for reusult
		temporary[1] = Double.parseDouble(display.getText()); // Our second temp number from display
		
		String temp0 = Double.toString(temporary[0]); //necessary string for text of first temp
		String temp1 = Double.toString(temporary[1]); //necessary string for text of second temp
		
		try{
			if(temp0.contains("-")){
				String[] temp00 = temp0.split("-", 2); //If first string contains - (negative number)
				temporary[0] = (Double.parseDouble(temp00[1]) * -1);
			}
			if(temp1.contains("-")){
				String[] temp11 = temp1.split("-", 2);
				temporary[1] = (Double.parseDouble(temp11[1]) * -1);
			}
		}
		catch(ArrayIndexOutOfBoundsException e){
			
		}
		try{
			if(function[2] == true){
				result = temporary[0] * temporary[1]; // sets result to multiplication of function.
			}
			else if(function[3] == true){
				result = temporary[0] / temporary[1];
			}
			else if(function[0] == true){
				result = temporary[0] + temporary[1];
			}
			else if(function[1] == true){
				result = temporary[0] - temporary[1];
			}
			display.setText(Double.toString(result)); // display now has result
			for(int i = 0; i < 4; i++){
				function[i] = false; // set all the functions back to false.
			}
		}
		catch(NumberFormatException  e){
			
		}
	}
	
	public static void main(String[] arguments){
		Calculator c = new Calculator();
	}
	
}

