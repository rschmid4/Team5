import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestGhostInRange extends TestCase {

	public void testGhostInRange() throws FileNotFoundException {
		PacMan pm;
		Location lc;
		Map mp;
		Ghost ghost;
		PacMan pac;
		NoFrame frame1 = new NoFrame();
		Location pacLoc = new Location(10,10);
		Location ghoLoc = new Location(9,10);

		frame1.addPacMan(pacLoc);
		frame1.addGhost(ghoLoc, "aditi", Color.RED);
		mp = frame1.getMap();
		pac = new PacMan("name", pacLoc, mp);
		assertTrue(pac.is_ghost_in_range());
	}

	public void testGhostInRange2() throws FileNotFoundException {
		PacMan pm;
		Location lc;
		Map mp;
		Ghost ghost;
		PacMan pac;
		NoFrame frame1 = new NoFrame();
		Location pacLoc = new Location(10,10);
		Location ghoLoc = new Location(2,5);

		frame1.addPacMan(pacLoc);
		frame1.addGhost(ghoLoc, "aditi", Color.RED);
		mp = frame1.getMap();
		pac = new PacMan("name", pacLoc, mp);
		assertFalse(pac.is_ghost_in_range());
	}
}
