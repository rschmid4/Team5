import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestMapAttack extends TestCase{

	PacMan myPacman;
	Map myMap;
	Ghost myGhost;
	Location loc1; 

	public void testMapAttack() {

		// Create my location starters
   		loc1 = new Location(5,6);
		Location loc2 = new Location(6,6);

		// Create my playing field. 
		myMap = new Map(10);
		myGhost = new Ghost("Caspar", loc1, myMap);

		// Add Components 
		GhostComponent gcomponent = new GhostComponent(5, 6, 10);
		PacManComponent pcomponent = new PacManComponent(6, 6, 10);

		// Add to map my Ghost + PacMan
		myMap.add("Caspar", loc1, gcomponent, Map.Type.GHOST);
		myMap.add("Manny", loc2, pcomponent, Map.Type.PACMAN);

		// Check if the PacMan is right next to the homeboy Caspar 
		assertTrue(myMap.attack("Caspar"));
	}
}
