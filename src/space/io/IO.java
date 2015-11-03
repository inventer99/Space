package space.io;

import java.util.HashSet;
import java.util.Set;

public class IO 
{
	private static Set<Object> saves = new HashSet<Object>();
	
	public static void addToSaves(Object o)
	{
		saves.add(o);
	}
	
	public static void removeFromSaves(Object o)
	{
		saves.remove(o);
	}
}
