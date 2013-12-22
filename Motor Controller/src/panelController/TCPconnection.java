package panelController;

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
			MotorControls.sBar.setText("");
			TCPmessage(" [~] Client ended connection", 4, true);
		}catch(IOException ioException){
		}catch(NullPointerException nullPointerException){
		}finally{
			cleanUp();
		}
	}
	
	private void connectToServer() {
		try {
			MotorControls.sBar.setText("");
			TCPmessage(" [~] Attempting to connect...", 4, true);
			connection = new Socket(InetAddress.getByName(serverIP), serverPort);
			TCPmessage("Connected to: " + connection.getInetAddress().getHostName(), 2, true);
			LoginTCP.connectedGUIstate(true);
			MotorControls.controlsEnabled(true);
		}catch(IOException ioException){
			TCPmessage("Server not found!", 0, true);
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
				TCPmessage(message, 2, true);
			}catch(ClassNotFoundException classNotFoundException){
				TCPmessage("Unable to read message", 3, false);
			}
		}while(!message.equals("SERVER: END"));
	}
	
	public final void cleanUp() {
		try {
			TCPmessage("Closing sockets...", 1, true);
			output.close();
			input.close();
			connection.close();
			MotorControls.controlsEnabled(false);
			TCPmessage("Successfully closed sockets.", 0, false);
			TCPmessage("Connection closed", 0, true);
		}catch(IOException ioException){
		}catch(NullPointerException nullPointerException){
			LoginTCP.connectBtn.setSelected(false);
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
				TCPmessage("CLIENT: " + message, 2, false);
			}
		}catch(IOException ioException){
		}
	}
	
	public static void TCPmessage(String message, int connectionState, boolean toStatusBar) {
		if(toStatusBar == true){
			MotorControls.statusBarUpdate(message, connectionState);
			System.out.println(" --StatusBAR-- (" + connectionState + ") " + message);
		}else{
			System.out.println(message);
		}
	}
}