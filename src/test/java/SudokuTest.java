import me.sudoku.Cell;
import me.sudoku.Solver;
import org.junit.Test;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.Assert.*;

public class SudokuTest {
    int[][] board = {
            { 8, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 3, 6, 0, 0, 0, 0, 0 },
            { 0, 7, 0, 0, 9, 0, 2, 0, 0 },
            { 0, 5, 0, 0, 0, 7, 0, 0, 0 },
            { 0, 0, 0, 0, 4, 5, 7, 0, 0 },
            { 0, 0, 0, 1, 0, 0, 0, 3, 0 },
            { 0, 0, 1, 0, 0, 0, 0, 6, 8 },
            { 0, 0, 8, 5, 0, 0, 0, 1, 0 },
            { 0, 9, 0, 0, 0, 0, 4, 0, 0 }
    };
    @Test
    public void number_is_in_line(){
        Solver solver = new Solver(board);
        for (int i = 0; i<100; i++){
            assertTrue(solver.numberIsInLine(0, 8));
            assertTrue(solver.numberIsInLine(1, 3));
            assertTrue(solver.numberIsInLine(1, 6));
        }
    }
    @Test
    public void number_is_in_col(){
        Solver solver = new Solver(board);
        for (int i = 0; i<100; i++){
            assertTrue(solver.numberIsInCol(0, 8));
            assertTrue(solver.numberIsInCol(1, 7));
            assertTrue(solver.numberIsInCol(1, 5));
        }
    }
}
