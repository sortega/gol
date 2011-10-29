package gol;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class WorldTest {

    @Before
    public void setUp() {
    }

    @Test
    public void build1by1Worlds() {
        char[][] emptyWorld = new char[][] {{'.'}};
        World instance = new World(emptyWorld);
        assertEquals(emptyWorld, instance.getMatrix());

        char[][] fullWorld = new char[][] {{'*'}};
        instance = new World(fullWorld);
        assertEquals(fullWorld, instance.getMatrix());
    }
}
