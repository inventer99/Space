package space.serial;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SerialEntity implements Serializable
{
	public SerialVector position;
	public SerialVector direction;
}