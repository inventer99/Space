package pixeng;

public class Transformation 
{
	public static Vector Translate(Vector v, Vector t)
	{
		v.add(t);
		return v;
	}
	
	public static Vector Rotate(Vector v, float i)
	{
		double d = Math.toRadians(i);
		
		v.setX((float) ((v.getX() * Math.cos(d)) - (v.getY() * Math.sin(d))));
		v.setY((float) ((v.getX() * Math.sin(d)) + (v.getY() * Math.cos(d))));
		
		return v;
	}
	
	public static Vector RotateAbout(Vector v, Vector p, float i)
	{
		double d = Math.toRadians(i);
		
		v.setX(v.getX() - p.getX());
		v.setY(v.getY() - p.getY());
		
		v.setX((float) ((v.getX() * Math.cos(d)) - (v.getY() * Math.sin(d))));
		v.setY((float) ((v.getX() * Math.sin(d)) + (v.getY() * Math.cos(d))));
		
		v.setX(v.getX() + p.getX());
		v.setY(v.getY() + p.getY());
		
		return v;
	}
	
	public static Vector Scale(Vector v, Vector t)
	{
		v.mul(t);
		
		return v;
	}
}
