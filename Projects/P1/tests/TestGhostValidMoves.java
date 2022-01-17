import junit.framework.*;
import java.awt.Color;
import java.io.*;
import java.util.ArrayList;

public class TestGhostValidMoves extends TestCase {

	public void testGhostValidMoves() throws FileNotFoundException {
		NoFrame frame1 = new NoFrame();
		Ghost ghost1 = frame1.addGhost(new Location(1, 2), "g1", Color.red);
		ArrayList<Location> ans1 = new ArrayList<>();
		ans1.add(new Location(1,3));
		ans1.add(new Location(1,1));
		assertEquals(ghost1.get_valid_moves(), ans1);
	}
}
