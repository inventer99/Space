package space.main;

import static pixgen.PixGen.getClient;
import static pixgen.PixGen.getServer;
import static pixgen.PixGen.startGame;

import java.awt.Graphics2D;

import pixgen.Game;
import pixgen.Settings;
import pixgen.Vector;
import space.Enemy;
import space.Player;
import space.World;
import space.body.StarBack;
import space.net.shared.TestConnectionHandler;
import space.ui.Gui;

public class Main extends Game
{
	private static Splash splash;
	
	private Player player;
	private World world;
	private Enemy enemy;
	
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
		
		enemy = new Enemy();
		enemy.setPosition(new Vector(300, 300));
		
		new Gui();
			
		splash.Delete();
	}
	
	@Override
	public void update() {}
	
	@Override
	public void render(Graphics2D g) {
//		g.setColor(Color.GREEN);
//		{
//			int x = 10;
//			int y = 10;
//			g.drawString("VeiwPoint:", x, y + 0);
//			g.drawString("X: " + PixGen.getViewPoint().getX(), x, y + 10);
//			g.drawString("Y: " + PixGen.getViewPoint().getY(), x, y + 20);
//		}
//		
//		{
//			int x = 10;
//			int y = 40;
//			g.drawString("Player:", x, y + 0);
//			g.drawString("X: " + player.getPosition().getX(), x, y + 10);
//			g.drawString("Y: " + player.getPosition().getY(), x, y + 20);
//		}
//		
//		{
//			int x = 10;
//			int y = 70;
//			g.drawString("Player_Renderpos:", x, y + 0);
//			g.drawString("X: " + player.getRenderpos().getX(), x, y + 10);
//			g.drawString("Y: " + player.getRenderpos().getY(), x, y + 20);
//		}
//		
//		{
//			int x = 150;
//			int y = 10;
//			g.drawString("Settings_ScreenSize:", x, y + 0);
//			g.drawString("Width: " + Settings.WIDTH, x, y + 10);
//			g.drawString("Height: " + Settings.HEIGHT, x, y + 20);
//		}
//		
//		{
//			int x = 150;
//			int y = 40;
//			g.drawString("Settings_(Half)ScreenSize:", x, y + 0);
//			g.drawString("Width: " + Settings.WIDTH / 2, x, y + 10);
//			g.drawString("Height: " + Settings.HEIGHT / 2, x, y + 20);
//		}
	}

	@Override
	public void destroy() {}
	
	public static void main(String[] args) 
	{
		splash = new Splash();
		
		startGame(new Main());
	}
}
