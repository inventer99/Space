package space.io.types;

import java.io.Serializable;

@SuppressWarnings("serial")
public class IOEnemy extends IOEntity implements Serializable
{
	public IOTeam team;
	public IOAbility[] abilities;
	public int health;
	public int shield;
	public int power;
}