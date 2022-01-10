import java.util.HashSet;
import java.util.ArrayList;

public class Ghost{
	String myName;
	Location myLoc;
	Map myMap;

	public Ghost(String name, Location loc, Map map) {
		this.myLoc = loc;
		this.myName = name;
		this.myMap = map;
	}

	public ArrayList<Location> get_valid_moves() {
		return null;
	}

	public boolean move() {

       ArrayList<Location> moves = get_valid_moves();
       int moves_size = moves.size();
 
       if (moves_size > 0) {
           return myMap.move(myName, ((Location) moves.get( (int)
           Math.random() * moves_size )), Map.Type.GHOST);
       }
 
       return false;	
	   }

	public boolean is_pacman_in_range() { 
		return false;
	}

	public boolean attack() {
		return false;
	}
}
