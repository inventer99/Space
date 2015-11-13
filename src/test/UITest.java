package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import space.ui.base.UIButton;
import space.ui.base.UILabel;
import space.ui.base.UIPanel;
import space.ui.base.UIRoot;
import space.ui.base.UITabbedPanel;
import space.ui.base.border.UIDuelBorder;
import space.ui.base.border.UISolidBorder;
import space.ui.base.layout.UIAbsoluteLayout;

public class UITest extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UITest frame = new UITest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public UITest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		add(this.new Render());
	}

	private class Render extends JComponent
	{
		public Render()
		{
			setBounds(0, 0, 450, 300);
		}
		
		public void paintComponent(Graphics g)
		{
			Graphics2D g2d = (Graphics2D) g;
			super.paintComponent(g2d);
			
			UIRoot r = new UIRoot();
			
			UITabbedPanel tp = new UITabbedPanel();
			tp.setBounds(new UIAbsoluteLayout(0, 0, 450, 300));
			
			UIPanel pb = new UIPanel();
			pb.setBounds(new UIAbsoluteLayout(10, 10, 450, 20));
			{
				UIButton b = new UIButton("Text cannot 英語");
				b.setBounds(new UIAbsoluteLayout(0, 0, 100, 20));
				b.setBorder(new UISolidBorder(1, Color.GREEN));
				b.setBackgroundColor(Color.YELLOW);
				b.setForegroundColor(Color.BLUE);
				pb.add(b);
			}
			tp.add(pb, "Button");
			
			UIPanel pl = new UIPanel();
			pl.setBounds(new UIAbsoluteLayout(10, 10, 450, 20));
			{
				UILabel l = new UILabel("Text cannot 英語");
				l.setBounds(new UIAbsoluteLayout(0, 0, 100, 20));
				l.setBorder(new UIDuelBorder(1, Color.CYAN, Color.RED));
				pl.add(l);
			}
			tp.add(pl, "Label");
			
			r.add(tp);
			
			r.renderComp(g2d);
		}
	}
}
