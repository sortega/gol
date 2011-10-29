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
        World instance = new World(1, emptyWorld);
        assertArrayEquals(emptyWorld, instance.getMatrix());

        instance = new World(1, fullWorld);
        assertArrayEquals(fullWorld, instance.getMatrix());
    }

    @Test
    public void next1by1World() {
        World instance = new World(1, fullWorld);
        World nextWorld = instance.next();
        assertArrayEquals(emptyWorld, nextWorld.getMatrix());
        assertEquals(2, nextWorld.getGeneration());
    }

    @Test
    public void static3x3World() {
        char[][] static3x3World = new char[][] {
            { '.', '*', '.'},
            { '*', '.', '*'},
            { '.', '*', '.'}
        };
        World instance = new World(1, static3x3World);
        assertArrayEquals(static3x3World, instance.next().getMatrix());
    }
}
