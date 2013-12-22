package mainApplication;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class VehicalLogin extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JLabel hostIP;
	private JLabel port;
	private static JTextField hostField;
	private static JTextField portField;
	private static JToggleButton connectBtn;
	private JButton saveBtn;
	private JComboBox<String> loadComboBox;
	
	public VehicalLogin() {
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
		gc.weightx = 0.0;
		gc.ipadx = 150;
		gc.gridx = 1;
		gc.gridy = 0;
		add(hostField, gc);
		
		portField = new JTextField(15);
		gc.gridx = 1;
		gc.gridy = 1;
		add(portField, gc);
		
		connectBtn = new JToggleButton("Connect");
		connectBtn.setToolTipText("Connect/Disconnect to Device");
		connectBtn.setFocusable(false);
		connectBtn.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ev) {
				String ip = hostField.getText();
				String inPort = portField.getText();
				String address = ip + ":" + inPort;
				int port = 0;
				int intport;
				
				if(ev.getStateChange() == ItemEvent.SELECTED) {
					connectBtn.setText("Disconnect");
					if(!(ip.equals(""))) {
						try{
							if(!(inPort.equals(""))) {
								intport = Integer.parseInt(inPort);
								port = intport;
								(new Thread(new TCPconnection(ip, port))).start();
							}else{
								System.out.println("Port field can not be empty!");
								System.out.println("Entered address ( " + address + " )\n");
								connectBtn.setSelected(true);
								connectBtn.doClick();
							}
						}catch(NumberFormatException nFE){
							System.out.println("Port is not an Integer!");
							System.out.println("Entered address ( " + address + " )\n");
							connectBtn.setSelected(true);
							connectBtn.doClick();
						}
					}else{
						System.out.println("Host IP field can not be empty!");
						System.out.println("Entered address ( " + address + " )\n");
						connectBtn.setSelected(true);
						connectBtn.doClick();
					}
				}else{
					try {
						connectedGUIstate(false);
						TCPconnection.sendMessage("END");
					}catch(NullPointerException nullPointerException){
					}
				}
			}
		});
		gc.fill = GridBagConstraints.VERTICAL;
		gc.anchor = GridBagConstraints.NORTH;
		gc.gridheight = 2;
		gc.weightx = 1.0;
		gc.ipadx = 0;
		gc.gridx = 2;
		gc.gridy = 0;
		add(connectBtn, gc);
		
		saveBtn = new JButton("Save");
		saveBtn.setFocusable(false);
		saveBtn.setToolTipText("Save Current Host Address");
		saveBtn.setEnabled(true);
		saveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		gc.gridheight = 1;
		gc.gridx = 0;
		gc.gridy = 2;
		add(saveBtn, gc);
		
		String[] hostSaves = {"---------- Load Save ----------"};
		loadComboBox = new JComboBox<>(hostSaves);
		loadComboBox.setFocusable(false);
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.anchor = GridBagConstraints.WEST;
		gc.gridwidth = 3;
		gc.gridx = 1;
		gc.gridy = 2;
		add(loadComboBox, gc);
	}
	
	public static void connectedGUIstate(boolean s) {
		if(s == true) {
			hostField.setEditable(false);
			hostField.setFocusable(false);
			portField.setEditable(false);
			portField.setFocusable(false);
			connectBtn.setText("Disconnect");
		}else{
			hostField.setEditable(true);
			hostField.setFocusable(true);
			portField.setEditable(true);
			portField.setFocusable(true);
			connectBtn.setText("Connect");
		}
	}
}