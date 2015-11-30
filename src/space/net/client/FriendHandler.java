package space.net.client;

import java.io.IOException;

import pixgen.Connection;
import pixgen.NetListener;
import pixgen.PixGen;
import space.Friend;
import space.serial.SerialCastor;
import space.serial.SerialFriend;

public class FriendHandler implements NetListener
{
	Friend f;
	
	@Override
	public void onConnect(Connection connection) throws IOException 
	{
		f = new Friend();
		
		PixGen.addUpdateableObject(f);
	}

	@Override
	public void onReceive(Object object, Connection connection) throws IOException 
	{
		if(object instanceof SerialFriend)
		{
			f = SerialCastor.cast((SerialFriend) object);
		}
	}
}
