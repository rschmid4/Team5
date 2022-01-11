import java.awt.Color;
import junit.framework.*;

public class TestMapAttack {

	public void testMapAttack() {

		mp = new Map(100);
		lc = new Location(22,34);
		pm = new PacMan("Bob", lc , mp);
		ghost = new Ghost("Caspar", lc, mp);
		
		Location up = lc.shift(0, 1); 
		Location down = lc.shift(0, -1); 
		Location right = lc.shift(1, 0); 
		Location left = lc.shift(-1, 0); 
		
		GhostComponent gc = new GhostComponent(up.x, up.y, 10);
		PacManComponent pc = new PacManComponent(down.x, down.y, 10);
		GhostComponent gc2 = new GhostComponent(right.x, right.y, 10);
		
		mp.add("Pam", up, gc, Map.Type.GHOST);
		mp.add("Bob", down, pc, Map.Type.PACMAN);

		assertTrue(mp.attack("Caspar"));

	}






}
