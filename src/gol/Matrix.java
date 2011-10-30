package gol;

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

    private int rows() {
        return this.elems.length;
    }

    private int cols() {
        return this.elems[0].length;
    }
}
