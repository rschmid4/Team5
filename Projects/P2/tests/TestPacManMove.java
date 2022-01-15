import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestPacManMove extends TestCase {
       public void testPacManMove() throws FileNotFoundException {
                NoFrame frame = new NoFrame();
                Map mp = frame.getMap();
                Location pacLoc = new Location(1,1);
                Location down = pacLoc.shift(0, -1);
                Location left = pacLoc.shift(-1, 0);

                PacMan pm = new PacMan("Aditi", pacLoc, mp);
                PacManComponent pacComp = new PacManComponent(pacLoc.x, pacLoc.y, 30);
                mp.add("Aditi", pacLoc, pacComp, Map.Type.PACMAN);
                assertTrue(pm.move());
        }

        public void testPacManCantMove() throws FileNotFoundException {
                NoFrame frame = new NoFrame();
                Map mp = frame.getMap();
                Location pacLoc = new Location(1,1);
              
                Location down = pacLoc.shift(0, -1);
                Location left = pacLoc.shift(-1, 0);
                Location up = pacLoc.shift(0, 1);
                Location right = pacLoc.shift(1, 0);

                PacMan pm = new PacMan("Aditi", pacLoc, mp);
                PacManComponent pacComp = new PacManComponent(pacLoc.x, pacLoc.y, 30);
                mp.add("Aditi", pacLoc, pacComp, Map.Type.PACMAN);
              
                assertFalse(pm.move());
        }

}
