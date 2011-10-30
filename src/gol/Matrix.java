package gol;

import java.util.Arrays;

public class Matrix<T> {

    public interface Transformation<From, To> {
        public To transform (From value);
    }

    private T[][] elems;

    public Matrix(int rows, int cols) {
        this.elems = (T[][]) new Object[rows][];
        for (int i=0; i< rows; i++)
            this.elems[i] = (T[]) new Object[cols];
    }

    public Matrix(int rows, int cols, T[][] values) {
        this(rows, cols);
        for (int i=0; i<rows; i++)
            for (int j=0; j<cols; j++)
                put(i, j, values[i][j]);
    }

    public T get(int row, int col) {
        return elems[row][col];
    }

    public void put(int row, int col, T value) {
        elems[row][col] = value;
    }

    public<To> Matrix<To> map(Transformation<T, To> transformation) {
        Matrix<To> matrix = new Matrix<To>(rows(), cols());

        for (int i=0; i<rows(); i++)
            for (int j=0; j<cols(); j++)
                matrix.put(i, j, transformation.transform(elems[i][j]));

        return matrix;
    }

    public int rows() {
        return this.elems.length;
    }

    public int cols() {
        return this.elems[0].length;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Matrix<T> other = (Matrix<T>) obj;
        if (!Arrays.deepEquals(this.elems, other.elems)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Arrays.deepHashCode(this.elems);
        return hash;
    }
}
