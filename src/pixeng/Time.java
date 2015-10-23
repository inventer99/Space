package pixeng;

public class Time 
{
	public static final long SECOND = 1000;
	public static final long FRAMERATE = Math.round(SECOND / 60);
	
	public static int frames = 0;
	public static long frameTime;
	
	public static long delta;
	
	public static long lastTime = Time.getTime();
	public static long nextTime = Time.getTime();
	public static long deltaTime = nextTime - lastTime;
	
	public static long getTime()
	{
		return System.currentTimeMillis();
	}
	
	public static long getDelta()
	{
		return delta;
	}
	
	public static void Start()
	{
		lastTime = Time.getTime();
	}
	
	public static void Stop()
	{
		nextTime = Time.getTime();
	}
	
	public static void update()
	{
		deltaTime = nextTime - lastTime;
		delta = deltaTime;
		frameTime += deltaTime;
		frames++;
		if(frameTime >= SECOND)
		{
//			System.out.println(frames);
			frameTime = 0;
			frames = 0;
		}
	}
}
