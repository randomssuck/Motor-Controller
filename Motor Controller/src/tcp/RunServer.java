package tcp;

import javax.swing.JFrame;

public class RunServer {
	public static void main(String[] args) {
		TCPserver frame = new TCPserver();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.startRunning();
	}
}