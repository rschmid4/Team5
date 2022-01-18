import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestGhostInRange extends TestCase {

	public void testGhostInRange() throws FileNotFoundException {
		NoFrame frame = new NoFrame();
		Ghost ghost = frame.addGhost(new Location(2, 9), "ghosty", Color.RED);
		PacMan pacman = frame.addPacMan(new Location(2, 8));
		assertTrue(ghost.is_pacman_in_range());
	}

	public void testGhostInRange2() throws FileNotFoundException {
		NoFrame frame = new NoFrame();
		Ghost ghost = frame.addGhost(new Location(5, 9), "ghosty", Color.RED);
		PacMan pacman = frame.addPacMan(new Location(2, 8));
		assertFalse(ghost.is_pacman_in_range());
	}
}
