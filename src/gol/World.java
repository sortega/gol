package gol;

public class World {
    private Cell[][] cells;

    public World(char[][] matrix) {
        this.cells = new Cell[matrix.length][];
        for (int i=0; i < matrix.length; i++) {
            this.cells[i] = new Cell[matrix[i].length];
            for (int j=0; j < matrix.length; j++) {
                cells[i][j] = new Cell(matrix[i][j] == '*');
            }
        }
    }

    private World(Cell[][] cells) {
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

        return new World(nextCells);
    }
}
