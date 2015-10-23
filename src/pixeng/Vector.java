package pixeng;

public class Vector 
{
	private float x;
	private float y;
	
	public Vector(float x, float y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void add(Vector a)
	{
		this.x += a.getX();
		this.y += a.getY();
	}
	
	public void sub(Vector a)
	{
		this.x -= a.getX();
		this.y -= a.getY();
	}
	
	public void mul(Vector a)
	{
		this.x *= a.getX();
		this.y *= a.getY();
	}
	
	public void div(Vector a)
	{
		this.x /= a.getX();
		this.y /= a.getY();
	}
	
	public void normalize()
	{
		float l = Math.abs(this.getLength());
		
		this.x = this.x / l;
		this.y = this.y / l;
	}

	public float getLength()
	{
		return (float) Math.sqrt(x * x + y * y);
	}
	
	public float getX() 
	{
		return x;
	}

	public void setX(float x) 
	{
		this.x = x;
	}

	public float getY() 
	{
		return y;
	}

	public void setY(float y) 
	{
		this.y = y;
	}
	
	public Vector getVector() 
	{
		return this;
	}
}
