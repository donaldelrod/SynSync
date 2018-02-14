package synSyncServer;

import java.awt.Image;

public class DeviceInfo {
	private int maxVolume;
	private int minVolume;
	private int currentVolume;
	
	private boolean bluetooth;
	private boolean wifi;
	private boolean currentlyConnected;
	
	private String DeviceName;
	private String DeviceID;
	private String IPAddress;
	private String BatteryStatus;
	private String OS;
	private String CurrentStatus;
	
	private Image DeviceIcon;
	
	private StorageVolume storageVolumes;
	
	public DeviceInfo() {
		
	}

	
	public int getMaxVolume() {return maxVolume;}
	public int getMinVolume() {return minVolume;}
	public int getCurrentVolume() {return currentVolume;}
	public boolean getBluetooth() {return bluetooth;}
	public boolean getWifi() {return wifi;}
	public boolean isConnected() {return currentlyConnected;}
	public String getBatteryStatus() {return BatteryStatus;}
	public String getDeviceName() {return DeviceName;}
	public String getDeviceID() {return DeviceID;}
	public String getIPAddress() {return IPAddress;}
	public String getOS() {return OS;}
	public String getCurrentStatus() {return CurrentStatus;}
	public Image getDeviceIcon() {return DeviceIcon;}
	public StorageVolume getStorageVolumes() {return storageVolumes;}
	
	
	
}