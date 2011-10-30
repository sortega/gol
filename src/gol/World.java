package gol;

import gol.Matrix.Transformation;

public class World {
    private Matrix<Cell> cells;
    private final int generation;

    public World(int generation, Matrix<Character> matrix) {
        this.generation = generation;
        createCells(matrix);
        wireCells();
    }

    private World(Matrix<Cell> cells, int generation) {
        this.generation = generation;
        this.cells = cells;
    }

    private void createCells(Matrix<Character> matrix) {
        this.cells = matrix.map(new Transformation<Character, Cell> () {
            @Override
            public Cell transform(Character value) {
                return new Cell(value.equals('*'));
            }
        });
    }

    private void wireCells() {
        for (int i=0; i < cells.rows(); i++)
            for (int j=0; j < cells.cols(); j++)
                wireCell(i, j);
    }

    private void wireCell(int i, int j) {
        Cell cell = cells.get(i, j);
        for(int iOffset = -1; iOffset <= 1; iOffset++) {
            if (i+iOffset < 0 || i+iOffset >= cells.rows()) continue;

            for(int jOffset = -1; jOffset <= 1; jOffset++) {
                if (j+jOffset < 0 || j+jOffset >= cells.cols())  continue;

                Cell neightbourg = cells.get(i+iOffset, j+jOffset);
                if (cell != neightbourg) {
                    cells.get(i, j).addNeightbour(neightbourg);
                }
            }
        }
    }

    public Matrix<Character> getMatrix() {
        return cells.map(new Transformation<Cell, Character>() {
            @Override
            public Character transform(Cell cell) {
                return (cell.isAlive() ? '*' : '.');
            }
        });
    }

    public World next() {
        Matrix<Cell> nextCells = cells.map(new Transformation<Cell, Cell>() {
            @Override
            public Cell transform(Cell value) {
                return value.next();
            }
        });
        return new World(nextCells, generation + 1);
    }

    public int getGeneration() {
        return generation;
    }
}
