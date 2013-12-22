package controllerApplication;

import java.awt.Dimension;

import javax.swing.JFrame;

public class ControllerApplication implements Runnable {

	public static void main(String[] args) {
		(new Thread(new ControllerApplication())).start();
	}
	
	public void run() {
		JFrame frame = new MainFrame("Arduino Motor Program");
		frame.setMinimumSize( new Dimension(400, 574));
		frame.setResizable(true);
		frame.setLocationRelativeTo(null); // Place Frame in Middle of Screen
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set Default Close
		frame.setVisible(true); // Set Visible
	}
}