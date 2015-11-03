package space.io;

import java.io.Serializable;

@SuppressWarnings("serial")
public class IOFriend extends IOEntity implements Serializable
{
	public String username;
	public IOTeam team;
	public IOAbility[] abilities;
	public int health;
	public int shield;
	public int power;
}