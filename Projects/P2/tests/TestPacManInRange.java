import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestPacManInRange extends TestCase {
 
   PacMan myPacman;
   Map myMap;
   Ghost myGhost;
   Location loc1; 
 
   public void testPacManInRange() {
	   
	   loc1 = new Location(5,6);
	   Location loc2 = loc1.shift(1,0);

	   // Create my playing field. 
       myMap = new Map(100);
	   myPacman = new PacMan("Manny", loc1, myMap);
       myGhost = new Ghost("Caspar", loc2, myMap);

		// Add Components 
		GhostComponent gcomponent = new GhostComponent(6, 6, 10);
		PacManComponent pcomponent = new PacManComponent(5 ,6, 10);

		// Add to map 
		myMap.add("Caspar", loc2, gcomponent, Map.Type.GHOST);
		myMap.add("Manny", loc1, pcomponent, Map.Type.PACMAN);
		
		// Check if the Ghost is right next to the homeboy Manny 
      	assertTrue(myPacman.is_ghost_in_range());

 	}

	public void testPacManIsNotRange() {
	   
	   loc1 = new Location(405, 63);
	   Location loc2 = loc1.shift(10,4);

	   // Create my playing field. 
       myMap = new Map(500);
	   myPacman = new PacMan("Manny", loc1, myMap);
       myGhost = new Ghost("Caspar", loc2, myMap);

	   // Add Components 
		GhostComponent gcomponent = new GhostComponent(415, 67, 10);
		PacManComponent pcomponent = new PacManComponent(405, 63, 10);

		// Add to map 
		myMap.add("Caspar", loc2, gcomponent, Map.Type.GHOST);
		myMap.add("Manny", loc1, pcomponent, Map.Type.PACMAN);
		
		// Check if the Ghost is right next to the homeboy Manny 
      	assertFalse(myPacman.is_ghost_in_range());

 	}
}
