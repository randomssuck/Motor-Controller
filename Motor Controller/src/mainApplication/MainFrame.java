package mainApplication;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class MainFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	public MainFrame(String title) {
		super(title);
		
		
	        JTabbedPane tabbedPane = new JTabbedPane();
	        
	         
	        //JComponent panel1 = makeTextPanel("Panel #1");
	        
	        ControllerTab controlTab = new ControllerTab();
	        
	        tabbedPane.addTab("Controller", controlTab);
	         
	        ConsoleTab consoleTab = new ConsoleTab();
	        tabbedPane.addTab("Console", consoleTab);
	        
	        ExtraTab extraTab = new ExtraTab();
	        tabbedPane.addTab("Extras", extraTab);
	         
	        //Add the tabbed pane to this panel.
	        add(tabbedPane);
	         
	        //The following line enables to use scrolling tabs.
	        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
	}
	     
	    
      /*  
		// Initialize Panels
		ControllerTab controlTab;
		Controls controlPanel;
		//ConsolePanel consolePanel;
		
		// Set Frame Layout
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		// Add Connection Panel
		connectP = new ControllerTab();
		gc.ipady = 0;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.NORTH;
		add(connectPanel, gc);
		
		// Add Control Panel
		controlPanel = new Controls();
		gc.ipadx = 10;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.SOUTH;
		add(controlPanel, gc);
		
		// Add Console Panel
		//consolePanel = new ConsolePanel();
		//gc.ipady = 0;
		//gc.gridy = 3;
		//add(consolePanel, gc);
}*/

}
