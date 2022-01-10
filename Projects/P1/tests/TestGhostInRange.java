import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestGhostInRange extends TestCase {
	
	PacMan pm;
	Location lc;
	Map mp;
	Ghost ghost;

	public void testGhostInRange(){
		mp = new Map(10);
		lc = new Location(5,5);
		pm = new PacMan("Bob", lc , mp);
		ghost = new Ghost("Pam", lc, mp);
		
		Location up = lc.shift(0, 1); 
		Location down = lc.shift(0, -1); 
		Location right = lc.shift(1, 0); 
		Location left = lc.shift(-1, 0); 
		
		GhostComponent gc = new GhostComponent(up.x, up.y, 10);
		PacManComponent pc = new PacManComponent(down.x, down.y, 10);
		GhostComponent gc2 = new GhostComponent(right.x, right.y, 10);
		WallComponent wc = new WallComponent(left.x, left.y, 10);
		
		mp.add("Pam", up, gc, Map.Type.GHOST);
		mp.add("Bob", down, pc, Map.Type.PACMAN);
		//mp.add("Dave", right, gc2, Map.Type.GHOST);
		mp.add("Jim", left, wc, Map.Type.WALL);
		
		
		assertTrue(ghost.is_pacman_in_range());
	}
}

