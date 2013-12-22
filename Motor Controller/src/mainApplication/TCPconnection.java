package mainApplication;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TCPconnection implements Runnable{

	private String message = "";
	private String serverIP;
	private int serverPort;
	private static Socket connection;
	private static ObjectOutputStream output;
	private static ObjectInputStream input;
	
	public TCPconnection(String ip, int port) {
		serverIP = ip;
		serverPort = port;
	}

	public void run() {
		try {
			connectToServer();
			setupStreams();
			whileChatting();
		}catch(EOFException eofException){
			Controls.sBar.setText("");
			displayMessage(" [~] Client ended connection", 5);
		}catch(IOException ioException){
		}catch(NullPointerException nullPointerException){
		}finally{
			cleanUp();
		}
	}
	
	private void connectToServer() {
		try {
			Controls.sBar.setText("");
			displayMessage(" [~] Attempting to connect...", 5);
			connection = new Socket(InetAddress.getByName(serverIP), serverPort);
			displayMessage("Connected to: " + connection.getInetAddress().getHostName(), 2);
			LoginConnection.connectedGUIstate(true);
			Controls.controlsEnabled(true);
		}catch(IOException ioException){
			displayMessage("Server not found!", 0);
		}
	}
	
	private void setupStreams() {
		try {
			output = new ObjectOutputStream(connection.getOutputStream());
			output.flush();
			input = new ObjectInputStream(connection.getInputStream());
		}catch(IOException ioException){
		}
	}
	
	private void whileChatting() throws IOException {
		do {
			try {
				message = (String) input.readObject();
				displayMessage(message, 2);
			}catch(ClassNotFoundException classNotFoundException){
				displayMessage("Unable to read message", 4);
			}
		}while(!message.equals("SERVER: END"));
	}
	
	public final void cleanUp() {
		try {
			displayMessage("Closing sockets...", 1);
			output.close();
			input.close();
			connection.close();
			Controls.controlsEnabled(false);
			displayMessage("Successfully closed sockets.", 0);
		}catch(IOException ioException){
		}catch(NullPointerException nullPointerException){
			LoginConnection.connectBtn.setSelected(false);
		}
	}
	
	public static void sendMessage(String message) {
		try {
			if((message.equals("END"))) {
				output.writeObject("CLIENT: " + "END");
				output.flush();
			}else{
				output.writeObject("CLIENT: " + message);
				output.flush();
				displayMessage("CLIENT: " + message, 2);
			}
		}catch(IOException ioException){
		}
	}
	
	public static void displayMessage(final String message, int connectionState) {
		Controls.statusBarUpdate(message, connectionState);
	}
}