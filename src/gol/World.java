package gol;

public class World {
    private Cell[][] cells;
    private final int generation;

    public World(int generation, char[][] matrix) {
        this.generation = generation;
        createCells(matrix);
        wireCells();
    }

    private void createCells(char[][] matrix) {
        this.cells = new Cell[matrix.length][];
        for (int i=0; i < matrix.length; i++) {
            this.cells[i] = new Cell[matrix[i].length];
            for (int j=0; j < matrix.length; j++) {
                cells[i][j] = new Cell(matrix[i][j] == '*');
            }
        }
    }

    private void wireCells() {
        for (int i=0; i < cells.length; i++)
            for (int j=0; j < cells.length; j++)
                wireCell(i, j);

    }

    private void wireCell(int i, int j) {
        for(int iOffset = -1; iOffset <= 1; iOffset++) {
            if (i+iOffset < 0 || i+iOffset >= cells.length) continue;

            for(int jOffset = -1; jOffset <= 1; jOffset++) {
                if (j+jOffset < 0 || j+jOffset >= cells[i].length)  continue;
                if (cells[i][j] != cells[i+iOffset][j+jOffset])
                    cells[i][j].addNeightbour(cells[i+iOffset][j+jOffset]);
            }
        }
    }

    private World(int generation, Cell[][] cells) {
        this.generation = generation;
        this.cells = cells;
    }

    public char[][] getMatrix() {
        char[][] matrix = new char[cells.length][];
        for (int i=0; i < cells.length; i++) {
            matrix[i] = new char[cells[i].length];
            for (int j=0; j < cells.length; j++) {
                matrix[i][j] = (cells[i][j].isAlive() ? '*' : '.');
            }
        }
        return matrix;
    }

    public World next() {
        Cell[][] nextCells = new Cell[cells.length][];
        for (int i=0; i < cells.length; i++) {
            nextCells[i] = new Cell[cells[i].length];
            for (int j=0; j < cells.length; j++) {
                nextCells[i][j] = this.cells[i][j].next();
            }
        }

        return new World(generation + 1, nextCells);
    }
}
