package synSyncServer;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;

import devices.Client;

public class TCPServer extends Thread{
	
	private ServerSocket TCPServerSocket;
	
	private int port;
	private String serverName;
	
	private boolean running;
	
	private ArrayList<Client> clients;
	
	public TCPServer(Server s) {
		
		clients=new ArrayList<Client>();
		try {
			TCPServerSocket=new ServerSocket(port);
			TCPServerSocket.setSoTimeout(10000);
			running=true;
		}
		catch (IOException e) {e.printStackTrace();}
	}
	
	public void removeClient(String uID) {
		for (int i=0; i<clients.size(); i++) {
			if (clients.get(i).UNIQUE_ID.equals(uID)) {
				clients.get(i).disconnect();
				clients.remove(i);
				break;
			}
		}
	}
	
	public void run() {
		while (running) {
			try {
				Socket clientSocket=TCPServerSocket.accept();
				DataInputStream in=new DataInputStream(clientSocket.getInputStream());
				String info=in.readUTF();
				//check if the client is joining for the first time or reconnecting with a uniqueID
				String deviceType=in.readUTF();
				Client client=null;
				try {
					Class<?> c=Class.forName("devices."+deviceType+"Client");
					if (c.newInstance() instanceof Client)
						client=(Client)c.newInstance();
					else client=new Client();
				}
				catch (Exception e) {client=new Client();}
				client.bindSocket(clientSocket);
				String uID=generateUniqueID(client.getAddress());
				client.addUniqueID(uID);
				//by this point, the client has recieved it's unique id, and has stored it. This server should store it as well, along with the client's
				//ip. the client will now start listening for commands from the server, and the server will now start listening for requests from the
				//client
				client.start();
				clients.add(client);
			}
			catch (Exception e) {
				if (!(e instanceof SocketTimeoutException)) {
					e.printStackTrace();
					running=false;
				}
			}
		}
	}
	
	public String generateUniqueID(String address) {
		String uID="";
		long currentTime=System.currentTimeMillis();
		String[] p=address.split(".");
		for (String s:p) {
			long l=Integer.parseInt(s)*currentTime/(long)(Math.random()*19);
			String q=l+"";
			for (int i=0; i<q.length(); i++) {
				int val=Integer.parseInt(q.substring(i,i+1));
				if ((122-i-val>=97&&122-i-val<=122)||(90-i-val>=65&&122-i-val<=90)) {
					int[] t={90, 122};
					uID+=(char)(t[(int)((Math.random()*1.5)+.5)]-i-val);
				}
				else if ((97+i+val>=97&&97+i+val<=122)||(65+i+val>=60&&65+i+val<=90)) {
					int[] t={65, 97};
					uID+=(char)(t[(int)((Math.random()*1.5)+.5)]+i+val);
				}
				else
					uID+=(char)(val+(i%2==0?65:97));
			}
		}
		if (uID.length()>35)
			uID=uID.substring(0,5)+uID.substring(10, 15)+uID.substring(20, 25)+uID.substring(30, 35);
		else if (uID.length()>20)
			uID=uID.substring(0, 20);
		return uID;
	}
	
	
}