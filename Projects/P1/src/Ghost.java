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
			Boolean condition = contents == null ||
				contents.contains(Map.Type.WALL);
			valid_moves.removeIf(ele -> condition);
		}

		return valid_moves;
	}

	public boolean move() {
		return false;
	}

	public boolean is_pacman_in_range() {
		return false;
	}

	public boolean attack() {
		return false;
	}
}
