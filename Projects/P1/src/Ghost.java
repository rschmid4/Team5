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

		Location up = this.myLoc.shift(0, 1);
		Location down = this.myLoc.shift(0, -1);
		Location right = this.myLoc.shift(1, 0);
		Location left = this.myLoc.shift(-1, 0);

		if (!this.myMap.getLoc(right).contains(Map.Type.WALL)) {
			valid_moves.add(right);
		}
		if (!this.myMap.getLoc(left).contains(Map.Type.WALL)) {
			valid_moves.add(left);
		}
		if (!this.myMap.getLoc(up).contains(Map.Type.WALL)) {
			valid_moves.add(up);
		}
		if (!this.myMap.getLoc(down).contains(Map.Type.WALL)) {
			valid_moves.add(down);
		}
		return valid_moves;
	}

	public boolean move() {
		ArrayList <Location> valid_moves = get_valid_moves();
		int numMoves, rand_idx;
		Location rand_loc;

		numMoves = valid_moves.size();
		if (numMoves <= 0)
			return false;

		rand_idx = (int) (Math.random() * numMoves);
		rand_loc = valid_moves.get(rand_idx);
		this.myLoc = rand_loc;
		return this.myMap.move(this.myName, rand_loc, Map.Type.GHOST);
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
		if (is_pacman_in_range())
			return this.myMap.attack(this.myName);

		return false;
	}
}
