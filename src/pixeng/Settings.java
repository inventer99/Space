package pixeng;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Settings 
{
	private static Properties prop;
	
	public static int WIDTH;
	public static int HEIGHT;
	
	public static boolean FULLSCREEN;
	
	public static boolean NET_HOSTING;
	public static boolean NET_JOINING;
	public static String NET_HOST;
	public static int NET_PORT;
	
	public static int SOUND_MASTER;
	public static int SOUND_SFX;
	public static int SOUND_MUSIC;
	
	public static int KEY_UP;
	public static int KEY_DOWN;
	public static int KEY_LEFT;
	public static int KEY_RIGHT;
	public static int KEY_STOP;
	
	public static int KEY_1;
	public static int KEY_2;
	public static int KEY_3;
	public static int KEY_4;
	public static int KEY_ABILITY;
	
	public static int KEY_SHIELD;
	public static int KEY_HEALTH;
	
	public static int KEY_EXPLORE;
	public static int KEY_WARP;
	
	public static int KEY_CHAT;
	
	public static void loadSettings()
	{
		prop = new Properties();
		
		try 
		{
			FileInputStream in = new FileInputStream("config.properties");
			prop.load(in);
			in.close();
		} 
		catch (IOException e) 
		{
			System.out.println("Could not load: \"config.properties\"!");
			e.printStackTrace();
		}
		
		WIDTH = Integer.parseInt(prop.getProperty("engine.width", "800"));
		HEIGHT = Integer.parseInt(prop.getProperty("engine.height", "500"));
		
		FULLSCREEN = Boolean.parseBoolean(prop.getProperty("engine.fullscreen", "true"));
		
		if(FULLSCREEN)
		{
			WIDTH = (int) java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth();
			HEIGHT = (int) java.awt.Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		}
		
		NET_HOSTING = Boolean.parseBoolean(prop.getProperty("net.hosting", "false"));
		NET_JOINING = Boolean.parseBoolean(prop.getProperty("net.joining", "false"));
		NET_HOST = prop.getProperty("net.host", "localhost");
		NET_PORT = Integer.parseInt(prop.getProperty("net.port", "9989"));
		
		SOUND_MASTER = Integer.parseInt(prop.getProperty("sound.master", "100"));
		SOUND_SFX = Integer.parseInt(prop.getProperty("sound.sfx", "100"));
		SOUND_MUSIC = Integer.parseInt(prop.getProperty("sound.music", "100"));
		
		KEY_UP = Integer.parseInt(prop.getProperty("control.up", "87"));
		KEY_DOWN = Integer.parseInt(prop.getProperty("control.down", "83"));
		KEY_LEFT = Integer.parseInt(prop.getProperty("control.left", "65"));
		KEY_RIGHT = Integer.parseInt(prop.getProperty("control.right", "68"));
		KEY_STOP = Integer.parseInt(prop.getProperty("control.stop", "32"));
		
		KEY_1 = Integer.parseInt(prop.getProperty("control.1", "49"));
		KEY_2 = Integer.parseInt(prop.getProperty("control.2", "50"));
		KEY_3 = Integer.parseInt(prop.getProperty("control.3", "51"));
		KEY_4 = Integer.parseInt(prop.getProperty("control.4", "52"));
		KEY_ABILITY = Integer.parseInt(prop.getProperty("control.ablity", "67"));
		
		KEY_SHIELD = Integer.parseInt(prop.getProperty("control.shield", "82"));
		KEY_HEALTH = Integer.parseInt(prop.getProperty("control.health", "70"));
		
		KEY_EXPLORE = Integer.parseInt(prop.getProperty("control.explore", "69"));
		KEY_WARP = Integer.parseInt(prop.getProperty("control.warp", "81"));
		
		KEY_CHAT = Integer.parseInt(prop.getProperty("control.chat", "84"));
	}
}
