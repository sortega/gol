package gol;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class WorldTest {
    private char[][] emptyWorld;
    private char[][] fullWorld;

    @Before
    public void setUp() {
        emptyWorld = new char[][] {{'.'}};
        fullWorld = new char[][] {{'*'}};
    }

    @Test
    public void build1by1Worlds() {
        World instance = new World(emptyWorld);
        assertArrayEquals(emptyWorld, instance.getMatrix());

        instance = new World(fullWorld);
        assertArrayEquals(fullWorld, instance.getMatrix());
    }

    @Test
    public void next1by1World() {
        World instance = new World(fullWorld);
        assertArrayEquals(emptyWorld, instance.next().getMatrix());
    }
}
