package synSyncServer;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class DeviceComponent extends JPanel {
	private static final long serialVersionUID = 2L;
	
	public static final int EXPANDED_VIEW=1;
	public static final int CONDENSED_VIEW=2;
	
	private JTextField DeviceNameField=new JTextField();
	private JTextField DeviceIDField=new JTextField();
	private JTextField IPAddressField=new JTextField();
	private JTextField BatteryStatusField=new JTextField();
	private JTextField OSField=new JTextField();
	private JTextField CurrentStatusField=new JTextField();
	
	private JSlider VolumeSlider;
	private JSlider BluetoothSlider;
	private JSlider WifiSlider;
	
	private DeviceInfo device;
	
	private int currentView;
	
	//private int deviceID;
	
	public DeviceComponent(DeviceInfo d) {
		super(new GridBagLayout());
		device=d;
		DeviceNameField.setText(device.getDeviceName());
		DeviceIDField.setText(device.getDeviceID());
		IPAddressField.setText("IP Address: "+device.getIPAddress());
		BatteryStatusField.setText("Battery: "+device.getBatteryStatus()+"%");
		OSField.setText("Operating System: "+device.getOS());
		CurrentStatusField.setText("Current Status: "+device.getCurrentStatus());
		
		VolumeSlider=new JSlider(JSlider.HORIZONTAL, device.getMinVolume(), device.getMaxVolume(), device.getCurrentVolume());
		BluetoothSlider=new JSlider(JSlider.HORIZONTAL, 0, 1, device.getBluetooth()?1:0);
		WifiSlider=new JSlider(JSlider.HORIZONTAL, 0, 1, device.getWifi()?1:0);
		currentView=EXPANDED_VIEW;
		changeView(currentView);
	}
	
	public void changeView(int view) {
		switch (view) {
		case EXPANDED_VIEW:
			setExpandedView();
			break;
		case CONDENSED_VIEW:
			setCondensedView();
			break;
		}
	}
	
	public void setExpandedView() {
		this.removeAll();
		
		GridBagConstraints c=new GridBagConstraints();
		c.gridx=0;	c.gridy=0;
		c.gridwidth=2;
		this.add(DeviceNameField, c);
		
		c=new GridBagConstraints();
		c.gridx=0;	c.gridy=1;
		c.gridwidth=2;
		this.add(DeviceIDField, c);
		
		c=new GridBagConstraints();
		c.gridx=0;	c.gridy=2;
		c.gridwidth=2;
		this.add(IPAddressField, c);
		
		c=new GridBagConstraints();
		c.gridx=0;	c.gridy=3;
		c.gridwidth=1;	c.gridheight=3;
		this.add(new JLabel(new ImageIcon(device.getDeviceIcon())), c);
		
		c=new GridBagConstraints();
		c.gridx=1;	c.gridy=3;
		this.add(BluetoothSlider, c);
		
		c=new GridBagConstraints();
		c.gridx=1;	c.gridy=4;
		this.add(VolumeSlider, c);
		
		c=new GridBagConstraints();
		c.gridx=1;	c.gridy=5;
		this.add(WifiSlider, c);
		
		c=new GridBagConstraints();
		c.gridx=0;	c.gridy=6;
		c.gridwidth=2;
		this.add(BatteryStatusField, c);
		
		c=new GridBagConstraints();
		c.gridx=0;	c.gridy=7;
		c.gridwidth=2;
		this.add(OSField, c);
		
		c=new GridBagConstraints();
		c.gridx=0;	c.gridy=5;
		c.gridwidth=2;
		this.add(CurrentStatusField, c);
	}
	
	public void setCondensedView() {
		this.removeAll();
		
		GridBagConstraints c=new GridBagConstraints();
		c.gridx=0;	c.gridy=0;
		c.gridwidth=2;	c.gridheight=2;
		this.add(new JLabel(new ImageIcon(device.getDeviceIcon())), c);
		
		c=new GridBagConstraints();
		c.gridx=0;	c.gridy=2;
		c.gridwidth=2;
		this.add(DeviceNameField, c);
	}
	
	//public int getID() {return deviceID;}
	//public void setID(int id) {deviceID=id;}

}
