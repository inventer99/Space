package pixgen;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketAddress;

public class Connection 
{
	public Socket s;
	
	public SocketAddress address;
	public int port;
	
	public OutputStream os;
	public ObjectOutputStream oos;
	public InputStream is;
	public ObjectInputStream ois;
	
	public Connection(Socket s, SocketAddress a, int p, OutputStream os, ObjectOutputStream oos, InputStream is, ObjectInputStream ois)
	{
		this.s = s;
		this.address = a;
		this.port = p;
		this.os = os;
		this.oos = oos;
		this.is = is;
		this.ois = ois;
	}
}
