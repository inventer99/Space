package space.ai;

import pixeng.PixEng;
import pixeng.Vector;
import space.Entity;
import space.main.Main;

public class AttackAI implements AI
{
	@Override
	public boolean isAbleTo(Entity e) 
	{
		Vector dist = new Vector(
				((Main) PixEng.getGame()).getPlayer().getPosition().getX() - e.getPosition().getX(),
				((Main) PixEng.getGame()).getPlayer().getPosition().getY() - e.getPosition().getY());
		
		return dist.getLength() < 200;
	}
	
	@Override
	public void update(Entity e) 
	{
		((Main) PixEng.getGame()).getPlayer().Hit();
	}
}
