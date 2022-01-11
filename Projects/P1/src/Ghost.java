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
		int x = myLoc.x;
		int y = myLoc.y;
		
		
		Location left = new Location (x, y+1);
		Location down = new Location (x+1, y);
		Location up = new Location(x-1, y);
		Location right = new Location(x, y-1);
		
		
		
		if (!myMap.getLoc(right).contains(Map.Type.WALL)) {
			valid_moves.add(right);
		}
		if (!myMap.getLoc(left).contains(Map.Type.WALL)) {
			valid_moves.add(left);
		}
		if (!myMap.getLoc(up).contains(Map.Type.WALL)) {
			valid_moves.add(up);
		}
		if (!myMap.getLoc(down).contains(Map.Type.WALL)) {
			valid_moves.add(down);
		}
		return valid_moves;
		
	}

	public boolean move() {
		ArrayList<Location> moves = get_valid_moves();
		int moves_size = moves.size();

       	if (moves_size > 0 && moves != null) {
	       int size = (int) Math.floor(Math.random() * (moves_size ));
	       Location input = moves.get(size);
		this.myLoc = input;
           myMap.move(myName, input , Map.Type.GHOST);
	       return true;
       	}else {
		return false;
      	 }
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
