import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestGhostMove extends TestCase {

	Location lc;
	Map mp;

	public void testGhostMove(){

		mp = new Map(100);
		lc = new Location(5,5);
		ghost = new Ghost("Caspar", lc, mp);

		Location up = new Location(4,6); 
		Location right = new Location(5,3); 
		Location left = new Location(52,1); 

		GhostComponent gc = new GhostComponent(up.x, up.y, 10);
		GhostComponent gc2 = new GhostComponent(right.x, right.y, 10);
		GhostComponent gc3 = new GhostComponent(left.x, left.y, 10);

		mp.add("Pame", up, gc, Map.Type.GHOST);
		mp.add("Dave", right, gc2, Map.Type.GHOST);
		mp.add("Jim", left, gc3, Map.Type.GHOST);

		// Ghost should be able to move in only one spot 
		assertTrue(ghost.move());
	}

}
