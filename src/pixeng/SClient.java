package pixeng;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SClient implements Runnable
{
	private Thread t;
	
	private Socket s;
	private boolean connected;
	
	private OutputStream os;
	private ObjectOutputStream oos;
	private InputStream is;
	private ObjectInputStream ois;
	
	private Connection connection;
	
	public SClient(Socket s)
	{
		this.s = s;
		
		t = new Thread(this, "SClient");
		t.start();
	}
	
	@Override
	public void run()
	{
		connect();
		
		try
		{
			while(connected)
			{
				Object o = ois.readObject();
				
				for(NetListener listener : PixEng.getServer().getListeners())
				{
					if(o != null)
						listener.onReceive(
								o,
								this.getConnection()
						);
				}
				
				if(s.isClosed())
				{
					disconnect();
					connected = false;
				}
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
			os = s.getOutputStream();
			oos = new ObjectOutputStream(os);
			
			is = s.getInputStream();
			ois = new ObjectInputStream(is);
			
			for(NetListener listener : PixEng.getServer().getListeners())
			{
				listener.onConnect(
						this.getConnection()
				);
			}
			
			connected = true;
		}
		catch(Exception e)
		{
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
}