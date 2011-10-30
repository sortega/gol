package gol;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MatrixTest {
    @Before
    public void setUp() {
    }

    @Test
    public void buildEmptyMatrix() {
        Matrix<Integer> instance = new Matrix(2, 2);
        for (int i=0; i<2; i++)
            for (int j=0; j<2; j++)
                assertNull(instance.get(i, j));
    }
}
