package pixgen;

import java.util.ArrayList;
import java.util.HashMap;

public class StateManager 
{
	private HashMap<String, ArrayList<Updateable>> states = new HashMap<String, ArrayList<Updateable>>();
	private String currentState = "";
	
	public void addState(String name)
	{
		if(!states.containsKey(name))
		{
			states.put(name, new ArrayList<Updateable>());
		}
	}
	
	public void addStateListener(String state, Updateable listener)
	{
		states.get(state).add(listener);
	}
	
	public void setState(String state)
	{
		currentState = state;
		notifyStates();
	}
	
	public String getState()
	{
		return currentState;
	}
	
	private void notifyStates()
	{
		for(Updateable u : states.get(currentState))
		{
			u.update();
		}
	}
}
