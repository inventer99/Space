package pixgen;

import java.util.ArrayList;

public class PixGen implements Runnable
{
	private static Thread t;
	private static boolean running = true;
	
	private static Game game;
	
	private static Render render;
	private static Window window;
	
	private static InputManager inputManager;
	private static ImageManager imageManager;
	private static AudioManager audioManager;
	private static StateManager stateManager;
	
	private static Server server;
	private static Client client;

	private static Vector position = new Vector(0, 0);
	
	private static ArrayList<Updateable> objects;

	public static void startGame(Game g)
	{
		t = new Thread(new PixGen(), "Engine");
		
		Settings.loadSettings();
		
		inputManager = new InputManager();
		imageManager = new ImageManager();
		audioManager = new AudioManager();
		stateManager = new StateManager();
		
		server = new Server();
		client = new Client();
		
		render = new Render();
		window = new Window();
		
		game = g;
		
		objects = new ArrayList<Updateable>();
		
		objects.add(game);
		
		t.start();
	}
	
	@SuppressWarnings("static-access")
	@Override
	public void run() 
	{
		game.init();
		
		while(running)
		{
			Time.Start();
			
			game.update();
			for(int i = 0;i < objects.size();i++)
			{
				Updateable o = objects.get(i);
				o.update();
			}
			
			render.render();
			
			Time.Stop();
			Time.update();
			
			if(Time.FRAMERATE - Time.getDelta() > 0 && Time.FRAMERATE - Time.getDelta() < Time.SECOND)
			{
				synchronized(t)
				{
					try 
					{
						// REMEMBER (Thread).sleep(int time); is in MILLISECONDS not NANOSECONDS
						t.sleep(Math.round((Time.FRAMERATE - Time.getDelta())));
					} 
					catch (InterruptedException e) 
					{
						e.printStackTrace();
					}
				}
			}
		}
		
		game.destroy();
		window.dispose();
	}

	public static void setRunning(boolean state) 
	{
		PixGen.running = state;
	}

	public static ArrayList<Updateable> getObjects() 
	{
		return objects;
	}

	public static void addUpdateableObject(Updateable object) 
	{
		objects.add(object);
	}

	public static Window getWindow() 
	{
		return window;
	}

	public static InputManager getInputManager() 
	{
		return inputManager;
	}
	
	public static ImageManager getImageManager() 
	{
		return imageManager;
	}
	
	public static AudioManager getAudioManager() 
	{
		return audioManager;
	}
	
	public static StateManager getStateManager() 
	{
		return stateManager;
	}
	
	public static Server getServer() 
	{
		return server;
	}
	
	public static Client getClient() 
	{
		return client;
	}

	public static Vector getViewPoint() 
	{
		return position;
	}
	
	public static void setViewPoint(Vector v) 
	{
		position.setX(-v.getX());
		position.setY(-v.getY());
	}
	
	public static Render getRender()
	{
		return render;
	}
	
	public static Game getGame()
	{
		return game;
	}
}
