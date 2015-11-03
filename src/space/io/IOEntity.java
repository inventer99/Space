package space.io;

import java.io.Serializable;

@SuppressWarnings("serial")
public class IOEntity implements Serializable
{
	public IOVector position;
	public IOVector renderpos;
	public IOVector direction;
}