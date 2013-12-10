package mainApplication;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class ControlPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public ControlPanel() {
		Dimension size = getPreferredSize();
		size.height = 200;
		setPreferredSize(size);
		setBorder(BorderFactory.createTitledBorder("Motor Controls"));
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		JToggleButton forwardBtn;
		JToggleButton reverseBtn;
		JToggleButton rightBtn;
		JToggleButton leftBtn;
		JToggleButton stopBtn;
		
		forwardBtn = new JToggleButton("Forward");
		forwardBtn.setEnabled(false);
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.anchor = GridBagConstraints.NORTH;
		gc.insets = new Insets(0,0,0,2);
		gc.ipadx = 28;
		gc.ipady = 65;
		gc.gridwidth = 3;
		gc.gridx = 0;
		gc.gridy = 0;
		add(forwardBtn, gc);
		
		reverseBtn = new JToggleButton("Reverse");
		reverseBtn.setEnabled(false);
		gc.gridx = 0;
		gc.gridy = 2;
		add(reverseBtn, gc);
		
		rightBtn = new JToggleButton("Curve Right");
		rightBtn.setEnabled(true);
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
		
		Handler handler = new Handler();
		forwardBtn.addActionListener(handler);
		reverseBtn.addActionListener(handler);
		rightBtn.addActionListener(handler);
		leftBtn.addActionListener(handler);
		stopBtn.addActionListener(handler);
		
		
	}
}