package synSyncServer;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Server extends Thread {
	public static String SERVERNAME;
	public static final int PORT=55235;
	
	private TCPServer tcpServer;
	private UDPServer udpServer;
	
	
	private boolean running;
	
	public Server() {
		try {
			SERVERNAME=InetAddress.getLocalHost().getHostAddress();
			tcpServer=new TCPServer(this);
			udpServer=new UDPServer(this);
			tcpServer.start();
			udpServer.start();
			running=true;
		}
		catch (UnknownHostException uhe) {
			SERVERNAME="127.0.0.1";
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Removes the <code>Client</code> from the array of <code>Client</code> with the specified UID
	 * @param uID - the UID of the client to disconnect from the server
	 */
	public void removeClientFromServer(String uID) {
		tcpServer.removeClient(uID);
	}
	
	public void run() {
		while (running) {
			try {
				
			}
			catch (Exception e) {
				
			}
		}
	}
	
	
	
}