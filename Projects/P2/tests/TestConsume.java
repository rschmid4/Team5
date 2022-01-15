import junit.framework.*;
import java.awt.Color;
import java.io.*;
import java.util.*;

import javax.swing.JComponent;

public class TestConsume extends TestCase {

	public void testConsume() {

		Map m = new Map(10);
		Location loc = new Location(5, 5);
		PacMan p = new PacMan("pacman", loc, m);
		PacManComponent p1 = new PacManComponent(5, 5, 10);
		CookieComponent cookie = new CookieComponent(5, 5, 10);

		m.add("tok_x5_y5", loc, cookie, Map.Type.COOKIE);
		m.add("pacman", loc, p1, Map.Type.PACMAN);

		assertTrue(p.consume().equals(cookie));
	}

	public void testConsumeFail() {
		Map m = new Map(10);
		PacMan p = new PacMan("pacman", new Location(3, 2), m);
		PacManComponent p1 = new PacManComponent(3, 2, 10);
		CookieComponent cookie = new CookieComponent(5, 5, 10);

		m.add("tok_x5_y5", new Location(5, 5), cookie, Map.Type.COOKIE);
		m.add("pacman", new Location(3, 2), p1, Map.Type.PACMAN);

		assertTrue(p.consume() == null);
	}
}
