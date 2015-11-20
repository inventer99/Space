package space;

import java.awt.Graphics;
import java.awt.Graphics2D;

import pixeng.PixEng;

public class Friend extends Entity
{
	private String username = "";
	
	private int health = 100;
	private int shield = 100;
	private int power = 100;
	
	private Ability[] abilitys = new Ability[20];
	
	public Friend()
	{	
		PixEng.getImageManager().addImage("friend", "res/player/player_1.png");
		
		PixEng.addUpdateableObject(this);
	}
	
	public void update() 
	{	
		super.update();
	}
	
	public void render(Graphics2D g)
	{
		((Graphics) g).drawImage(PixEng.getImageManager().getImage("friend"), Math.round(getRenderpos().getX()), Math.round(getRenderpos().getY()), 90, 120, null);
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

	public String getUsername() 
	{
		return username;
	}

	public void setUsername(String username) 
	{
		this.username = username;
	}
}
