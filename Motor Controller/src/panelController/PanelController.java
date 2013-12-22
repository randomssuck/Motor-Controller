package panelController;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

public class PanelController extends JPanel {
	private static final long serialVersionUID = 1L;
	
	LoginTCP vLogin;
	MotorControls controls;
	
	public PanelController() {
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		vLogin = new LoginTCP();
		gc.anchor = GridBagConstraints.NORTH;
		gc.gridy = 0;
		add(vLogin, gc);
		
		controls = new MotorControls();
		gc.anchor = GridBagConstraints.CENTER;
		gc.gridy = 1;
		add(controls, gc);
	}
}