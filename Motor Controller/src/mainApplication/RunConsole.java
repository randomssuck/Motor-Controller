package mainApplication;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class RunConsole extends ConsoleTab implements Runnable{
	
	
	private static final long serialVersionUID = 1L;

	public RunConsole(String host) {
		serverIP = host;
		
		
	/*	startConsole();	*/}

	public void run() {
		try {
			connectToServer();
			setupStreams();
			whileChatting();
		}catch(EOFException eofException){
		//	displayMessage("\nClient ended connection");
		}catch(IOException ioException){
			//ioException.printStackTrace();
		}finally{
			cleanUp();
		}
	}
	
	private void connectToServer() {
		try {
			//displayMessage("Attempting to connect...\n");
			connection = new Socket(InetAddress.getByName(serverIP), 6789);
			displayMessage("Connected to: " + connection.getInetAddress().getHostName());
		}catch(IOException ioException){
			//displayMessage("\nNo server found!");
		}
	}
	
	private void setupStreams() {
		try {
			output = new ObjectOutputStream(connection.getOutputStream());
			output.flush();
			input = new ObjectInputStream(connection.getInputStream());
			//displayMessage("\nStreams are created\n");
		}catch(IOException ioException){
		//displayMessage("\nNo server found!");
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
	
	private void cleanUp() {
		//displayMessage("\nClosing sockets...");
		try {
			output.close();
			input.close();
			connection.close();
		}catch(IOException ioException){
			//ioException.printStackTrace();
		}
	}
	
	public void sendMessage(String message) {
		try {
			output.writeObject("CLIENT: " + message);
			output.flush();
			displayMessage("\nCLIENT: " + message);
		}catch(IOException ioException){
			consoleArea.append("\nFailed to send!");
		}
	}
	
	private void displayMessage(final String message) {
		System.out.println(message);
	}

	
}