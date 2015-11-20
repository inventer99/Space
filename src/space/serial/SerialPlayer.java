package space.serial;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SerialPlayer extends SerialEntity implements Serializable
{
	public SerialTeam team;
	public SerialAbility[] abilities;
	public int health;
	public int shield;
	public int power;
}