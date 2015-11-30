package space;

public class PlayableEntity extends Entity
{
	protected int health = 100;
	protected int shield = 100;
	protected int power = 100;
	
	protected Ability[] abilitys = new Ability[20];
	
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
