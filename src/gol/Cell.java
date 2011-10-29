package gol;

import java.util.LinkedList;
import java.util.List;

public class Cell {
    private final boolean alive;
    private final List<Cell> neightbours;

    public Cell(boolean alive) {
        this.alive = alive;
        this.neightbours = new LinkedList<Cell>();
    }

    public boolean isAlive() {
        return alive;
    }

    public void addNeightbour(Cell neightbour) {
        this.neightbours.add(neightbour);
    }

    public Cell next() {
        int alives = this.aliveNeightbours();
        return new Cell(
                alives >= 2 &&
                alives <= 3);
    }

    private int aliveNeightbours() {
        int numAlive = 0;
        for(Cell c : neightbours)
            if (c.isAlive())
                numAlive++;
        return numAlive;
    }

}
