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
        instance = new Cell(true);
    }

    @Test
    public void aliveAndDeadCells() {
        assertTrue(new Cell(true).isAlive());
        assertFalse(new Cell(false).isAlive());
    }

    @Test
    public void deathByOverpopulation() {
        addAliveNeightbours(4);
        assertFalse(instance.next().isAlive());
    }

    @Test
    public void deathByUnderpopulation() {
        addAliveNeightbours(1);
        assertFalse(instance.next().isAlive());
    }

    @Test
    public void keptAliveWith2Neighbours() {
        addAliveNeightbours(2);
        assertTrue(instance.next().isAlive());
    }

    @Test
    public void keptAliveWith3Neighbours() {
        addAliveNeightbours(3);
        assertTrue(instance.next().isAlive());
    }
}
