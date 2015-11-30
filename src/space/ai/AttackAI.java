package space.ai;

import pixgen.PixGen;
import pixgen.Vector;
import space.Entity;
import space.main.Main;

public class AttackAI implements AI
{
	@Override
	public boolean isAbleTo(Entity e) 
	{
		Vector dist = new Vector(
				((Main) PixGen.getGame()).getPlayer().getPosition().getX() - e.getPosition().getX(),
				((Main) PixGen.getGame()).getPlayer().getPosition().getY() - e.getPosition().getY());
		
		return dist.getLength() < 200;
	}
	
	@Override
	public void update(Entity e) 
	{
		((Main) PixGen.getGame()).getPlayer().Hit();
	}
}
