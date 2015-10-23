package pixeng;

import java.awt.Graphics2D;

public class Animation implements Updateable
{
	private int texCount;
	private int index;
	
	private float frameRate;
	private float frameTime;
	
	private boolean animating;
	
	public Animation(float frameRate, int texCount)
	{
		this.frameRate = frameRate;
		this.texCount = texCount;
		
		animating = true;
	}
	
	@Override
	public void update() 
	{
		if(animating)
		{
			frameTime += 1000 / 60;
			
			if(frameTime >= frameRate)
			{
				frameTime = 0;
				
				index++;
			}
			
			if(index > texCount - 1)
				index = 0;
		}
	}

	public void pause()
	{
		animating = false;
	}
	
	public void play()
	{
		animating = true;
	}
	
	public void stop()
	{
		animating = false;
		
		index = 0;
	}
	
	public int getIndex() 
	{
		return index;
	}

	@Override
	public void render(Graphics2D g) {}
}
