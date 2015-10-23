package space;

import java.io.IOException;

import pixeng.Connection;
import pixeng.NetListener;

public class NetTestConnectionHandler  implements NetListener
{
	@Override
	public void onConnect(Connection connection) throws IOException 
	{
		System.out.println("Connection made to: " + connection.address.toString());
	}

	@Override
	public void onReceive(Object object, Connection connection) throws IOException 
	{
		
	}
}
