package space.ai;

import space.Entity;

public interface AI 
{
	public boolean isAbleTo(Entity e); // Use to calculate if the AI routine can be used
	public void update(Entity e); // Update the Entity with the selected AI routine
}
