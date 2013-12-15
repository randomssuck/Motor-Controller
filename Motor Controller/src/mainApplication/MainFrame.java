package mainApplication;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class MainFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	public MainFrame(String title) {
		super(title);
		
		
	        JTabbedPane tabbedPane = new JTabbedPane();
	        
	         
	        JComponent panel1 = makeTextPanel("Panel #1");
	        tabbedPane.addTab("Tab 1", panel1);
	        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
	         
	        JComponent panel2 = makeTextPanel("Panel #2");
	        tabbedPane.addTab("Tab 2", panel2);
	        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
	         
	        JComponent panel3 = makeTextPanel("Panel #3");
	        tabbedPane.addTab("Tab 3", panel3);
	        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
	         
	        JComponent panel4 = makeTextPanel(
	                "Panel #4 (has a preferred size of 410 x 50).");
	        panel4.setPreferredSize(new Dimension(410, 50));
	        tabbedPane.addTab("Tab 4", panel4);
	        tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);
	         
	        //Add the tabbed pane to this panel.
	        add(tabbedPane);
	         
	        //The following line enables to use scrolling tabs.
	        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
	    
	     
	    
        
		// Initialize Panels
		ConnectPanel connectPanel;
		ControlPanel controlPanel;
		//ConsolePanel consolePanel;
		
		// Set Frame Layout
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		// Add Connection Panel
		connectPanel = new ConnectPanel();
		gc.ipady = 0;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.NORTH;
		add(connectPanel, gc);
		
		// Add Control Panel
		controlPanel = new ControlPanel();
		gc.ipadx = 10;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.SOUTH;
		add(controlPanel, gc);
		
		// Add Console Panel
		//consolePanel = new ConsolePanel();
		//gc.ipady = 0;
		//gc.gridy = 3;
		//add(consolePanel, gc);
}
	protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }
}
