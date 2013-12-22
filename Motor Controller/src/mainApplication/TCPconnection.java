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
	private static boolean connected;
	
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
			displayMessage("\nClient ended connection");
		}catch(IOException ioException){
		}catch(NullPointerException nullPointerException){
		}finally{
			cleanUp();
		}
	}
	
	private void connectToServer() {
		try {
			displayMessage("Attempting to connect...\n");
			connection = new Socket(InetAddress.getByName(serverIP), serverPort);
			displayMessage("Connected to: " + connection.getInetAddress().getHostName());
			VehicalLogin.connectedGUIstate(true);
		}catch(IOException ioException){
			setConnected(false);
			displayMessage("Server not found!");
		}
	}
	
	public static boolean isConnected() {
		return connected;
	}

	public static void setConnected(boolean connected) {
		TCPconnection.connected = connected;
	}

	private void setupStreams() {
		try {
			output = new ObjectOutputStream(connection.getOutputStream());
			output.flush();
			input = new ObjectInputStream(connection.getInputStream());
			setConnected(true);
			displayMessage("Streams are created\n");
		}catch(IOException ioException){
			displayMessage("Server not found!");
		}
	}
	
	private void whileChatting() throws IOException {
		do {
			try {
				message = (String) input.readObject();
				displayMessage("\n" + message);
			}catch(ClassNotFoundException classNotFoundException){
				
			}
		}while(!message.equals("SERVER: END"));
	}
	
	public final void cleanUp() {
		displayMessage("\nClosing sockets...");
		try {
			output.close();
			input.close();
			connection.close();
			displayMessage("Successfully closed sockets.");
		}catch(IOException ioException){
		}catch(NullPointerException nullPointerException){
			displayMessage("Closed sockets because client could not connect to server.\n");
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
				displayMessage("\nCLIENT: " + message);
			}
		}catch(IOException ioException){
			displayMessage("\nFailed to send!");
		}
	}
	
	public static void displayMessage(final String message) {
		System.out.println(message);
	}
}