package space.net.server;

import java.io.IOException;

import pixgen.Connection;
import pixgen.NetListener;
import pixgen.PixGen;
import pixgen.SClient;
import space.serial.SerialFriend;

public class PingHandler implements NetListener
{
	@Override
	public void onConnect(Connection connection) throws IOException 
	{
		System.out.println("Client Connected");
	}

	@Override
	public void onReceive(Object object, Connection connection) throws IOException 
	{
		if(object instanceof SerialFriend)
		{	
			for(SClient c : PixGen.getServer().getSClient())
			{
				c.getConnection().oos.writeObject(object);
			}
		}
	}
}
