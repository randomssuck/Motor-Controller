package controllerApplication;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import panelConsole.PanelConsole;
import panelController.PanelController;
import panelExtras.PanelExtras;

public class MainFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	public MainFrame(String title) {
		super(title);
		
	        JTabbedPane tabbedPane = new JTabbedPane();
	        
	        PanelController controlTab = new PanelController();
	        tabbedPane.addTab("Controller", controlTab);
	         
	        PanelConsole consoleTab = new PanelConsole();
	        tabbedPane.addTab("Console", consoleTab);
	        
	        PanelExtras extraTab = new PanelExtras();
	        tabbedPane.addTab("Extras", extraTab);
	        
	        //Add the tab pane to this panel.
	        add(tabbedPane);
	        
	        //The following line enables to use scrolling tabs.
	        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
	}
}
