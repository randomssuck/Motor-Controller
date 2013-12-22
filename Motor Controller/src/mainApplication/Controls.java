package mainApplication;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.text.DefaultCaret;

public class Controls extends JPanel {
	private static final long serialVersionUID = 1L;

	private static JToggleButton forwardBtn;
	private static JToggleButton reverseBtn;
	private static JToggleButton rightBtn;
	private static JToggleButton leftBtn;
	private static JToggleButton stopBtn;
	public static JTextArea sBar;
	
	public Controls() {
		setBorder(BorderFactory.createTitledBorder("Motor Controls"));
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		forwardBtn = new JToggleButton("Forward");
		forwardBtn.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ev) {
				if(ev.getStateChange() == ItemEvent.SELECTED) {
					sendCommand("FORWARD");
				}else{
					sendCommand("STOP");
				}
			}
		});
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
		reverseBtn.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ev) {
				if(ev.getStateChange() == ItemEvent.SELECTED) {
					sendCommand("REVERSE");
				}else{
					sendCommand("STOP");
				}
			}
		});
		gc.insets = new Insets(2,0,6,2);
		gc.gridx = 0;
		gc.gridy = 2;
		add(reverseBtn, gc);
		
		rightBtn = new JToggleButton("Curve Right");
		rightBtn.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ev) {
				if(ev.getStateChange() == ItemEvent.SELECTED) {
					sendCommand("RIGHT");
				}else{
					sendCommand("STOP");
				}
			}
		});
		gc.insets = new Insets(2,0,0,2);
		gc.gridwidth = 1;
		gc.gridx = 2;
		gc.gridy = 1;
		add(rightBtn, gc);
		
		leftBtn = new JToggleButton("Curve Left");
		leftBtn.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ev) {
				if(ev.getStateChange() == ItemEvent.SELECTED) {
					sendCommand("LEFT");
				}else{
					sendCommand("STOP");
				}
			}
		});
		gc.gridx = 0;
		gc.gridy = 1;
		add(leftBtn, gc);
		
		stopBtn = new JToggleButton("Stop", true);
		stopBtn.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ev) {
				if(ev.getStateChange() == ItemEvent.SELECTED) {
					sendCommand("STOP");
				}else{
				}
			}
		});
		gc.gridx = 1;
		gc.gridy = 1;
		add(stopBtn, gc);
		
		sBar = new JTextArea();
		statusBarUpdate("Ready", 5);
		DefaultCaret caret = (DefaultCaret)sBar.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		sBar.setEditable(false);
		gc.gridx = 0;
		gc.gridy = 3;
		gc.gridwidth = 3;
		gc.ipady = 49;
		add(new JScrollPane(sBar), gc);
		
		controlsEnabled(false);
	}
	
	public static void controlsEnabled(boolean e) {
		if(e == true) {
			forwardBtn.setEnabled(true);
			reverseBtn.setEnabled(true);
			rightBtn.setEnabled(true);
			leftBtn.setEnabled(true);
			stopBtn.setEnabled(true);
		}else{
			forwardBtn.setEnabled(false);
			reverseBtn.setEnabled(false);
			rightBtn.setEnabled(false);
			leftBtn.setEnabled(false);
			stopBtn.setEnabled(false);
		}
	}
	
	private void sendCommand(String c) {
		TCPconnection.sendMessage(c);
	}
	
	public static void statusBarUpdate(String message, int connectionState) {
		if (connectionState == 0) {
			sBar.append("\n" + " [X] " + message);
		}else if (connectionState == 1) {
			sBar.append("\n" + " [~] " + message);	
		}else if (connectionState == 2) {
			sBar.append("\n" + " [O] " + message);
		}else if (connectionState == 4) {
			sBar.append("\n" + " [*] " + message);
		}else{
			sBar.append(message);
		}
	}
}