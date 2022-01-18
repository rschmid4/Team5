import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestPacManMove extends TestCase {
      public void testPacManMove() throws FileNotFoundException {
                NoFrame frame = new NoFrame();
                int size = 10;
                Location pacLoc = new Location(5,5);
                Map mp = frame.getMap();

                Location up = new Location (5, 4);
                Location right = new Location(6, 5);

                PacMan pm = new PacMan("Aditi", pacLoc, mp);

                frame.addPacMan(pacLoc);
                assertTrue(pm.move());
        }
}
