package mainApplication;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

public class MotorController extends JApplet {
	private static final long serialVersionUID = 1L;

	public void init() {
	
		// Initialize Panels
		JMenuBar mBar;
		ConnectPanel connectPanel;
		ControlPanel controlPanel;
		ConsolePanel consolePanel;
		
		// Set Frame Layout
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		// Create Menu Bar
		mBar = new JMenuBar();

		// Create "Controller" Menu
		JMenu controller = new JMenu("Controller");
		JMenuItem about; 
		about = new JMenuItem("About");
		JMenuItem preferences = new JMenuItem("Prefereces");
		JMenuItem quit = new JMenuItem("Quit");	
		controller.add(about);
		controller.add(preferences);
		controller.add(quit);
		mBar.add(controller);

		// Create "Connection" Menu
		JMenu sshConnection = new JMenu("SSH Connection");
		JMenuItem sshConfigure = new JMenuItem("SSH Configure");
		JMenuItem sshConnect = new JMenuItem("SSH Connect");
		JMenuItem sshDisconnect = new JMenuItem("SSH Disconnect");
		sshConnection.add(sshConfigure);
		sshConnection.add(sshConnect);
		sshConnection.add(sshDisconnect);
		mBar.add(sshConnection);
		
		// Create "Help" Menu
		JMenu help = new JMenu("Help");
		JMenuItem howtouse = new JMenuItem("How to Use Application");
		help.add(howtouse);
		mBar.add(help);
		
		Handler handler = new Handler();
		about.addActionListener(handler);
		preferences.addActionListener(handler);
		quit.addActionListener(handler);
		sshConfigure.addActionListener(handler);
		sshConnect.addActionListener(handler);
		sshDisconnect.addActionListener(handler);
		howtouse.addActionListener(handler);
		
		// Add Menu Bar
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.anchor = GridBagConstraints.NORTH;
		gc.ipadx = 135;
		gc.gridy = 0;
		add(mBar, gc);
		
		// Add Connection Panel
		connectPanel = new ConnectPanel();
		gc.ipady = 0;
		gc.gridy = 1;
		add(connectPanel, gc);
		
		// Add Control Panel
		controlPanel = new ControlPanel();
		gc.ipady = 106;
		gc.gridy = 2;
		add(controlPanel, gc);
		
		// Add Console Panel
		consolePanel = new ConsolePanel();
		gc.ipady = 0;
		gc.gridy = 3;
		add(consolePanel, gc);
	}
	//start
	public void start() {
	}
	//stop
	public void stop() {
	}
	//destroy
	public void destroy() {
	}
	//main
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
			JFrame frame = new MainFrame("Arduino Motor Program"); 
			frame.setMinimumSize(new Dimension(400, 600)); // Initialize Frameframe.setSize(400, 600); // Set Frame Size
			frame.setResizable(false);
			frame.setLocationRelativeTo(null); // Place Frame in Middle of Screen
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set Default Close
			frame.setVisible(true); // Set Visible
			}
		});
	}
}