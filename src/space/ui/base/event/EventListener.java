package space.ui.base.event;

public interface EventListener 
{
	public void KeyPressed(KeyEvent e);
	public void KeyReleased(KeyEvent e);
	public void MousePressed(MouseEvent e);
	public void MouseReleased(MouseEvent e);
	public void MouseDragged(MouseEvent e);
	public void MouseMoved(MouseEvent e);
}
