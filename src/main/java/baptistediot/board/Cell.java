package baptistediot.board;

public class Cell {
    public int value;

    public Cell(int value){
        this.value = value;
    }

    public String toString(){
        return String.valueOf(value);
    }

    public int getValue(){
        return value;
    }

}
