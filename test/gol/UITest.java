package gol;

import java.io.StringReader;
import java.io.StringWriter;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class UITest {

    @Before
    public void setUp() {
    }

    @Test
    public void readWorld() throws Exception {
        String input =
                "Generation 1\n" +
                "1 1\n" +
                "*\n";

        char[][] matrix = new char[][] {{'*'}};

        World result = UI.readWorld(new StringReader(input));

        assertEquals(1, result.getGeneration());
        assertArrayEquals(matrix, result.getMatrix());

    }

    @Test
    public void writeWorld() throws Exception {
        World world = new World(3, new char[][] {
            { '*', '.' },
            { '.', '*' },
        });

        String output =
                "Generation 3\n" +
                "2 2\n" +
                "* .\n" +
                ". *\n";

        StringWriter writer = new StringWriter();
        UI.writeWorld(world, writer);
        assertEquals(output, writer.toString());
    }
}
