package pixgen;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.util.HashMap;

public class AudioManager 
{
	private HashMap<String, AudioClip> clips = new HashMap<String, AudioClip>();
	
	public void addAudio(String name, String path)
	{
		if(!clips.containsKey(name))
		{
			try 
			{
				AudioClip clip = Applet.newAudioClip(new File(path).toURI().toURL());
				
				clips.put(name, clip);
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	public void playAudio(String name)
	{
		clips.get(name).play();
	}
	
	public void stopAudio(String name)
	{
		clips.get(name).stop();
	}
	
	public AudioClip getAudio(String name)
	{
		return clips.get(name);
	}
}
