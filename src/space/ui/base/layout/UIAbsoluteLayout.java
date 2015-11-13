package space.ui.base.layout;

public class UIAbsoluteLayout extends UILayout
{
	public UIAbsoluteLayout(int x, int y, int width, int height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public UIAbsoluteLayout()
	{
		this(0, 0, 1, 1);
	}
}
