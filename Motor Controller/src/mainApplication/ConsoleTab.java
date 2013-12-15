package mainApplication;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ConsoleTab extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public JTextArea consoleArea;
	public JTextField userInput;
	public JButton sendBtn;
	public String message = "";
	public String serverIP;
	public Socket connection;
	public ObjectOutputStream output;
	public ObjectInputStream input;
	
	public ConsoleTab() {
		setBorder(BorderFactory.createTitledBorder("Console"));
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		consoleArea = new JTextArea();
		consoleArea.setLineWrap(false);
		consoleArea.setEditable(false);
	    gc.anchor = GridBagConstraints.CENTER;
	    gc.ipadx = 352;
	    gc.ipady = 355;
	    gc.gridx = 0;
	    gc.gridy = 0;
	    add(new JScrollPane(consoleArea,
	       JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
	       JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), gc);
		
		// Send Field
		userInput = new JTextField();
		userInput.setEnabled(false);
		
		gc.anchor = GridBagConstraints.SOUTH;
	    gc.ipady = 0;
	    gc.gridx = 0;
	    gc.gridy = 1;
		add(userInput, gc);
		
		//startConsole();
	}
	
}