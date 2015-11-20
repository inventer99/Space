package pixeng;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class Render extends JComponent
{
	public Render()
	{
		setBounds(0, 0, Settings.WIDTH, Settings.HEIGHT);
	}
	
	public void render()
	{		
		this.repaint();
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		super.paintComponent(g2d);
		
		g2d.clearRect(0, 0, Settings.WIDTH, Settings.HEIGHT);
		g.setColor(Color.BLACK);
		g2d.fillRect(0, 0, Settings.WIDTH, Settings.HEIGHT);
		
		for(int i = 0;i < PixEng.getObjects().size();i++)
		{
			Updateable o = PixEng.getObjects().get(i);
			o.render(g2d);
		}
	}
}
