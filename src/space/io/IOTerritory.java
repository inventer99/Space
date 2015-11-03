package space.io;

import java.io.Serializable;

@SuppressWarnings("serial")
public class IOTerritory extends IOEntity implements Serializable
{
	public IOTeam team;
	public int x;
	public int y;
}