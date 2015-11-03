package space.io;

import java.io.Serializable;

@SuppressWarnings("serial")
public class IOPlanet extends IOEntity implements Serializable
{
	public String renderkey;
	public int dist;
	public int arc;
}