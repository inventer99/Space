package space.main;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * @author inventer99
 *
 *	A simple JFrame to display a splash while the game loads
 *
 */

@SuppressWarnings("serial")
public class Splash extends JFrame
{
	public Splash()
	{
		setSize(200, 100);
		setUndecorated(true);
		setResizable(false);
		setLocationRelativeTo(null);
		
		add(this.new Img());
		
		setVisible(true);
		
		this.repaint();
	}
	
	public void Delete()
	{
		setVisible(false);
	}
	
	private class Img extends JPanel
	{
		public void paintComponent(Graphics g)
		{
        	super.paintComponent(g);

        	try 
    		{
    			Image img = ImageIO.read(new File("res/splash.png"));
        		g.drawImage(img, 0, 0, 200, 100, null);
    		} 
    		catch (IOException e) 
    		{
    			e.printStackTrace();
    		}
    	}
	}
}
