package space;

import java.io.IOException;

import pixeng.Connection;
import pixeng.NetListener;
import pixeng.PixEng;
import space.Friend;

public class NetFriendHandler implements NetListener
{
	Friend f;
	
	@Override
	public void onConnect(Connection connection) throws IOException 
	{
		f = new Friend();
		
		PixEng.addUpdateableObject(f);
	}

	@Override
	public void onReceive(Object object, Connection connection) throws IOException 
	{
		if(object instanceof NetFriend)
		{
			f.setDirection(((NetFriend) object).direction);
			f.setPosition(((NetFriend) object).position);
			f.setRenderpos(((NetFriend) object).renderpos);
		}
	}
}
