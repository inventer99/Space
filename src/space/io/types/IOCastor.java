package space.io.types;

import space.body.Planet;

public class IOCastor
{
	public static Planet cast(IOPlanet planet)
	{
		return new Planet(
				planet.renderkey,
				null,
				planet.dist,
				planet.arc
		);
	}
	
	public static IOPlanet cast(Planet planet)
	{
		IOPlanet ret = new IOPlanet();
		
		ret.renderkey = planet.getRenderkey();
		ret.dist = planet.getDist();
		ret.arc = planet.getArc();
		
		return ret;
	}
}