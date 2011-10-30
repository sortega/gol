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

    @Test
    public void modifyMatrix() {
        Matrix<Integer> instance = new Matrix(1, 1);
        instance.put(0, 0, 13);
        assertEquals((Integer) 13, instance.get(0, 0));
    }
}
