package guitutorial;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


//public class, where program executes
public class WindowWithComponent {
	
	public static void main(String[] args){
		JFrame Example2 = new EgWindow2(); //Create a window
		Example2.show(); // display a window
	}
}
class EgWindow2 extends JFrame{
	
	//constructor for EgWindow2
	public EgWindow2(){
		setTitle("Window with component added");
		setSize(600, 600);
		//
		//* Get a pointer to the content pane, creat a lable
		//* and add it to the content pane
		//* *********************************************
		Container MyContentFrame = getContentPane();
		JLabel Hello = new JLabel("Hello Hanbin!");
		JButton but = new JButton("Hey There!");
		MyContentFrame.add(Hello);

		
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
}
