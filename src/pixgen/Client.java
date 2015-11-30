package pixgen;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Client implements Runnable
{
	private Thread t;
	
	private ArrayList<NetListener> listeners = new ArrayList<NetListener>();
	
	private Socket s;
	private boolean connected;
	
	private static String address;
	private static int port;
	
	private OutputStream os;
	private ObjectOutputStream oos;
	private InputStream is;
	private ObjectInputStream ois;
	
	private Connection connection;
	
	public void start(String a, int p)
	{
		address = a;
		port = p;
		
		t = new Thread(this, "Client");
		t.start();
	}
	
	@Override
	public void run()
	{
		connect();
		
		while(connected)
		{
			try
			{
				Object o = ois.readObject();
				
				for(NetListener listener : listeners)
				{
					if(o != null)
						listener.onReceive(
								o,
								this.getConnection()
						);
				}
			}
			catch(Exception e)
			{
				System.err.println("Connection Error in Update Loop!");
				e.printStackTrace();
				connected = false;
			}
			
			
			if(!s.isConnected())
			{
				disconnect();
				connected = false;
			}
		}
	}
	
	public void connect()
	{
		try
		{
			s = new Socket(address, port);
			
			os = s.getOutputStream();
			oos = new ObjectOutputStream(os);
			
			is = s.getInputStream();
			ois = new ObjectInputStream(is);
			
			for(NetListener listener : listeners)
			{
				listener.onConnect(
						this.getConnection()
				);
			}
			
			connected = true;
		}
		catch(Exception e)
		{
			System.err.println("Connection Error in Connect!");
			e.printStackTrace();
		}
	}
	
	public void disconnect()
	{
		try
		{
			oos.close();
			os.close();
			ois.close();
			is.close();
			s.close();
		}
		catch(Exception e)
		{
			System.err.println("Connection Error in Disconnect!");
			e.printStackTrace();
		}
	}
	
	public Connection getConnection()
	{
		if(connection == null)
			connection = new Connection(
					this.s,
					this.s.getRemoteSocketAddress(),
					this.s.getPort(),
					this.os,
					this.oos,
					this.is,
					this.ois
			);
		
		return connection;
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
}