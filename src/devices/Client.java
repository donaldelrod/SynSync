package devices;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import synSyncServer.*;

/**
 * Represents the connection between the Server and the Client
 * @author delrod15
 */
public class Client extends Thread {
	
	public static final int REQUEST_DEVICE_INFO=0;
	public static final int SEND_FILE_INFO=1;
	public static final int RECIEVE_FILE_INFO=2;
	
	public String UNIQUE_ID=null;
	
	protected DeviceInfo device;
	protected Socket clientSocket;
	private DataInputStream in;
	private DataOutputStream out;
	protected boolean connected;
	
	public Client () {}
	
	
	public void run() {
		while (connected) {
			
		}
	}
	
	public void disconnect() {
		try {
			in.close();
			out.close();
			clientSocket.close();
			connected=false;
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void requestDeviceInfo() {
		
	}
	
	public void doAction(int actionID) {
		if (actionID==REQUEST_DEVICE_INFO)
			requestDeviceInfo();
	}
	
	public void bindSocket(Socket s) {
		clientSocket=s;
		try {
			in=new DataInputStream(clientSocket.getInputStream());
			out=new DataOutputStream(clientSocket.getOutputStream());
			
			connected=true;
		}
		catch (Exception e) {e.printStackTrace();}
	}
	
	public String getAddress() {
		return clientSocket.getLocalSocketAddress().toString();
	}
	
	public void addUniqueID(String uID) {
		UNIQUE_ID=uID;
		try {
			out.writeUTF(UNIQUE_ID);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}