package space;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import pixgen.Animation;
import pixgen.PixGen;
import pixgen.Settings;
import pixgen.Vector;

public class Player extends PlayableEntity
{
	private ArrayList<Image> images = new ArrayList<Image>();
	private Animation animation;
	
	private final int acceleration = 1;
	private final int maxSpeed = acceleration * 100;
	private Vector velocity;
	
	private int chargePower = 0;
	
//	private NetFriend f = new NetFriend();
	
	public Player()
	{
		for(int i = 0;i < abilitys.length;i++)
			abilitys[i] = new Ability("res/abilities/bomb.png");
		
		velocity = new Vector(0, 0);
		
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
		
		PixGen.addUpdateableObject(this);
	}
	
	public void update() 
	{	
		if(PixGen.getInputManager().keyDown(Settings.KEY_UP))
			velocity.sub(new Vector(0, acceleration));
		if(PixGen.getInputManager().keyDown(Settings.KEY_DOWN))
			velocity.add(new Vector(0, acceleration));
		if(PixGen.getInputManager().keyDown(Settings.KEY_RIGHT))
			velocity.add(new Vector(acceleration, 0));
		if(PixGen.getInputManager().keyDown(Settings.KEY_LEFT))
			velocity.sub(new Vector(acceleration, 0));
		
		if(PixGen.getInputManager().keyDown(Settings.KEY_STOP))
		{
			Vector cancel = new Vector(
					velocity.getX() == 0
					? 0 :
					(
						(velocity.getX() > 0)
						? acceleration : -acceleration
					), 
					velocity.getY() == 0
					? 0 :
					(
						(velocity.getY() > 0)
						? acceleration : -acceleration
					)
			);
			velocity.sub(cancel);
			
			// Remove any left over values from Normalization
			if(velocity.getLength() < 1)
				velocity.mul(new Vector(0, 0));
		}
		
		if(velocity.getLength() > maxSpeed)
		{
			velocity.normalize();
			velocity.mul(new Vector(maxSpeed, maxSpeed));
		}
		
		getPosition().add(velocity);
		PixGen.setViewPoint(getPosition());
			
		super.update();
		
		chargePower++;
		if(chargePower == 60)
		{
			if(power < 100)
				power++;
			chargePower = 0;
		}
		
		if(PixGen.getInputManager().keyDown(Settings.KEY_SHIELD))
		{
			if(power > 0 && shield < 100)
			{
				power--;
				shield++;
			}
		}
		
		if(PixGen.getInputManager().keyDown(Settings.KEY_HEALTH))
		{
			if(power > 0 && health < 100)
			{
				power--;
				health++;
			}
		}
		
		animation.update();
		
		
//		if(Settings.NET_JOINING)
//		{
//			try 
//			{
//				f.direction = this.getDirection();
//				f.position = this.getPosition();
//				f.renderpos = this.getRenderpos();
//				PixEng.getClient().getConnection().oos.writeObject(f);
//			} 
//			catch (IOException e)
//			{
//				e.printStackTrace();
//			}
//		}
	}

	//TODO: move Hit method to PlayableEntity
	public void Hit()
	{
		shield--;
		if(shield < 0)
		{
			health--;
			shield = 0;
		}
	}
	
	public void render(Graphics2D g)
	{
		Image i = images.get(animation.getIndex());
		super.RenderImageCenter(g, i, 3);
		g.setColor(Color.GREEN);
		g.drawLine(200, 200, Math.round(200 + velocity.getX()), Math.round(200 + velocity.getY()));
		g.drawOval(100, 100, 200, 200);
	}
}
