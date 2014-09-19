package guitutorial;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//awt : Abstract Window Toolkit

public class EmptyWindow {

	public static void main(String[] args){
		JFrame win = new EgWindow(); //Create a window
		win.show(); //Display it
	}
}
	class EgWindow extends JFrame{
		//
		//*The constructor for EgWindow
		//****************************
		public EgWindow(){
			setTitle("Empty Window Example");
			setSize(600, 600); //setSize(int width, int height)
			
			addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent e){
					System.exit(0);
				}
				
			});
		}
	}
