package space.ai;

import space.Entity;

public interface AI 
{
	public boolean isAbleTo(Entity e);
	public void update(Entity e);
}
