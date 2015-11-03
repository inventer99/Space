package space;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import pixeng.Animation;
import pixeng.PixEng;
import pixeng.Settings;
import pixeng.Vector;

public class Player extends Entity
{
	private ArrayList<Image> images = new ArrayList<Image>();
	private Animation animation;
	
	private int health = 100;
	private int shield = 100;
	private int power = 100;
	
	private int holdTimeXp;
	private int holdTimeXm;
	private int holdTimeYp;
	private int holdTimeYm;
	
	private Ability[] abilitys = new Ability[20];
	
	private int chargePower = 0;
	
//	private NetFriend f = new NetFriend();
	
	public Player()
	{
		for(int i = 0;i < abilitys.length;i++)
			abilitys[i] = new Ability("res/abilities/bomb.png");
		
		this.setPosition(new Vector((Settings.WIDTH / 2) - 45, (Settings.HEIGHT / 2) - 60));
		
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
		
		PixEng.addUpdateableObject(this);
	}
	
	public void update() 
	{	
		if(PixEng.getInputManager().keyDown(Settings.KEY_UP))
		{
			PixEng.getPosition().add(new Vector(0, 5 + (float) (holdTimeYp * 0.1)));
			getPosition().add(new Vector(0, 5 - (float) (holdTimeYp * 0.1)));
			if(holdTimeYm > 0) holdTimeYm--;
			else holdTimeYp++;
		}
		if(PixEng.getInputManager().keyDown(Settings.KEY_DOWN))
		{
			PixEng.getPosition().add(new Vector(0, -5 - (float) (holdTimeYm * 0.1)));
			getPosition().add(new Vector(0, -5 + (float) (holdTimeYm * 0.1)));
			if(holdTimeYp > 0) holdTimeYp--;
			else holdTimeYm++;
		}
		if(PixEng.getInputManager().keyDown(Settings.KEY_LEFT))
		{
			PixEng.getPosition().add(new Vector(5 + (float) (holdTimeXp * 0.1), 0));
			getPosition().add(new Vector(5 - (float) (holdTimeXp * 0.1), 0));
			if(holdTimeXm > 0)holdTimeXm--;
			else holdTimeXp++;
		}
		if(PixEng.getInputManager().keyDown(Settings.KEY_RIGHT))
		{
			PixEng.getPosition().add(new Vector(-5 - (float) (holdTimeXm * 0.1), 0));
			getPosition().add(new Vector(-5 + (float) (holdTimeXm * 0.1), 0));
			if(holdTimeXp > 0) holdTimeXp--;
			else holdTimeXm++;
		}
		
		if(holdTimeXm >= 0 && !PixEng.getInputManager().keyDown(Settings.KEY_RIGHT))
		{
			PixEng.getPosition().add(new Vector(-5 - (float) (holdTimeXm * 0.1), 0));
			getPosition().add(new Vector(-5 + (float) (holdTimeXm * 0.1), 0));
		}
		if(holdTimeXp >= 0 && !PixEng.getInputManager().keyDown(Settings.KEY_LEFT))
		{
			PixEng.getPosition().add(new Vector(5 + (float) (holdTimeXp * 0.1), 0));
			getPosition().add(new Vector(5 - (float) (holdTimeXp * 0.1), 0));
		}
		if(holdTimeYp >= 0 && !PixEng.getInputManager().keyDown(Settings.KEY_UP))
		{
			PixEng.getPosition().add(new Vector(0, 5 + (float) (holdTimeYp * 0.1)));
			getPosition().add(new Vector(0, 5 - (float) (holdTimeYp * 0.1)));
		}
		if(holdTimeYm >= 0 && !PixEng.getInputManager().keyDown(Settings.KEY_DOWN))
		{
			PixEng.getPosition().add(new Vector(0, -5 - (float) (holdTimeYm * 0.1)));
			getPosition().add(new Vector(0, -5 + (float) (holdTimeYm * 0.1)));
		}
		
		if(PixEng.getInputManager().keyDown(Settings.KEY_STOP))
		{
			holdTimeXp--;
			holdTimeXm--;
			holdTimeYp--;
			holdTimeYm--;
		}
		
		if(holdTimeXp > 1000) holdTimeXp = 1000;
		if(holdTimeXm > 1000) holdTimeXm = 1000;
		if(holdTimeYp > 1000) holdTimeYp = 1000;
		if(holdTimeYm > 1000) holdTimeYm = 1000;
		
		if(holdTimeXp < 0) holdTimeXp = 0;
		if(holdTimeXm < 0) holdTimeXm = 0;
		if(holdTimeYp < 0) holdTimeYp = 0;
		if(holdTimeYm < 0) holdTimeYm = 0;
			
		super.update();
		
		chargePower++;
		if(chargePower == 60)
		{
			if(power < 100)
				power++;
			chargePower = 0;
		}
		
		if(PixEng.getInputManager().keyDown(Settings.KEY_SHIELD))
		{
			if(power > 0 && shield < 100)
			{
				power--;
				shield++;
			}
		}
		
		if(PixEng.getInputManager().keyDown(Settings.KEY_HEALTH))
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
		((Graphics) g).drawImage(images.get(animation.getIndex()), Math.round(getRenderpos().getX()), Math.round(getRenderpos().getY()), 90, 120, null);
	}
	
	public int getHealth() 
	{
		return health;
	}

	public void setHealth(int health) 
	{
		this.health = health;
	}

	public int getShield() 
	{
		return shield;
	}

	public void setShield(int shield) 
	{
		this.shield = shield;
	}

	public int getPower() 
	{
		return power;
	}

	public void setPower(int power) 
	{
		this.power = power;
	}

	public Ability[] getAbilitys() 
	{
		return abilitys;
	}

	public void setAbilitys(Ability[] abilitys) 
	{
		this.abilitys = abilitys;
	}
}
