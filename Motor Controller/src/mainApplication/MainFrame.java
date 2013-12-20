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
	
}
