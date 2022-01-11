import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestPacManMove extends TestCase {

	PacMan pm;
	Location lc;
	Map mp;

	public void testPacManMove(){
		NoFrame frame = new NoFrame();
		mp = new Map(10);
		lc = new Location(5,5);
		pm = new PacMan("Bob", lc , mp);

		Location up = lc.shift(0, 1); 
		Location down = lc.shift(0, -1); 
		Location right = lc.shift(1, 0); 
		Location left = lc.shift(-1, 0);
		
		Map grid = frame.getMap(); 
		frame.addPacMan(lc);

		GhostComponent gc = new GhostComponent(up.x, up.y, 10);
		GhostComponent gc2 = new GhostComponent(right.x, right.y, 10);

		mp.add("Pam", up, gc, Map.Type.GHOST);
		mp.add("Dave", right, gc2, Map.Type.GHOST);

		assertTrue(pm.move());
	}

	public void testPacManCantMove(){
		NoFrame frame = new NoFrame();
		mp = new Map(10);
		lc = new Location(5,5);
		pm = new PacMan("Bob", lc , mp);

		Location up = lc.shift(0, 1); 
		Location down = lc.shift(0, -1); 
		Location right = lc.shift(1, 0); 
		Location left = lc.shift(-1, 0); 

		Map grid = frame.getMap();
                frame.addPacMan(lc);

		GhostComponent gc = new GhostComponent(up.x, up.y, 10);
		GhostComponent gc1 = new GhostComponent(down.x, down.y, 10);
		GhostComponent gc2 = new GhostComponent(right.x, right.y, 10);
		GhostComponent gc3 = new GhostComponent(left.x, left.y, 10);

		mp.add("Pam", up, gc, Map.Type.GHOST);
		mp.add("Bob", down, gc1, Map.Type.GHOST);
		mp.add("Dave", right, gc2, Map.Type.GHOST);
		mp.add("Jim", left, gc3, Map.Type.GHOST);

		assertFalse(pm.move());
	}


}
