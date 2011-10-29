package gol;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CellTest {
    private Cell instance;

    private void addAliveNeightbours(int number) {
        for (int i=0; i<number; i++) {
            Cell aliveNeightbour = new Cell(true);
            instance.addNeightbour(aliveNeightbour);
        }
    }

    @Before
    public void setUp() {
    }

    @Test
    public void aliveAndDeadCells() {
        instance = new Cell(true);
        assertTrue(new Cell(true).isAlive());
        assertFalse(new Cell(false).isAlive());
    }

    @Test
    public void deathByOverpopulation() {
        instance = new Cell(true);
        addAliveNeightbours(4);
        assertFalse(instance.next().isAlive());
    }

    @Test
    public void deathByUnderpopulation() {
        instance = new Cell(true);
        addAliveNeightbours(1);
        assertFalse(instance.next().isAlive());
    }

    @Test
    public void keptAliveWith2Neighbours() {
        instance = new Cell(true);
        addAliveNeightbours(2);
        assertTrue(instance.next().isAlive());
    }

    @Test
    public void keptAliveWith3Neighbours() {
        instance = new Cell(true);
        addAliveNeightbours(3);
        assertTrue(instance.next().isAlive());
    }

    @Test
    public void respawnOnThreeAliveNeightbours() {
        instance = new Cell(false);
        addAliveNeightbours(3);
        assertTrue(instance.next().isAlive());
    }

    @Test
    public void keptDeathWithOtherThan3() {
        instance = new Cell(false);
        addAliveNeightbours(2);
        assertFalse(instance.next().isAlive());
        addAliveNeightbours(2); // 4!
        assertFalse(instance.next().isAlive());
    }
}
