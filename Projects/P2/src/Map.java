import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import javax.swing.JComponent;

public class Map{

	public enum Type {
		EMPTY,
		PACMAN,
		GHOST,
		WALL,
		COOKIE
	}

	private HashMap<Location, HashSet<Type>> field;
	private boolean gameOver;
	private int dim;

	private HashMap<String, Location> locations;
	private HashMap<String, JComponent> components;
	private HashSet<Type> emptySet;
	private HashSet<Type> wallSet;

	private int cookies = 0;

	public Map(int dim){
		gameOver = false;
		locations = new HashMap<String, Location>();
		components = new HashMap<String, JComponent>();
		field = new HashMap<Location, HashSet<Type>>();

		emptySet = new HashSet<Type>();
		wallSet = new HashSet<Type>();
		emptySet.add(Type.EMPTY);
		wallSet.add(Type.WALL);
		this.dim = dim;
	}


	public void add(String name, Location loc, JComponent comp, Type type) {
		locations.put(name, loc);
		components.put(name, comp);
		if (!field.containsKey(loc)) field.put(loc, new HashSet<Type>());
		field.get(loc).add(type);
	}

	public int getCookies() {
		return cookies;
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public boolean move(String name, Location loc, Type type) {
		//update locations, components, and field
		//use the setLocation method for the component to move it to the new location
		Location currLoc = locations.get(name);
		JComponent comp = components.get(name);

		if (currLoc == null || comp == null || !field.containsKey(currLoc) || !field.containsKey(loc))
			return false;

		locations.put(name, loc);
		comp.setLocation(loc.x, loc.y);

		field.get(loc).add(type);
		field.get(currLoc).remove(type);

		return true;
	}

	public HashSet<Type> getLoc(Location loc) {
		//wallSet and emptySet will help you write this method
		HashSet<Type> loc_types = field.get(loc);

		int x = loc.x;
		int y = loc.y;
		if (y > this.dim || x > this.dim || y <= 0 || x <= 0)
			return wallSet;

		return (loc_types != null && loc_types.size() > 0 ? loc_types : emptySet);
	}

	public boolean attack(String name) {
		/*
			private HashMap<Location, HashSet<Type>> field;
			private HashMap<String, Location> locations;
			private HashMap<String, JComponent> components;
		*/
		ArrayList<Location> lst = new ArrayList<Location>();
		Location ghost_location;
		Boolean ret = false;

		ghost_location = locations.get(name);
		lst.add(ghost_location.shift(1,0));
		lst.add(ghost_location.shift(-1,0));
		lst.add(ghost_location.shift(0,1));
		lst.add(ghost_location.shift(0,-1));

		//  The field, locations, components, and gameOver are all of the relevant variables you can update
		if (name == null || name.length() == 0)
			return ret;

		for (Location loc : lst) {
			if (field.get(loc.x).contains(Map.Type.PACMAN)) {
				locations.put(name, loc);
				field.remove(loc);
				components.remove("pacman");
				ret = true;
				gameOver = true;
				break;
			}
		}

		return ret;
	}

	public JComponent eatCookie(String name) {
		//update locations, components, field, and cookies
		//the id for a cookie at (10, 1) is tok_x10_y1
		String id_prefix = "tok";
		String cookie;
		JComponent cookieComp;
		Location pmLocation;

		pmLocation = locations.get(name);
		if (pmLocation == null || !name.equals("pacman") || !getLoc(pmLocation).contains(Type.COOKIE)) {
			return null;
		}
		// Update the map
		cookie = (id_prefix + "_x" + pmLocation.x + "_y" + pmLocation.y);
		cookieComp = components.get(cookie);
		field.get(pmLocation).remove(Type.COOKIE);
		components.remove(cookie);
		locations.remove(cookie);
		this.cookies++;
		return cookieComp;
	}
}
