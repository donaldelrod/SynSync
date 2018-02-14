package synSyncServer;
import java.net.*;
import java.io.*;
public class TestClient {
	public static void main(String[] args) {
		int port=TestServer.SERVERPORT;
		String serverName=TestServer.SERVERIP;
		try {
			System.out.println("Connecting to "+serverName+" on port "+port+"...");
			Socket client=new Socket(serverName, port);
			System.out.println("Conntected to "+client.getRemoteSocketAddress());
			DataOutputStream out=new DataOutputStream(client.getOutputStream());
			out.writeUTF("Hello from "+client.getLocalSocketAddress());
			DataInputStream in=new DataInputStream(client.getInputStream());
			System.out.println(in.readUTF());
			client.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
