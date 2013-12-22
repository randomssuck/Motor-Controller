package mainApplication;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

public class ControllerTab extends JPanel {
	private static final long serialVersionUID = 1L;
	
	LoginConnection vLogin;
	Controls controls;
	
	public ControllerTab() {
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		vLogin = new LoginConnection();
		gc.anchor = GridBagConstraints.NORTH;
		gc.gridy = 0;
		add(vLogin, gc);
		
		controls = new Controls();
		gc.anchor = GridBagConstraints.CENTER;
		gc.gridy = 1;
		add(controls, gc);
	}
}