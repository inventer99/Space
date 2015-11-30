package space.main;

import static pixgen.PixGen.getClient;
import static pixgen.PixGen.getServer;
import static pixgen.PixGen.startGame;

import java.awt.Graphics2D;

import pixgen.Game;
import pixgen.Settings;
import space.Player;
import space.World;
import space.body.StarBack;
import space.net.shared.TestConnectionHandler;

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
//				getServer().addListener(new NetPingHandler());
//				getServer().addListener(new NetFriendHandler());
				getServer().addListener(new TestConnectionHandler());
				getServer().start(9989);
//				PixEng.getServer().start(Settings.NET_PORT);
			}
			else
			{
//				getClient().addListener(new NetFriendHandler());
				getClient().addListener(new TestConnectionHandler());
				getClient().start("localhost", 9989);
//				getClient().start(Settings.NET_HOST, Settings.NET_PORT);
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
		
//		new Gui();
		
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
		
		startGame(new Main());
	}
}
