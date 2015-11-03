package space.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ReadWrite 
{
	private File root, sdata, tdata, adata, edata, fdata;
	private File tmp;
	private int SHexID = 0x0000;
	private int _PHexID = 0x00, _SHexID = 0x00;
	
	public void write()
	{
		//for() Stars
		{
			tmp = new File(sdata.getPath() + "/S" + toHexString(_SHexID, 2) + ".bin");
			_SHexID++;
			
			writeObject(null, tmp);
		}
		
		//for() Planets
		{
			tmp = new File(sdata.getPath() + "/P" + toHexString(_PHexID, 2) + ".bin");
			_PHexID++;
			
			writeObject(null, tmp);
		}
	}
	
	public boolean genSystem()
	{
		tmp = new File(sdata.getPath() + "/" + toHexString(SHexID, 4));
		SHexID++;
		
		if(tmp.exists())
		{
			System.out.println("System already exists! Loss of data is present!");
			return false;
		}
		
		tmp.mkdir();
		
		return true;
	}
	
	public boolean genFileTree(String name)
	{
		root = new File("worlds/" + name);
		
		if(root.exists())
		{
			System.out.println("World already exists! Please remove it or choose a different name.");
			return false;
		}
		
		root.mkdir();
		
		sdata = new File(root.getPath() + "/sdata");
		sdata.mkdir();
		
		tdata = new File(root.getPath() + "/tdata");
		tdata.mkdir();
		
		adata = new File(root.getPath() + "/adata");
		adata.mkdir();
		
		edata = new File(root.getPath() + "/edata");
		edata.mkdir();
		
		fdata = new File(root.getPath() + "/fdata");
		fdata.mkdir();
		
		return true;
	}
	
	public void writeObject(Serializable obj, File path)
	{
		try
		{	
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
			
			oos.writeObject(obj);
			
			oos.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public Object readObject(File path)
	{
		Object obj = null;
		
		try
		{	
			ObjectInputStream oos = new ObjectInputStream(new FileInputStream(path));
			
			obj = oos.readObject();
			
			oos.close();
		}
		catch(IOException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		return obj;
	}
	
	private String toHexString(int hex, int cl)
	{
		String ret = Integer.toHexString(hex);
		
		ret = ret.toUpperCase();
		
		for(int i = ret.length();i < cl;i++)
			ret = "0" + ret;
		
		return ret;
	}
}
