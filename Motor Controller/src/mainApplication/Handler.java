package mainApplication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class Handler implements ActionListener {

	public void actionPerformed(ActionEvent event) {
		
		String string = "";
		
		if(event.getActionCommand() == "About")
			string=String.format("Clicked: %s", event.getActionCommand());
		
		else if (event.getActionCommand() == "Prefereces")
			string=String.format("Clicked: %s", event.getActionCommand());
		
		else if (event.getActionCommand() == "Quit")
	        System.exit(0);
		
		else if (event.getActionCommand() == "SSH Configure")
			string=String.format("Clicked: %s", event.getActionCommand());
		
		else if (event.getActionCommand() == "SSH Connect")
			string=String.format("Clicked: %s", event.getActionCommand());
		
		else if (event.getActionCommand() == "SSH Disconnect")
			string=String.format("Clicked: %s", event.getActionCommand());
		
		else if (event.getActionCommand() == "How to Use Application")
			string=String.format("Clicked: %s", event.getActionCommand());
		
		else if (event.getActionCommand() == "Forward")
			string=String.format("Clicked: %s", event.getActionCommand());
		
		else if (event.getActionCommand() == "Reverse")
			string=String.format("Clicked: %s", event.getActionCommand());
		
		else if (event.getActionCommand() == "Curve Right")
			string=String.format("Clicked: %s", event.getActionCommand());	
		
		else if (event.getActionCommand() == "Curve Left")
			string=String.format("Clicked: %s", event.getActionCommand());
		
		else if (event.getActionCommand() == "Stop")
			string=String.format("Clicked: %s", event.getActionCommand());
		
		else if (event.getActionCommand() == "sendField")
			string=String.format("Clicked: %s", event.getActionCommand());
			
		else if (event.getActionCommand() == "Send")
			string=String.format("Clicked: %s", event.getActionCommand());
		
		JOptionPane.showMessageDialog(null, string);

	}
}