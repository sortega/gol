package gol;

public class Matrix<T> {
    private T[][] elems;

    public Matrix(int rows, int cols) {
        this.elems = (T[][]) new Object[rows][];
        for (int i=0; i< rows; i++)
            this.elems[i] = (T[]) new Object[cols];
    }

    public T get(int row, int col) {
        return elems[row][col];
    }
}
