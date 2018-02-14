package synSyncServer;

import java.awt.GridBagLayout;
import javax.swing.JPanel;

public class base extends JPanel {
	
	Server server;
	
	public base() {
		server=new Server();
		server.start();
		setLayout(new GridBagLayout());
		MainPanel mainPanel=new MainPanel(server);
		SideBarPanel sidePanel=new SideBarPanel(server);
		
	}
	
	
	
}