import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestMapMove extends TestCase {

	
	public void testMapMove() throws FileNotFoundException {
                NoFrame frame = new NoFrame();

                Location pacLoc = new Location(5, 5);
                PacMan pac = frame.addPacMan(pacLoc);
                int scale = 10;

                Map mp = frame.getMap();
                Location up = new Location (5, 4);
                Location down = new Location(5, 6);
                Location right = new Location(4, 5);
                Location left = new Location(6 , 5);

                mp.add("wall1", up, new WallComponent(up.x , up.y, scale), Map.Type.WALL);
                mp.add("wall2", down, new WallComponent(down.x, down.y,scale), Map.Type.WALL);
                mp.add("wall3", right, new WallComponent(right.x,right.y,scale), Map.Type.WALL);

                assertTrue(mp.move("pacman", left, Map.Type.PACMAN));
        }

        public void testMapCantMove() throws FileNotFoundException {
                NoFrame frame = new NoFrame();
                Location pacLoc = new Location(5, 5);
                PacMan pac = frame.addPacMan(pacLoc);
                int scale = 10;

                Map mp = frame.getMap();
                Location up = new Location (5, 4);
                Location down = new Location(5, 6);
                Location right = new Location(4, 5);
                Location left = new Location(6 , 5);

                mp.add("wall1", up, new WallComponent(up.x , up.y, scale), Map.Type.WALL);
                mp.add("wall2", down, new WallComponent(down.x, down.y,scale), Map.Type.WALL);
                mp.add("wall3", right, new WallComponent(right.x,right.y,scale), Map.Type.WALL);
                mp.add("wall4", left, new WallComponent(left.x, left.y,scale), Map.Type.WALL);


                assertFalse(mp.move("ghost", left, Map.Type.GHOST) && ((mp.move("pacman", right, Map.Type.PACMAN)))
                            && (mp.move("ghost", up, Map.Type.GHOST)) && (mp.move("ghost", down, Map.Type.GHOST)));
        }
}
