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
		// Calculate distance to player
		Vector dist = new Vector( 
				((Main) PixGen.getGame()).getPlayer().getPosition().getX() - e.getPosition().getX(),
				((Main) PixGen.getGame()).getPlayer().getPosition().getY() - e.getPosition().getY());
		
		// Return true if the player is less than 200 units away
		return dist.getLength() < 200;
	}
	
	@Override
	public void update(Entity e) 
	{
		// Attack the player
		((Main) PixGen.getGame()).getPlayer().Hit();
	}
}
