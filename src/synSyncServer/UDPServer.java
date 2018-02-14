package synSyncServer;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import devices.*;

public class UDPServer extends Thread {
	
	public static final int CONNECT_REQUEST=14673;
	public static final int DISCONNECT_REQUEST=29627;

	protected DatagramSocket UDPSocket;

	protected boolean running;

	protected int port;
	protected String serverName;
	
	protected Server server;

	public UDPServer(Server s) {
		server=s;
		port=Server.PORT;
		serverName=Server.SERVERNAME;
		try {
			UDPSocket=new DatagramSocket(port);
			running=true;
		}
		catch (Exception e) {e.printStackTrace();}
	}

	public void run() {
		while (running) {
			try {
				byte[] buffer=new byte[256];
				DatagramPacket packet=new DatagramPacket(buffer, buffer.length);
				UDPSocket.receive(packet);
				String r=new String(packet.getData(), 0, packet.getLength());
				int received=Integer.parseInt(r.substring(0, r.indexOf(" ")));//gets request code
				if (received==CONNECT_REQUEST) {//if the device is connecting for the first time
					int packetPort=packet.getPort();
					InetAddress packetAddress=packet.getAddress();
					buffer=(serverName).getBytes();
					packet=new DatagramPacket(buffer, buffer.length, packetAddress, packetPort);
					UDPSocket.send(packet);//sends the server name and port back to the incoming client
				}
				else if (received==DISCONNECT_REQUEST) {
					String uID=r.substring(r.indexOf(" ")+1);
					server.removeClientFromServer(uID);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
				running=false;
			}
		}
	}
}