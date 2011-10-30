package gol;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class WorldTest {
    private Matrix<Character> emptyWorld;
    private Matrix<Character> fullWorld;

    @Before
    public void setUp() {
        emptyWorld = new Matrix<Character>(1, 1, new Character[][] {{'.'}});
        fullWorld = new Matrix<Character>(1, 1, new Character[][] {{'*'}});
    }

    @Test
    public void build1by1Worlds() {
        World instance = new World(1, emptyWorld);
        assertEquals(emptyWorld, instance.getMatrix());

        instance = new World(1, fullWorld);
        assertEquals(fullWorld, instance.getMatrix());
    }

    @Test
    public void next1by1World() {
        World instance = new World(1, fullWorld);
        World nextWorld = instance.next();
        assertEquals(emptyWorld, nextWorld.getMatrix());
        assertEquals(2, nextWorld.getGeneration());
    }

    @Test
    public void static3x3World() {
        Matrix<Character> static3x3World = new Matrix<Character>(3, 3, new Character[][] {
            { '.', '*', '.'},
            { '*', '.', '*'},
            { '.', '*', '.'}
        });
        World instance = new World(1, static3x3World);
        assertEquals(static3x3World, instance.next().getMatrix());
    }
}
