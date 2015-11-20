package space.serial;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SerialFriend extends SerialEntity implements Serializable
{
	public String username;
	public SerialTeam team;
	public SerialAbility[] abilities;
	public int health;
	public int shield;
	public int power;
}