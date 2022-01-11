import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestPacManInRange extends TestCase {

	public void testPacManInRange() {
		Map mp = new Map(10);
		Location lc = new Location(5,5);
		PacMan pm = new PacMan("Bob", lc , mp);
		Ghost ghost = new Ghost("Pam", lc, mp);

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
		mp.add("Jim", left, wc, Map.Type.WALL);

		assertTrue(pm.is_ghost_in_range());
	}
}
