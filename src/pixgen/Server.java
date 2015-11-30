package pixgen;

import java.net.ServerSocket;
import java.util.ArrayList;

public class Server implements Runnable
{
	private Thread t;
	
	private ArrayList<NetListener> listeners = new ArrayList<NetListener>();
	
	private ServerSocket ss;
	
	private int port;
	
	private ArrayList<SClient> sockets = new ArrayList<SClient>();
		
	public void start(int p)
	{
		port = p;
		
		t = new Thread(this, "Server");
		t.start();
	}
	
	@Override
	public void run()
	{
		connect();
		
		try
		{
			while(true)
			{
				sockets.add(new SClient(ss.accept()));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		disconnect();
	}
	
	public void connect()
	{
		try 
		{
			ss = new ServerSocket(port);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		System.out.println("Server started on port: " + port);
	}
	
	public void disconnect()
	{
		try
		{
			ss.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public ArrayList<NetListener> getListeners() 
	{
		return listeners;
	}
	
	public void addListener(NetListener listener) 
	{
		listeners.add(listener);
	}
	
	public void removeListener(NetListener listener) 
	{
		listeners.remove(listener);
	}
	
	public ArrayList<SClient> getSClient() 
	{
		return sockets;
	}
}