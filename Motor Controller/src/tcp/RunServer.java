package tcp;

import javax.swing.JFrame;

public class RunServer {
	public static void main(String[] args) {
		TCPserver server = new TCPserver();
		server.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		server.startRunning();
	}
}