package space.serial;

import pixgen.Vector;
import space.Enemy;
import space.Entity;
import space.Friend;
import space.Player;
import space.body.Planet;
import space.body.SpaceBody;
import space.body.Star;

public class SerialCastor
{
	// TODO: SerialAbility
	
	// SerialEnemy to Enemy
	public static Enemy cast(SerialEnemy obj)
	{
		Enemy ret = (Enemy) SerialCastor.cast((SerialEntity) obj);
		
		ret.setHealth(obj.health);
		ret.setShield(obj.shield);
		ret.setPower(obj.power);

		//ret.setAbilitys(SerialCastor.cast(obj.abilities));

		return ret;
	}
	
	// Friend to SerialEnemy
	public static SerialEnemy cast(Enemy obj)
	{
		SerialEnemy ret = (SerialEnemy) SerialCastor.cast((Entity) obj);
		
		ret.health = obj.getHealth();
		ret.shield = obj.getShield();
		ret.power = obj.getPower();
		
		//ret.abilities = SerialCastor.cast(obj.getAbilitys());
		
		return ret;
	}
	
	// SerialEntity to Entity
	public static Entity cast(SerialEntity obj)
	{
		Entity ret = new Entity();
		
		ret.setPosition(SerialCastor.cast(obj.position));
		ret.setDirection(SerialCastor.cast(obj.direction));
		
		return ret;
	}
	
	// Entity to SerialEntity
	public static SerialEntity cast(Entity obj)
	{
		SerialEntity ret = new SerialEntity();
		
		ret.position = SerialCastor.cast(obj.getPosition());
		ret.direction = SerialCastor.cast(obj.getDirection());
		
		return ret;
	}
	
	// SerialFriend to Friend
	public static Friend cast(SerialFriend obj)
	{
		Friend ret = (Friend) SerialCastor.cast((SerialEntity) obj);
		
		ret.setHealth(obj.health);
		ret.setShield(obj.shield);
		ret.setPower(obj.power);

		//ret.setAbilitys(SerialCastor.cast(obj.abilities));
		
		ret.setUsername(obj.username);
		
		return ret;
	}
	
	// Friend to SerialFriend
	public static SerialFriend cast(Friend obj)
	{
		SerialFriend ret = (SerialFriend) SerialCastor.cast((Entity) obj);
		
		ret.health = obj.getHealth();
		ret.shield = obj.getShield();
		ret.power = obj.getPower();
		
		//ret.abilities = SerialCastor.cast(obj.getAbilitys());
		
		ret.username = obj.getUsername();
		
		return ret;
	}
	
	// SerialPlanet to Planet
	public static Planet cast(SerialPlanet obj)
	{
		return new Planet(
				obj.renderkey,
				null,
				obj.dist,
				obj.arc
		);
	}
	
	// Planet to SerialPlanet
	public static SerialPlanet cast(Planet obj)
	{
		SerialPlanet ret = (SerialPlanet) SerialCastor.cast((SpaceBody) obj);
		
		ret.dist = obj.getDist();
		ret.arc = obj.getArc();
		
		return ret;
	}
	
	// SerialPlayer to Player
	public static Player cast(SerialPlayer obj)
	{
		Player ret = (Player) SerialCastor.cast((SerialEntity) obj);
		
		ret.setHealth(obj.health);
		ret.setShield(obj.shield);
		ret.setPower(obj.power);

		//ret.setAbilitys(SerialCastor.cast(obj.abilities));

		return ret;
	}
	
	// Player to SerialPlayer
	public static SerialPlayer cast(Player obj)
	{
		SerialPlayer ret = (SerialPlayer) SerialCastor.cast((Entity) obj);
		
		ret.health = obj.getHealth();
		ret.shield = obj.getShield();
		ret.power = obj.getPower();
		
		//ret.abilities = SerialCastor.cast(obj.getAbilitys());
		
		return ret;
	}
	
	// SerialSpaceBody to SpaceBody
	public static SpaceBody cast(SerialSpaceBody obj)
	{
		return new SpaceBody(
				"", 
				obj.renderkey
		);
	}
	
	// SpaceBody to SerialSpaceBody
	public static SerialSpaceBody cast(SpaceBody obj)
	{
		SerialSpaceBody ret = (SerialSpaceBody) SerialCastor.cast((Entity) obj);
		
		ret.renderkey = obj.getRenderkey();
		
		return ret;
	}
	
	// SerialStar to Star
	public static Star cast(SerialStar obj)
	{
		return new Star(
				obj.renderkey
		);
	}
	
	public static SerialStar cast(Star obj)
	{
		SerialStar ret = (SerialStar) SerialCastor.cast((SpaceBody) obj);
		
		return ret;
	}
	
	// TODO: SerialTeam
	
	// TODO: SerialTerritory
	
	// SerialVector to Vector
	public static Vector cast(SerialVector obj)
	{
		return new Vector(
				obj.x, 
				obj.y
		);
	}
	
	// Vector to SerialVector
	public static SerialVector cast(Vector obj)
	{
		SerialVector ret = new SerialVector();
		
		ret.x = obj.getX();
		ret.y = obj.getY();
		
		return ret;
	}
}