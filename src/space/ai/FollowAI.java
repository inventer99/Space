package space.ai;

import pixgen.PixGen;
import pixgen.Vector;
import space.Entity;
import space.main.Main;

public class FollowAI implements AI
{
	@Override
	public boolean isAbleTo(Entity e) 
	{
		return true;
	}
	
	private final int acceleration = 1;
	private final int maxSpeed = acceleration * 100;
	private Vector velocity = new Vector(0, 0);
	
	private int updatePP = 61;
	private Vector playerPos;
	
	private boolean goUp, goRight;
	
	@Override
	public void update(Entity e) 
	{
		updatePP++;
		if(updatePP > 60)
		{
			playerPos = ((Main) PixGen.getGame()).getPlayer().getPosition();
			updatePP = 0;
		}
	
		if(e.getPosition().getY() > playerPos.getY()) 
 		{
			goUp = true;
		} 
		else
 		{
			goUp = false;
		} 
		
		if(e.getPosition().getX() > playerPos.getX()) 
 		{
			goRight = false;
		} 
		else
 		{
			goRight = true;
		} 
		
		if(goUp)
			velocity.sub(new Vector(0, acceleration));
		if(!goUp)
			velocity.add(new Vector(0, acceleration));
		if(goRight)
			velocity.add(new Vector(acceleration, 0));
		if(!goRight)
			velocity.sub(new Vector(acceleration, 0));
		
//		if(PixGen.getInputManager().keyDown(Settings.KEY_STOP))
//		{
//			Vector cancel = new Vector(
//					velocity.getX() == 0
//					? 0 :
//					(
//						(velocity.getX() > 0)
//						? acceleration : -acceleration
//					), 
//					velocity.getY() == 0
//					? 0 :
//					(
//						(velocity.getY() > 0)
//						? acceleration : -acceleration
//					)
//			);
//			velocity.sub(cancel);
//			
//			// Remove any left over values from Normalization
//			if(velocity.getLength() < 1)
//				velocity.mul(new Vector(0, 0));
//		}
		
		if(velocity.getLength() > maxSpeed)
		{
			velocity.normalize();
			velocity.mul(new Vector(maxSpeed, maxSpeed));
		}
		
		e.getPosition().add(velocity);
	}
}
