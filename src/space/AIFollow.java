package space;

import pixeng.PixEng;
import pixeng.Vector;
import space.main.Main;

public class AIFollow implements AI
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
	
	private Ability[] abilitys = new Ability[20];
	
	private int updatePP = 0;
	private Vector playerPos = ((Main) PixEng.getGame()).getPlayer().getPosition();
	
	@Override
	public void update(Entity e) 
	{
		updatePP++;
		if(updatePP > 60)
		{
			playerPos = ((Main) PixEng.getGame()).getPlayer().getPosition();
			updatePP = 0;
		}
	
		if(playerPos.getY() > e.getPosition().getY()) //UP
		{
			e.getPosition().add(new Vector(0, 5 + (float) (holdTimeYp * 0.1)));
			if(holdTimeYm > 0) holdTimeYm--;
			else holdTimeYp++;
		}
		if(playerPos.getY() < e.getPosition().getY()) //DOWN
		{
			e.getPosition().add(new Vector(0, -5 - (float) (holdTimeYm * 0.1)));
			if(holdTimeYp > 0) holdTimeYp--;
			else holdTimeYm++;
		}
		if(playerPos.getX() > e.getPosition().getX()) //LEFT
		{
			e.getPosition().add(new Vector(5 + (float) (holdTimeXp * 0.1), 0));
			if(holdTimeXm > 0)holdTimeXm--;
			else holdTimeXp++;
		}
		if(playerPos.getX() < e.getPosition().getX()) //RIGHT
		{
			e.getPosition().add(new Vector(-5 - (float) (holdTimeXm * 0.1), 0));
			if(holdTimeXp > 0) holdTimeXp--;
			else holdTimeXm++;
		}
		
		if(holdTimeXm >= 0 && !(playerPos.getX() < e.getPosition().getX()))
		{
			e.getPosition().add(new Vector(-5 - (float) (holdTimeXm * 0.1), 0));
		}
		if(holdTimeXp >= 0 && !(playerPos.getX() > e.getPosition().getX()))
		{
			e.getPosition().add(new Vector(5 + (float) (holdTimeXp * 0.1), 0));
		}
		if(holdTimeYp >= 0 && !(playerPos.getY() > e.getPosition().getY()))
		{
			e.getPosition().add(new Vector(0, 5 + (float) (holdTimeYp * 0.1)));
		}
		if(holdTimeYm >= 0 && !(playerPos.getY() < e.getPosition().getY()))
		{
			e.getPosition().add(new Vector(0, -5 - (float) (holdTimeYm * 0.1)));
		}
		
		if(holdTimeXp > 1000) holdTimeXp = 1000;
		if(holdTimeXm > 1000) holdTimeXm = 1000;
		if(holdTimeYp > 1000) holdTimeYp = 1000;
		if(holdTimeYm > 1000) holdTimeYm = 1000;
		
		if(holdTimeXp < 0) holdTimeXp = 0;
		if(holdTimeXm < 0) holdTimeXm = 0;
		if(holdTimeYp < 0) holdTimeYp = 0;
		if(holdTimeYm < 0) holdTimeYm = 0;
	}
}
