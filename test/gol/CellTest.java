package gol;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CellTest {

    @Before
    public void setUp() {
    }

    @Test
    public void aliveAndDeadCells() {
        assertTrue(new Cell(true).isAlive());
        assertFalse(new Cell(false).isAlive());
    }

//    @Test
//    public void deathByOverpopulation() {
//        Cell liveCell = new Cell(true);
//
//
//    }
}
