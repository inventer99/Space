package space.ui.base.event;

import java.util.ArrayList;

import pixeng.PixEng;
import space.ui.base.event.types.MouseEvent;

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
		if(PixEng.getInputManager().mouseDown(1) && !mStillDown)
		{
			new MouseEvent(); // Pressed
			
			mStillDown = true;
		}
		if(!PixEng.getInputManager().mouseDown(1) && mStillDown)
		{
			new MouseEvent(); // Released
			
			mStillDown = false;
		}
		
		if(
				PixEng.getInputManager().mouseX() != PixEng.getInputManager().lastMouseX() &&
				PixEng.getInputManager().mouseY() != PixEng.getInputManager().lastMouseY()	
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
			
			PixEng.getInputManager().equalizeMouse();
		}
	}
}
