package space.ai;

import pixeng.PixEng;
import pixeng.Vector;
import space.Entity;
import space.main.Main;

public class FollowAI implements AI
{
	@Override
	public boolean isAbleTo(Entity e) 
	{
		return true;
	}
	
	private int holdTimeXp;
	private int holdTimeXm;
	private int holdTimeYp;
	private int holdTimeYm;
	
	private int updatePP = 61;
	private Vector playerPos;
	private Vector startPos = new Vector(0, 0);
	private Vector startDist;
	private Vector currentDist;
	private float hStartDistX, hStartDistY;
	
	private boolean goUp, goDown, goLeft, goRight;
	
	@Override
	public void update(Entity e) 
	{
		updatePP++;
		if(updatePP > 60)
		{
			playerPos = ((Main) PixEng.getGame()).getPlayer().getPosition();
			currentDist = new Vector(playerPos.getX() - e.getPosition().getX(), playerPos.getY() - e.getPosition().getY());
			startDist = new Vector(playerPos.getX() - startPos.getX(), playerPos.getY() - startPos.getY());
			hStartDistX = startDist.getX() / 2;
			hStartDistY = startDist.getY() / 2;
			updatePP = 0;
		}
	
		if(currentDist.getY() > hStartDistY) 
 		{
			goUp = true;
			goDown = false;
		} 
		else
 		{
			goUp = false;
			goDown = true;
		} 
		
		if(currentDist.getX() > hStartDistX) 
 		{
			goLeft = true;
			goRight = false;
		} 
		else
 		{
			goLeft = false;
			goRight = true;
		} 
		
		if(goUp) //UP
		{
			e.getPosition().add(new Vector(0, 5 + (float) (holdTimeYp * 0.1)));
			if(holdTimeYm > 0) holdTimeYm--;
			else holdTimeYp++;
		}
		if(goDown) //DOWN
		{
			e.getPosition().add(new Vector(0, -5 - (float) (holdTimeYm * 0.1)));
			if(holdTimeYp > 0) holdTimeYp--;
			else holdTimeYm++;
		}
		if(goLeft) //LEFT
		{
			e.getPosition().add(new Vector(5 + (float) (holdTimeXp * 0.1), 0));
			if(holdTimeXm > 0)holdTimeXm--;
			else holdTimeXp++;
		}
		if(goRight) //RIGHT
		{
			e.getPosition().add(new Vector(-5 - (float) (holdTimeXm * 0.1), 0));
			if(holdTimeXp > 0) holdTimeXp--;
			else holdTimeXm++;
		}
		
		if(holdTimeXm >= 0 && !goLeft)
		{
			e.getPosition().add(new Vector(-5 - (float) (holdTimeXm * 0.1), 0));
		}
		if(holdTimeXp >= 0 && !goRight)
		{
			e.getPosition().add(new Vector(5 + (float) (holdTimeXp * 0.1), 0));
		}
		if(holdTimeYp >= 0 && !goUp)
		{
			e.getPosition().add(new Vector(0, 5 + (float) (holdTimeYp * 0.1)));
		}
		if(holdTimeYm >= 0 && !goDown)
		{
			e.getPosition().add(new Vector(0, -5 - (float) (holdTimeYm * 0.1)));
		}
		
		if(holdTimeXp > 1000) holdTimeXp = 1000;
		if(holdTimeXm > 1000) holdTimeXm = 1000;
		if(holdTimeYp > 1000) holdTimeYp = 1000;
		if(holdTimeYm > 1000) holdTimeYm = 1000;
		
		if(holdTimeXp < 0) 
		{
			startPos = e.getPosition();
			holdTimeXp = 0;
		}
		if(holdTimeXm < 0) 
		{
			startPos = e.getPosition();
			holdTimeXm = 0;
		}
		if(holdTimeYp < 0) 
		{
			startPos = e.getPosition();
			holdTimeYp = 0;
		}
		if(holdTimeYm < 0) 
		{
			startPos = e.getPosition();
			holdTimeYm = 0;
		}
	}
}
