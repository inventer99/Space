package space;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import pixgen.Animation;
import pixgen.PixGen;
import space.ai.AI;
import space.ai.AttackAI;
import space.ai.FollowAI;

public class Enemy extends PlayableEntity
{
	private ArrayList<Image> images = new ArrayList<Image>();
	private Animation animation;
	
//	private boolean tmp = false;
	
	private ArrayList<AI> ais = new ArrayList<AI>();
	
	public Enemy()
	{
		abilitys[0] = new Ability("res/cursor.png");
		
		try 
		{
			images.add(ImageIO.read(new File("res/player/player_1.png")));
			images.add(ImageIO.read(new File("res/player/player_2.png")));
			images.add(ImageIO.read(new File("res/player/player_3.png")));
			images.add(ImageIO.read(new File("res/player/player_4.png")));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		animation = new Animation(1000/4, images.size());
		
		ais.add(new FollowAI());
		ais.add(new AttackAI());
		
		PixGen.addUpdateableObject(this);
	}
	
	public void update() 
	{		
		for(AI ai : ais)
		{
			if(ai.isAbleTo(this))
				ai.update(this);
		}
		
		super.update();
		
//		if(tmp)
//		{
//			if(health == 100)
//				tmp = false;
//			else
//			{
//				health++;
//				shield++;
//				power++;
//			}
//		}
//		else
//		{
//			if(health == 0)
//				tmp = true;
//			else
//			{
//				health--;
//				shield--;
//				power--;
//			}
//		}
		
		animation.update();
	}

	public void render(Graphics2D g)
	{
		((Graphics) g).drawImage(images.get(animation.getIndex()), Math.round(getRenderpos().getX()), Math.round(getRenderpos().getY()), 90, 120, null);
	}
}
