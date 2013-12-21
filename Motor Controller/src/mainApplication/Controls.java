package mainApplication;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class Controls extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public Controls() {
		setBorder(BorderFactory.createTitledBorder("Motor Controls"));
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		JToggleButton forwardBtn;
		JToggleButton reverseBtn;
		JToggleButton rightBtn;
		JToggleButton leftBtn;
		JToggleButton stopBtn;
		JTextField sBar;
		
		forwardBtn = new JToggleButton("Forward");
		forwardBtn.setEnabled(false);
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.anchor = GridBagConstraints.NORTH;
		gc.insets = new Insets(2,0,0,2);
		gc.ipadx = 16;
		gc.ipady = 65;
		gc.gridwidth = 3;
		gc.gridx = 0;
		gc.gridy = 0;
		add(forwardBtn, gc);
		
		reverseBtn = new JToggleButton("Reverse");
		reverseBtn.setEnabled(false);
		gc.insets = new Insets(2,0,6,2);
		gc.gridx = 0;
		gc.gridy = 2;
		add(reverseBtn, gc);
		
		rightBtn = new JToggleButton("Curve Right");
		rightBtn.setEnabled(false);
		gc.insets = new Insets(2,0,0,2);
		gc.gridwidth = 1;
		gc.gridx = 2;
		gc.gridy = 1;
		add(rightBtn, gc);
		
		leftBtn = new JToggleButton("Curve Left");
		leftBtn.setEnabled(false);
		gc.gridx = 0;
		gc.gridy = 1;
		add(leftBtn, gc);
		
		stopBtn = new JToggleButton("Stop");
		stopBtn.setEnabled(false);
		gc.gridx = 1;
		gc.gridy = 1;
		add(stopBtn, gc);
		
		sBar = new JTextField("Ready");
		sBar.setEditable(false);
		gc.gridx = 0;
		gc.gridy = 3;
		gc.gridwidth = 3;
		gc.ipady = 0;
		add(sBar, gc);
		
		// Event Handling
		EventHandler handler = new EventHandler();
		forwardBtn.addActionListener(handler);
		reverseBtn.addActionListener(handler);
		rightBtn.addActionListener(handler);
		leftBtn.addActionListener(handler);
		stopBtn.addActionListener(handler);
	}
}