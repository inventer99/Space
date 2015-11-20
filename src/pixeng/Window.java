package pixeng;

import java.awt.Dimension;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Window extends JFrame
{
	public Window()
	{
		getContentPane().setPreferredSize(new Dimension(Settings.WIDTH, Settings.HEIGHT));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		if(Settings.FULLSCREEN)
		{
			setUndecorated(true);
			getContentPane().setPreferredSize(new Dimension(Settings.WIDTH, Settings.HEIGHT));
		}
		
		add(PixEng.getRender());
		
		addMouseListener(PixEng.getInputManager());
		addMouseMotionListener(PixEng.getInputManager());
		addKeyListener(PixEng.getInputManager());
		
		pack();
		setVisible(true);
	}
}
