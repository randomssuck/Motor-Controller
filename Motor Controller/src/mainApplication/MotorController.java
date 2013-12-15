package mainApplication;

import java.awt.Dimension;

import javax.swing.JFrame;

public class MotorController implements Runnable {

	public static void main(String[] args) {
		(new Thread(new MotorController())).start();
		(new Thread(new RunConsole("127.0.0.1"))).start();
		}
	
	public void run() {
		JFrame frame = new MainFrame("Arduino Motor Program");
		frame.setMinimumSize(new Dimension(400, 600)); // Initialize Frameframe.setSize(400, 600); // Set Frame Size
		frame.setResizable(true);
		frame.setLocationRelativeTo(null); // Place Frame in Middle of Screen
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set Default Close
		frame.setVisible(true); // Set Visible
	}
}
