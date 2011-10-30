package gol;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MatrixTest {

    private Matrix<Integer> instance;

    @Test
    public void buildEmptyMatrix() {
        instance = new Matrix(2, 2);
        for (int i=0; i<2; i++)
            for (int j=0; j<2; j++)
                assertNull(instance.get(i, j));
    }

    @Test
    public void modifyMatrix() {
        instance = new Matrix(1, 1);
        instance.put(0, 0, 13);
        assertEquals((Integer) 13, instance.get(0, 0));
    }

    @Test
    public void mapMatrix() {
        instance = new Matrix(2, 2, new Integer[][] {{1, 2}, {3, 4}});
        Matrix result = instance.map(new Matrix.Transformation<Integer, String> () {
            @Override
            public String transform(Integer value) {
                return value.toString();
            }
        });

        assertEquals("1", result.get(0, 0));
        assertEquals("4", result.get(1, 1));
    }
}
