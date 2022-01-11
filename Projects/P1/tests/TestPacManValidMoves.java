import junit.framework.*;
import java.awt.Color;
import java.io.*;
import java.util.ArrayList;

public class TestPacManValidMoves extends TestCase {

	public void testPacManValidMoves() throws FileNotFoundException{
		Location loc = new Location(5,5);
		NoFrame frame = new NoFrame();
		ArrayList<Location> moves = new ArrayList<Location>();


		Location up = loc.shift(0, 1);
		Location down = loc.shift(0, -1);
		Location right = loc.shift(1, 0);
		Location left = loc.shift(-1, 0);

		moves.add(up);
		moves.add(down);
		moves.add(right);
		moves.add(left);

		Map map = frame.getMap();
		for (Location move : moves) {
			System.out.println(move);
			for (Map.Type t : map.getLoc(move)) {
				System.out.println(t);
			}
		}

		PacMan pacman = frame.addPacMan(loc);
		Ghost ghost = frame.addGhost(up, "ghost", Color.red);

		frame.initPlayers();
		frame.startGame();

		ArrayList<Location> valid_moves = pacman.get_valid_moves();

		assertTrue(valid_moves.size() == 1);
	}
}
