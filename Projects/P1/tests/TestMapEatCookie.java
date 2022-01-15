import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestMapEatCookie extends TestCase {

	public void testMapEatCookie() {
		Map m = new Map(10);
		PacManComponent pmc = new PacManComponent(3, 3, 10);
		CookieComponent cc = new CookieComponent(3, 3, 10);

		m.add("pacman", new Location(3, 3), pmc, Map.Type.PACMAN);
		m.add("tok_x3_y3", new Location(3, 3), cc, Map.Type.COOKIE);

		assertTrue(m.eatCookie("pacman").equals(cc));

	}

	public void testMapEatCookieFail() {
		Map m = new Map(10);
		PacManComponent pmc = new PacManComponent(5, 2, 10);
		CookieComponent cc = new CookieComponent(3, 3, 10);

		m.add("pacman", new Location(5, 2), pmc, Map.Type.PACMAN);
		m.add("tok_x3_y3", new Location(3, 3), cc, Map.Type.COOKIE);

		assertTrue(m.eatCookie("pacman") == null);

	}


}
