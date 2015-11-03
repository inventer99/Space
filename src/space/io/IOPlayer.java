package space.io;

import java.io.Serializable;

@SuppressWarnings("serial")
public class IOPlayer extends IOEntity implements Serializable
{
	public IOTeam team;
	public IOAbility[] abilities;
	public int health;
	public int shield;
	public int power;
}