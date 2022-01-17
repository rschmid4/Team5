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
		if (numMoves <= 0){
			return false;
		} 
		else {
			rand_idx = (int) (Math.random() * numMoves);
			rand_loc = valid_moves.get(rand_idx);
			this.myLoc = rand_loc;
			return this.myMap.move(this.myName, rand_loc, Map.Type.PACMAN);
		}

	}

	public boolean is_ghost_in_range() {
		Location up = this.myLoc.shift(0, 1);
		Location down = this.myLoc.shift(0, -1);
		Location right = this.myLoc.shift(1, 0);
		Location left = this.myLoc.shift(-1, 0);
		Boolean condition;

		condition = this.myMap.getLoc(up).contains(Map.Type.WALL) ||
					this.myMap.getLoc(down).contains(Map.Type.WALL) ||
					this.myMap.getLoc(left).contains(Map.Type.WALL) ||
					this.myMap.getLoc(right).contains(Map.Type.WALL);

		return condition;
	}

	public JComponent consume() {
		Location loc = new Location(this.myLoc.x, this.myLoc.y);

		if (this.myMap.getLoc(loc).contains(Map.Type.COOKIE)) {
			return null;
		}

		GhostComponent gc = new GhostComponent(5, 5, 10);
 		return gc;
	}
}
