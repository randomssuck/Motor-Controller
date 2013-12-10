package mainApplication;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ConsolePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public ConsolePanel() {
		Dimension size = getPreferredSize();
		size.height = 140;
		setPreferredSize(size);
		setBorder(BorderFactory.createTitledBorder("Console"));
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		JTextArea consoleArea;
		JTextField sendField;
		JButton sendBtn;
		
		consoleArea = new JTextArea(5, 20);
		consoleArea.setLineWrap(true);
		consoleArea.setEditable(false);
	    gc.fill = GridBagConstraints.HORIZONTAL;
	    gc.anchor = GridBagConstraints.NORTH;
	    gc.ipady = 65;
	    gc.gridwidth = 2;
	    gc.gridx = 0;
	    gc.gridy = 0;
	    add(new JScrollPane(consoleArea,
	       JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
	       JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), gc);
		
		// Send Field
		sendField = new JTextField(10);
		sendField.setEnabled(false);
		gc.anchor = GridBagConstraints.WEST;
		gc.ipadx = 295;
	    gc.ipady = 0;
	    gc.gridwidth = 1;
	    gc.gridx = 0;
	    gc.gridy = 1;
		add(sendField, gc);
		
		// Send Button
		sendBtn = new JButton("Send");
		sendBtn.setEnabled(false);
		gc.ipadx = 0;
	    gc.gridx = 1;
	    gc.gridy = 1;
		add(sendBtn, gc);
		

		Handler handler = new Handler();
		sendField.addActionListener(handler);
		sendBtn.addActionListener(handler);
	}
}