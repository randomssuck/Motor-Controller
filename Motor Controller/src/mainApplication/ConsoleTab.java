package mainApplication;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ConsoleTab extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JTextArea consoleArea;
	private JTextField userInput;
	
	public ConsoleTab() {
		setBorder(BorderFactory.createTitledBorder("Console"));
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		consoleArea = new JTextArea();
		//consoleArea.setLineWrap(false);
		consoleArea.setEditable(false);
	    gc.anchor = GridBagConstraints.CENTER;
	    gc.insets = new Insets(2,0,0,0);
	    gc.ipadx = 353;
	    gc.ipady = 380;
	    gc.gridx = 0;
	    gc.gridy = 0;
	    gc.weighty = 0.0;
	    add(new JScrollPane(consoleArea,
	       JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
	       JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), gc);
		
		// Send Field
		userInput = new JTextField();
		userInput.setEnabled(true);
		userInput.addActionListener(new EventHandler());
		
		gc.anchor = GridBagConstraints.SOUTH;
	    gc.ipady = 0;
	    gc.gridx = 0;
	    gc.gridy = 1;
	    gc.weighty = 1.0;
		add(userInput, gc);
	}
}