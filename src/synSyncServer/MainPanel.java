package synSyncServer;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import synSyncServer.*;

public class MainPanel extends JPanel {
	
	public static final int EXPANDED_VIEW=1;
	public static final int CONDENSED_VIEW=2;
	
	private ArrayList<DeviceComponent> devices;
	
	private int currentView;
	
	private Server server;
	//private int numDevices;
	
	public MainPanel(Server s) {
		server=s;
		setLayout(new GridBagLayout());
		currentView=EXPANDED_VIEW;
		//i put something here to remind me of something but I can't remember cuz that was like 6 years ago
		//numDevices=0;
	}
	
	public void addDevice(DeviceInfo di) {
		devices.add(new DeviceComponent(di));
		//devices.get(devices.size()-1).setID(++numDevices);
		reorganizePanel(currentView);
	}
	
	public void reorganizePanel(int viewOption) {
		this.removeAll();
		if (viewOption==EXPANDED_VIEW) {
			for (int i=0; i<devices.size(); i++) {
				GridBagConstraints c=new GridBagConstraints();
				int gx=i+1;
				while(gx>5)
					gx-=5;
				c.gridx=gx;
				int cr=i, gy=0;
				while(cr>=5) {
					cr-=5;
					gy++;
				}
				c.gridy=gy;
				c.gridwidth=1;
				c.gridheight=1;
				c.ipadx=30;
				c.ipady=30;
				c.fill=GridBagConstraints.NONE;
				this.add(devices.get(i), c);
			}
			this.validate();
		}
		else if (viewOption==CONDENSED_VIEW) {
			//for ()
		}
	}
	
	
}