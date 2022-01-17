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

                mp.add("wall1", up, new WallComponent(up.x , up.y, size), Map.Type.WALL);
                mp.add("wall3", right, new WallComponent(right.x,right.y, size), Map.Type.WALL);

                frame.addPacMan(pacLoc);
                assertTrue(pm.move());
        }
}
