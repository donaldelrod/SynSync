package synSyncServer;
import java.net.*;
import java.io.*;
public class TestServer extends Thread{
	public static final int SERVERPORT=5001;
	public static final String SERVERIP="127.0.0.1";
	
	private ServerSocket serverSocket;
	
	public TestServer () {
		try {
			serverSocket=new ServerSocket(SERVERPORT);
			serverSocket.setSoTimeout(10000);
		}
		catch (Exception e) {System.out.println(e);}
	}
	
	public void run() {
		while (true) {
			try {
				System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
				Socket client=serverSocket.accept();
				System.out.println("Connected to client " + client.getRemoteSocketAddress());
				DataInputStream in=new DataInputStream(client.getInputStream());
				System.out.println(in.readUTF());
				DataOutputStream out=new DataOutputStream(client.getOutputStream());
				out.writeUTF("Thank you for connecting to " + client.getLocalSocketAddress()+"\nGoodbye!");
				client.close();
			}
			catch (SocketTimeoutException ste) {
				System.out.println("Socket timed out");
				break;
			}
			catch (Exception e) {
				e.printStackTrace();
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		try {
			Thread t=new TestServer();
			t.start();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
}