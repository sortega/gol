package gol;

import java.io.StringReader;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class UITest {

    @Before
    public void setUp() {
    }

    @Test
    public void readWorld() {
        String input =
                "Generation 1\n" +
                "1 1\n" +
                "*\n";

        char[][] matrix = new char[][] {{'*'}};

        World result = UI.readWorld(new StringReader(input));

        assertEquals(1, result.getGeneration());
        assertArrayEquals(matrix, result.getMatrix());

    }
}
