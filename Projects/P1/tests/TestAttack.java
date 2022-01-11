import junit.framework.*;
import java.awt.Color;
import java.io.*;

import javax.swing.JComponent;

public class TestAttack extends TestCase {

	public void testAttack() throws FileNotFoundException{

		Map m = new Map(10);

		Ghost g = new Ghost("ghost1", new Location(4, 5), m);

		PacManComponent pmc = new PacManComponent(5, 5, 10);
		GhostComponent gc = new GhostComponent(4, 5, 10);

		m.add("ghost1", new Location(4, 5), gc, Map.Type.GHOST);
		m.add("pacman1", new Location(5, 5), pmc, Map.Type.PACMAN);

		assertTrue(g.attack());

	}

	public void testAttackFail() throws FileNotFoundException{

		Map m = new Map(10);

		Ghost g = new Ghost("ghost1", new Location(4, 5), m);

		PacManComponent pmc = new PacManComponent(3, 6, 10);
		GhostComponent gc = new GhostComponent(4, 5, 10);

		m.add("ghost1", new Location(4, 5), gc, Map.Type.GHOST);
		m.add("pacman1", new Location(3, 6), pmc, Map.Type.PACMAN);

		assertFalse(g.attack());

	}


}
