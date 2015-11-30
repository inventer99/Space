package space.net.shared;

import java.io.IOException;

import pixgen.Connection;
import pixgen.NetListener;

public class TestConnectionHandler implements NetListener
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
