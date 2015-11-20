package space.serial;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SerialTerritory extends SerialEntity implements Serializable
{
	public SerialTeam team;
	public int x;
	public int y;
}