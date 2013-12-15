package mainApplication;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ConnectPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JLabel hostIP;
	private JLabel port;
	private JTextField hostField;
	private JTextField portField;
	private JButton connect;
	private JButton save;
	private JComboBox<String> load;
	
	public ConnectPanel() {
		Dimension size = getPreferredSize();
		size.height = 109;
		setPreferredSize(size);
		setBorder(BorderFactory.createTitledBorder("Vehicle"));
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		hostIP = new JLabel("Host IP: ");
		hostIP.setToolTipText("Enter Decive IP Address");
		gc.anchor = GridBagConstraints.EAST;
		gc.gridx = 0;
		gc.gridy = 0;
		add(hostIP, gc);
		
		port = new JLabel("Port: ");
		port.setToolTipText("Enter Device Port");
		gc.anchor = GridBagConstraints.EAST;
		gc.gridx = 0;
		gc.gridy = 1;
		add(port, gc);
		
		hostField = new JTextField(15);
		gc.gridx = 1;
		gc.gridy = 0;
		add(hostField, gc);
		
		portField = new JTextField(15);
		gc.gridx = 1;
		gc.gridy = 1;
		add(portField, gc);
		
		connect = new JButton("Connect");
		connect.setToolTipText("Connect/Disconnect to Device");
		connect.setEnabled(false);
		gc.fill = GridBagConstraints.VERTICAL;
		gc.anchor = GridBagConstraints.NORTH;
		gc.gridheight = 2;
		gc.gridx = 2;
		gc.gridy = 0;
		add(connect, gc);
		
		save = new JButton("Save");
		save.setToolTipText("Save Current Device");
		save.setEnabled(false);
		gc.gridheight = 1;
		gc.gridx = 0;
		gc.gridy = 2;
		add(save, gc);
		
		String[] hostSaves = {"---------- Load Save ----------"};
		load = new JComboBox<>(hostSaves);
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.anchor = GridBagConstraints.WEST;
		gc.gridwidth = 3;
		gc.gridx = 1;
		gc.gridy = 2;
		add(load, gc);
	}
}