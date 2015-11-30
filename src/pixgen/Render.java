package pixgen;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class Render extends JComponent
{
	private BufferedImage bufferA, bufferB;
	private boolean firstBuffer = true;
	
	private Graphics2D bufferGraphics;
	
	public Render()
	{
		setBounds(0, 0, Settings.WIDTH, Settings.HEIGHT);
		
		bufferA = new BufferedImage(Settings.WIDTH, Settings.HEIGHT, BufferedImage.TYPE_INT_ARGB);
		bufferB = new BufferedImage(Settings.WIDTH, Settings.HEIGHT, BufferedImage.TYPE_INT_ARGB);
	}
	
	public void render()
	{		
		this.repaint();
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		super.paintComponent(g2d);
		
		bufferGraphics = (Graphics2D) (firstBuffer == true ? bufferA : bufferB).getGraphics();
		
		bufferGraphics.clearRect(0, 0, Settings.WIDTH, Settings.HEIGHT);
		bufferGraphics.setColor(Color.BLACK);
		bufferGraphics.fillRect(0, 0, Settings.WIDTH, Settings.HEIGHT);
		
		for(int i = 0;i < PixGen.getObjects().size();i++)
		{
			Updateable o = PixGen.getObjects().get(i);
			o.render(bufferGraphics);
		}
		g2d.drawImage((firstBuffer == true ? bufferA : bufferB), 0, 0, Settings.WIDTH, Settings.HEIGHT, null);
		
		firstBuffer = !firstBuffer;
	}
}
