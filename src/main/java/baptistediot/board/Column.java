package baptistediot.board;

import java.util.ArrayList;

public class Column {
    public ArrayList<Cell> column;

    public Column() {
        this.column = new ArrayList<>();
    }

    public void add(Cell cell) {
        column.add(cell);
    }
}
