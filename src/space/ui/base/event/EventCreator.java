package space.ui.base.event;

import java.util.ArrayList;

import pixgen.PixGen;

public class EventCreator 
{
	public static ArrayList<EventListener> listeners = new ArrayList<EventListener>();
	
//	private static boolean kStillDown = false;
	private static boolean mStillDown = false;
	
	public static void addEventListener(EventListener listener)
	{
		listeners.add(listener);
	}
	
//	public static void updateKey()
//	{
//		if(PixEng.getInputManager().keyDown(27) && lastkeypress == false)
//		{
//			Gui.drawOptionMenu = !Gui.drawOptionMenu;
//			lastkeypress = true;
//		}
//		if(!PixEng.getInputManager().keyDown(27))
//			lastkeypress = false;
//	}
	
	public static void updateMouse()
	{
		if(PixGen.getInputManager().mouseDown(1) && !mStillDown)
		{
			new MouseEvent(); // Pressed
			
			mStillDown = true;
		}
		if(!PixGen.getInputManager().mouseDown(1) && mStillDown)
		{
			new MouseEvent(); // Released
			
			mStillDown = false;
		}
		
		if(
				PixGen.getInputManager().mouseX() != PixGen.getInputManager().lastMouseX() &&
				PixGen.getInputManager().mouseY() != PixGen.getInputManager().lastMouseY()	
		)
		{
			if(mStillDown) 
			{
				new MouseEvent(); // Dragged
			}
			else
			{
				new MouseEvent(); // Moved
			}
			
			PixGen.getInputManager().equalizeMouse();
		}
	}
}
