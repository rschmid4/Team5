import junit.framework.*;
import java.awt.Color;
import java.io.*;
import java.util.HashSet;


public class TestMapGetLoc extends TestCase {

	public void testMapGetLoc() throws FileNotFoundException {
		Location pacman_loc = new Location(12, 5);
		Location ghost_loc = new Location(11, 5);
		Location L1 = new Location(12, 0);
		Location L2 = new Location(12, 1);

		NoFrame frame = new NoFrame();
		frame.addPacMan(pacman_loc);
		frame.addGhost(ghost_loc, "ghost", Color.red);

		frame.initPlayers();
		frame.startGame();

		Map map = frame.getMap();

		HashSet<Map.Type> h_pacman = map.getLoc(pacman_loc);
		HashSet<Map.Type> h_ghost = map.getLoc(ghost_loc);
		HashSet<Map.Type> h_L1 = map.getLoc(L1);
		HashSet<Map.Type> h_L2 = map.getLoc(L2);

		assertTrue(h_pacman.size() == 2 && h_pacman.contains(Map.Type.PACMAN) && h_pacman.contains(Map.Type.COOKIE));
		assertTrue(h_ghost.size() == 2 && h_ghost.contains(Map.Type.GHOST) && h_ghost.contains(Map.Type.COOKIE));
		assertTrue(h_L1.size() == 1 && h_L1.contains(Map.Type.WALL));
		assertTrue(h_L2.size() == 1 && h_L2.contains(Map.Type.COOKIE));
	}
}
