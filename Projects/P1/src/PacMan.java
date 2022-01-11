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

                 Location up = new Location(myLoc.shift(0,0), myLoc.shift(0,-1));
                Location down =  new Location(myLoc.shift(0,0), myLoc.shift(0,1));
                Location right =  new Location(myLoc.shift(1,0), myLoc.shift(0,0));
                Location left =  new Location(myLoc.shift(-1,0), myLoc.shift(0,0));



                if(myMap.getLoc(up) == null || myMap.getLoc(up).size() == 0){
                        valid_moves.add(up);
                }
                if(myMap.getLoc(down) == null ||myMap.getLoc(down).size() == 0){
                        valid_moves.add(down);
                }
                if(myMap.getLoc(left) == null ||myMap.getLoc(left).size() == 0){
                        valid_moves.add(left);
                }
                if(myMap.getLoc(right) == null ||myMap.getLoc(right).size() == 0){
                        valid_moves.add(right);
                }

                return valid_moves;

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
