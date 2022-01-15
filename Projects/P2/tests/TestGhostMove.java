import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestGhostMove extends TestCase {

  PacMan myPacman;
	Map myMap;
	Ghost myGhost;
	Location loc1;

	public void testGhostCantMove(){

		loc1 = new Location(5,6);

		// Create my playing field.
		myMap = new Map(100);
		myGhost = new Ghost("Caspar", loc1, myMap);

		// Add Components
		GhostComponent gcomponent0 = new GhostComponent(5, 6, 10);
		WallComponent wcomponent1 = new WallComponent(6, 6, 10);
		WallComponent wcomponent2 = new WallComponent(4, 6, 10);
		WallComponent wcomponent3 = new WallComponent(5, 5, 10);
		WallComponent wcomponent4 = new WallComponent(5, 7, 10);

		// Add to map
		myMap.add("Caspar", loc1, gcomponent0, Map.Type.GHOST);
		myMap.add("Joe", new Location(6, 6), wcomponent1, Map.Type.WALL);
		myMap.add("Low", new Location(4, 6), wcomponent2, Map.Type.WALL);
		myMap.add("Foe", new Location(5, 5), wcomponent3, Map.Type.WALL);
		myMap.add("Row", new Location(5, 7), wcomponent4, Map.Type.WALL);

		// False since Caspar is boxed in by walls
		assertFalse(myGhost.move());
	}
}
