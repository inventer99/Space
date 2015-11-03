package space;

import java.util.ArrayList;

import pixeng.Vector;
import space.body.Planet;
import space.body.Star;
import space.io.ReadWrite;

public class World
{
	// Width: 1000000, from -500000 to 500000
	// Height: 1000000, from -500000 to 500000
	
	public ArrayList<Planet> planets = new ArrayList<Planet>();
	public ArrayList<Star> stars = new ArrayList<Star>();
	
	public ArrayList<Territory> territory = new ArrayList<Territory>();
	
	private Object[][] planetdata = {
			{"planet_life",   30000, 40000},
			{"planet_snow",   35000, 50000},
			{"planet_water",  30000, 40000},
			{"planet_rock",   20000, 65000},
			{"planet_desert", 20000, 65000}
	};
	
	public void gen()
	{
		for(int s = 0;s < 100; s++)
		{
			Star star = new Star("star_yellow");
			star.setPosition(new Vector(
					(float) Math.ceil(Math.random() * 1000000) - 500000,
					(float) Math.ceil(Math.random() * 1000000) - 500000));
			stars.add(star);
			
			for(int p = 0;p < Math.round(Math.ceil(Math.random() * 10)); p++)
			{
				int t = (int) Math.floor(Math.random() * 5);
				
				Planet planet = new Planet(
						(String) planetdata[t][0], 
						star, 
						(int) Math.ceil(Math.random() * ((int) planetdata[t][2] - (int) planetdata[t][1])) + ((int) planetdata[t][1]), 
						(int) Math.ceil(Math.random() * 360)
				);

				planets.add(planet);
			}
		}
	}
	
	/** BROKE!!! DO NOT USE!!! */
	public void save()
	{
		System.out.println("Unimplemented");
		
		ReadWrite io = new ReadWrite();
		
		io.write();
		
//		try
//		{
//			IOObject ioobj = new IOObject();
//			
//			ioobj.player = ((Main) PixEng.getGame()).getPlayer();
//			ioobj.stars = stars;
//			ioobj.planets = planets;
//			ioobj.territory = territory;
//			
//			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./worlds/tmp.world"));
//			
//			oos.writeObject(ioobj);
//			
//			oos.close();
//		}
//		catch(IOException e)
//		{
//			e.printStackTrace();
//		}
		
//		try
//		{
//			ArrayList<Byte> adata = new ArrayList<Byte>();
//			byte[] tmp;
//			
//			for(Star s : stars)
//			{
//				tmp = dataToBytes(0x1, 0x0, Math.round(s.getPosition().getX()), Math.round(s.getPosition().getY()), 0x0, 0x0);
//				for(int i = 0;i < tmp.length;i++)
//					adata.add(tmp[i]);
//				
//				for(Planet p : planets)
//				{
//					if(s.getPosition().getX() == p.getStarPos().getX() &&
//					   s.getPosition().getY() == p.getStarPos().getY())
//					{
//						tmp = dataToBytes(0x2, 0x1, Math.round(p.getStarPos().getX()), Math.round(p.getStarPos().getY()), 0x0, 0x0);
//						for(int i = 0;i < tmp.length;i++)
//							adata.add(tmp[i]);
//					}
//				}
//			}
//			
//			byte[] data = ArrayUtils.toPrimitive((adata.toArray(new Byte[adata.size()])));
//			FileOutputStream fos = new FileOutputStream("./worlds/tmp.world");
//			fos.write(data, 0, data.length);
//			fos.flush();
//			fos.close();
//		}
//		catch (IOException e)
//		{
//			e.printStackTrace();
//		}
	}
	
//	private static byte[] dataToBytes(int type, int img, int x, int y, int util, int world)
//	{
//		// File Format
//		// - 9 bytes
//		//
//		// [ 4 bit , 4 bit  , 3 byte , 3 byte , 4 bit , 12 bit ] Size
//		// [ type  , img id , obj x  , obj y  , util  , wrd id ] Name
//		// [ yes   , yes    , yes    , yes    , no    , no     ] Required
//		byte tmp1, tmp2;
//		byte id; 
//			tmp1 = (byte) ((type & 0x0000000F) << 4);
//			tmp2 = (byte) (img & 0x0000000F);
//			id = (byte) (tmp1 | tmp2);
//		byte x0, x1, x2;
//			x0 = (byte) ((x & 0x00FF0000) >> 16);
//			x1 = (byte) ((x & 0x0000FF00) >> 8);
//			x2 = (byte) (x & 0x000000FF);
//		byte y0, y1, y2;
//			y0 = (byte) ((y & 0x00FF0000) >> 16);
//			y1 = (byte) ((y & 0x0000FF00) >> 8);
//			y2 = (byte) (y & 0x000000FF);
//		byte uw, w1;
//			tmp1 = (byte) ((util & 0x0000000F) << 4);
//			tmp2 = (byte) ((world & 0x00000F00) >> 8);
//			uw = (byte) (tmp1 | tmp2);
//			w1 = (byte) (world & 0x000000FF);
//		byte[] re = {id, x0, x1, x2, y0, y1, y2, uw, w1};
//		return re;
//	}
	
//	private static int[] dataFromBytes(byte[] b)
//	{
//		int type, img, x, y, util, world;
//		int tmp1, tmp2, tmp3;
//		byte id = b[0]; 
//			type = (int) ((id & 0x000000F0) >> 4);
//			img = (int) (id & 0x0000000F);
//		byte x0 = b[1], x1 = b[2], x2 = b[3];
//			tmp1 = (int) (x0 << 16);
//			tmp2 = (int) (x1 << 8);
//			tmp3 = (int) (x2);
//			x = (int) (tmp1 | tmp2 | tmp3);
//		byte y0 = b[4], y1 = b[5], y2 = b[6];
//			tmp1 = (int) (y0 << 16);
//			tmp2 = (int) (y1 << 8);
//			tmp3 = (int) (y2);
//			y = (int) (tmp1 | tmp2 | tmp3);
//		byte uw = b[7], w1 = b[8];
//			util = (int) ((uw & 0x000000F0) >> 4);
//			tmp1 = (int) (uw & 0x00000F00);
//			tmp2 = (int) (w1 & 0x000000FF);
//			world = (int) (tmp1 | tmp2);
//		int[] re = {type, img, x, y, util, world};
//		return re;
//	}
	
	/** BROKE!!! DO NOT USE!!! */
	public void load()
	{		
		System.out.println("Unimplemented");
		
//		try
//		{
//			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./worlds/tmp.world"));
//			
//			IOObject ioobj = (IOObject) ois.readObject();
//			
//			((Main) PixEng.getGame()).setPlayer(ioobj.player);
//			stars = ioobj.stars;
//			planets = ioobj.planets;
//			territory = ioobj.territory;
//			
//			ois.close();
//		}
//		catch(IOException | ClassNotFoundException e)
//		{
//			e.printStackTrace();
//		}
//		
//		PixEng.getObjects().clear();
//		
//		{
//			for(Territory t : territory)
//				PixEng.addUpdateableObject(t);
//			for(Star s : stars)
//				PixEng.addUpdateableObject(s);
//			for(Planet p : planets)
//				PixEng.addUpdateableObject(p);
//			PixEng.addUpdateableObject(((Main) PixEng.getGame()).getPlayer());
//		}
		
//		try
//		{
//			planets = new ArrayList<Planet>();
//			stars = new ArrayList<Star>();
//			
//			FileInputStream fis = new FileInputStream("./worlds/tmp.world");
//			byte b;
//			ArrayList<Byte> d = new ArrayList<Byte>();
//			byte[] data;
//			
//			while((b = (byte)fis.read())!=-1)
//			{
//				d.add(b);
//			}
//			data = ArrayUtils.toPrimitive((d.toArray(new Byte[d.size()])));
//			
//			byte[] chunk = new byte[9];
//			int sx, sy;
//			for(int i = 0;i < data.length / 9;i++)
//			{
//				chunk[0] = data[(9 * i) + 0]; // Type , Img
//				chunk[1] = data[(9 * i) + 1]; // X0
//				chunk[2] = data[(9 * i) + 2]; // X1
//				chunk[3] = data[(9 * i) + 3]; // X2
//				chunk[4] = data[(9 * i) + 4]; // Y0
//				chunk[5] = data[(9 * i) + 5]; // Y1
//				chunk[6] = data[(9 * i) + 6]; // Y2
//				chunk[7] = data[(9 * i) + 7]; // Util , World
//				chunk[8] = data[(9 * i) + 8]; // W1
//				
//				if(((chunk[0] & 0xF0) >> 4) == (byte) 0x1);
//				{
//					Star star = new Star();
//					sx = ((chunk[3] << 16) | (chunk[2] << 8) | (chunk[1]));
//					sy = ((chunk[6] << 16) | (chunk[5] << 8) | (chunk[4]));
//					star.setPosition(new Vector(
//							sx,
//							sy));
//					stars.add(star);
//				}
//				
//				if(((chunk[0] & 0xF0) >> 4) == (byte) 0x2)
//				{
//					Vector s = new Vector(
//							sx,
//							sy);
//					
//					Planet planet = new Planet("planet_life", s);
//					int x = ((chunk[3] << 16) | (chunk[2] << 8) | (chunk[1]));
//					int y = ((chunk[6] << 16) | (chunk[5] << 8) | (chunk[4]));
//					planet.setPosition(new Vector(
//							x,
//							y));
//					planet.setPosition(Transformation.Translate(
//							planet.getPosition(),
//							s));
//					planets.add(planet);
//				}
//			}
//			
////			PixEng.resetPlayer();
//		}
//		catch (Exception e)
//		{
//			e.printStackTrace();
//		}
	}
}
