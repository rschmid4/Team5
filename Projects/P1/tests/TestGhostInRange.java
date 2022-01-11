import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestGhostInRange extends TestCase {
	
	PacMan pm;
	Location lc;
	Map mp;
	Ghost ghost;

	PacMan pm;
	Location lc;
	Map mp;
	Ghost ghost;
	
	public void testGhostInRange(){
		NoFrame frame1 = new NoFrame();
		Location pacLoc = new Location(10,10);
		Location ghoLoc = new Location(9,9);
		frame1.addPacMan(pacLoc);
		frame1.addGhost(ghoLoc, "aditi", Color.red);
		Map mp = frame1.getMap();
		PacMan pac = new PacMan("name", pacLoc, mp);
		assertTrue(pac.is_pacman_in_range());
	}

	public void testGhostInRange2(){
                NoFrame frame1 = new NoFrame();
                Location pacLoc = new Location(10,10);
                Location ghoLoc = new Location(2,5);
                frame1.addPacMan(pacLoc);
                frame1.addGhost(ghoLoc, "aditi", Color.red);
                Map mp = frame1.getMap();
                PacMan pac = new PacMan("name", pacLoc, mp);
                assertFalse(pac.is_pacman_in_range());
        }

}

