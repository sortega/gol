package gol;

public class Cell {
    private final boolean alive;

    public Cell(boolean alive) {
        this.alive = alive;
    }

    public boolean isAlive() {
        return alive;
    }

    public void addNeightbour(Cell aliveNeightbour) {
    }

    public Cell next() {
        return null;
    }

}
