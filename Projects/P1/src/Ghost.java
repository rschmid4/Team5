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
	 ArrayList<Location> valid_moves = new ArrayList<Location>();
	ArrayList<Location> moves_to_remove = new ArrayList<Location>();


		/* determime neighbors in all 4 possible directions */
		valid_moves.add(myLoc.shift(0, 1));
		valid_moves.add(myLoc.shift(1, 0));
		valid_moves.add(myLoc.shift(0, -1));
		valid_moves.add(myLoc.shift(-1, 0));

		/*
		* figure out which neighboring moves are invalid and remove them from valid_moves.
		* an invalid GHOST move is one where the location is occupied by a wall.
		*/
		for (Location neighbor : valid_moves) {
			HashSet<Map.Type> contents = myMap.getLoc(neighbor);

			Boolean condition = contents == null || contents.contains(Map.Type.WALL);

			if (condition)
				moves_to_remove.add(neighbor);

		}

		valid_moves.removeAll(moves_to_remove);

		return valid_moves;
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

		Location up = new Location(myLoc.x, myLoc.y-1);
		Location down =  new Location(myLoc.x, myLoc.y+1);
		Location right =  new Location(myLoc.x+1, myLoc.y);
		Location left =  new Location(myLoc.x-1, myLoc.y);

		if(myMap.getLoc(up).contains(Map.Type.PACMAN)){
			return true;
		}
		if(myMap.getLoc(down).contains(Map.Type.PACMAN)){
			return true;
		}
		if(myMap.getLoc(left).contains(Map.Type.PACMAN)){
			return true;
		}
		if(myMap.getLoc(right).contains(Map.Type.PACMAN)){
			return true;
		}
		return false;
	}

	public boolean attack() {
	if (is_pacman_in_range()) {
			this.myMap.attack(this.myName);
			return true;
		}
		return false;
	}
}
