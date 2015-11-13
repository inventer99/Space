package space.main;

import java.awt.Graphics2D;

import pixeng.Game;
import pixeng.PixEng;
import pixeng.Settings;
import space.Player;
import space.World;
import space.body.StarBack;
import space.net.handler.TestConnectionHandler;
import space.ui.Gui;

public class Main extends Game
{
	private static Splash splash;
	
	private Player player;
	private World world;
	
	public Player getPlayer()
	{
		return player;
	}
	
	public void setPlayer(Player player)
	{
		this.player = player;
	}
	
	public World getWorld()
	{
		return world;
	}
	
	@Override
	public void init()
	{		
		if(Settings.NET_MULTI)
		{
			if(Settings.NET_HOSTING)
			{
//				PixEng.getServer().addListener(new NetPingHandler());
//				PixEng.getServer().addListener(new NetFriendHandler());
				PixEng.getServer().addListener(new TestConnectionHandler());
				PixEng.getServer().start(9989);
//				PixEng.getServer().start(Settings.NET_PORT);
			}
			else
			{
//				PixEng.getClient().addListener(new NetFriendHandler());
				PixEng.getClient().addListener(new TestConnectionHandler());
				PixEng.getClient().start("localhost", 9989);
//				PixEng.getClient().start(Settings.NET_HOST, Settings.NET_PORT);
			}
		}
		
		new StarBack();
		
		world = new World();
		world.gen();
		
//		new Territory(50, 50, Color.BLUE);
//		new Territory(49, 50, Color.GREEN);
//		new Territory(50, 49, Color.RED);
		
		player = new Player();
		
//		Enemy e1 = new Enemy();
//		e1.setPosition(new Vector(300, 300));
		
		new Gui();
		
		splash.Delete();
	}
	
	@Override
	public void update() {}
	
	@Override
	public void render(Graphics2D g) {}

	@Override
	public void destroy() {}
	
	public static void main(String[] args) 
	{
		splash = new Splash();
		
		PixEng.start(new Main());
	}
}
