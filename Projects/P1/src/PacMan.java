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
		int x = myloc.x;
		int y = myloc.y;
		
		Location upright = new Location(x-1,y-1);
		Location upleft = new Location(x-1, y+1);
		Location downright = new Location(x+1,y-1);
		Location downleft = new Location(x+1,y+1);
		Location left = new Location (x, y+1);
		Location down = new Location (x+1, y);
		Location up = new Location(x-1, y);
		Location right = new Location(x, y-1);
		
		
		if (!myMap.getLoc(upright).contains(Map.Type.WALL)  && !myMap.getLoc(upright).contains(Map.Type.GHOST)) {
			valid_moves.add(upright);
		}
		if (!myMap.getLoc(upleft).contains(Map.Type.WALL)  && !myMap.getLoc(upleft).contains(Map.Type.GHOST)) {
			valid_moves.add(upleft);
		}
		if (!myMap.getLoc(downleft).contains(Map.Type.WALL)  && !myMap.getLoc(downleft).contains(Map.Type.GHOST)) {
			valid_moves.add(downleft);
		}
		    
		if (!myMap.getLoc(downright).contains(Map.Type.WALL)  && !myMap.getLoc(downright).contains(Map.Type.GHOST)) {
			valid_moves.add(downright);
		}
		if (!myMap.getLoc(right).contains(Map.Type.WALL)  && !myMap.getLoc(right).contains(Map.Type.GHOST)) {
			valid_moves.add(right);
		}
		if (!myMap.getLoc(left).contains(Map.Type.WALL)  && !myMap.getLoc(left).contains(Map.Type.GHOST)) {
			valid_moves.add(left);
		}
		if (!myMap.getLoc(up).contains(Map.Type.WALL)  && !myMap.getLoc(up).contains(Map.Type.GHOST)) {
			valid_moves.add(up);
		}
		if (!myMap.getLoc(down).contains(Map.Type.WALL)  && !myMap.getLoc(down).contains(Map.Type.GHOST)) {
			valid_moves.add(down);
		}
		return valid_moves;
		
	}

	public boolean move() {
	ArrayList <Location> valid_moves = get_valid_moves();
		int numMoves = valid_moves.size();

		if(numMoves != 0) {
			int randomLoc = (int) (Math.random()* (numMoves));
			this.myMap.move(myName, (Location)valid_moves.get(randomLoc), Map.Type.PACMAN);
			return true;
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
		if (this.myMap.getLoc(new Location(myLoc.x, myLoc.y)).contains(Map.Type.COOKIE)) {
			return this.myMap.eatCookie(this.myName);
		}

 		return null;

	}
}
