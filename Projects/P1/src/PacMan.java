import java.util.HashSet;
import java.util.ArrayList;
import javax.swing.JComponent;

public class PacMan{
	String myName;
	Location myLoc;
	Map myMap;
	Location shift;

	public PacMan(String name, Location loc, Map map) {
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
		* an invalid move is one where the location is occupied by a wall, ghost.
		*/
		for (Location neighbor : valid_moves) {
			HashSet<Map.Type> contents = myMap.getLoc(neighbor);
			Boolean condition = contents == null ||
				contents.contains(Map.Type.GHOST) ||
				contents.contains(Map.Type.WALL);

			if (condition)
				moves_to_remove.add(neighbor);
		}
		valid_moves.removeAll(moves_to_remove);

		return valid_moves;
	}


}


	public boolean move() {
	ArrayList <Location> valid_moves = get_valid_moves();
		int numMoves = valid_moves.size();

		if(numMoves != 0) {
			int randomLoc = (int) (Math.random()* (numMoves));
			return myMap.move(myName, (Location)valid_moves.get(randomLoc), Map.Type.PACMAN);
		} else {
			return false;
		}

	}

	public boolean is_ghost_in_range() {
		if (myMap.getLoc(myLoc.shift(1, 0)).contains(Map.Type.GHOST)){
			return true;
		}
		if (myMap.getLoc(myLoc.shift(0, -1)).contains(Map.Type.GHOST)){
			return true;
		}
		if (myMap.getLoc(myLoc.shift(-1, 0)).contains(Map.Type.GHOST)){
			return true;
		}
		if (myMap.getLoc(myLoc.shift(0, 1)).contains(Map.Type.GHOST)){
			return true;
		}

		return false;
	}

	public JComponent consume() {
		if (this.myMap.getLoc(this.myLoc).contains(Map.Type.COOKIE)) {
			return this.myMap.eatCookie(this.myName);
		}

 		return null;

	}
}
