package guitutorial;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GraphicImageWindow {

	public static void main(String[] args){
		JFrame win = new EgWindow3();
		win.show();
	}
}

class EgWindow3 extends JFrame{

	// Constructor for EgWindow3
	public EgWindow3(){
		setTitle("Image window");
		setSize(150, 150);
		Container contents = getContentPane();
		JPanel Panel = new PicturePanel();
		contents.add(Panel);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
	
}

//This class extends JPanel and includes some drawing
class PicturePanel extends JPanel{
		
	public void paintComponent(Graphics Gr){
		super.paintComponent(Gr);
		Gr.setColor(Color.yellow);
		Gr.fillOval(75, 75, 50, 50);
		//Gr.setFont(new Font("Serif", Font.ITALIC, 20));
		//Gr.drawString("Sunshine", 30, 55);
	}
}