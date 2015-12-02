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
	
	private final int acceleration = 1; // Acceleration of entity
	private final int maxSpeed = acceleration * 100; // Max Speed of entity
	private Vector velocity = new Vector(0, 0); // Entity velocity
	
	private int updatePP = 61; // How often to update Player Position
	private Vector playerPos; // Vector of Player Position
	
	private boolean goUp, goRight; // Direction of movement
	
	@Override
	public void update(Entity e) 
	{
		updatePP++; 
		if(updatePP > 60) // Check if playerPos should be updated
		{
			playerPos = ((Main) PixGen.getGame()).getPlayer().getPosition();
			updatePP = 0;
		}
	
		if(e.getPosition().getY() > playerPos.getY()) 
 		{
			goUp = true; // Move up
		} 
		else
 		{
			goUp = false; // Move down
		} 
		
		if(e.getPosition().getX() > playerPos.getX()) 
 		{
			goRight = false; // Move left
		} 
		else
 		{
			goRight = true; // Move right
		} 
		
		if(goUp)
			velocity.sub(new Vector(0, acceleration)); // Subtract accel from velocity Y
		if(!goUp)
			velocity.add(new Vector(0, acceleration)); // Add accel to velocity Y
		if(goRight)
			velocity.add(new Vector(acceleration, 0)); // Add accel to velocity X
		if(!goRight)
			velocity.sub(new Vector(acceleration, 0)); // Subtract accel from velocity X
		
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
		
		if(velocity.getLength() > maxSpeed) // Normalize Vector & Set max speed
		{
			velocity.normalize();
			velocity.mul(new Vector(maxSpeed, maxSpeed));
		}
		
		e.getPosition().add(velocity); // Change entity position by velocity
	}
}
