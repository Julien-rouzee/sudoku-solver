
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class testSudokuSolver {

int[][] solvedBoard= {
            { 8, 1, 2, 7, 5, 3, 6, 4, 9},
            { 9, 4, 3, 6, 8, 2, 1, 7, 5},
            { 6, 7, 5, 4, 9, 1, 2, 8, 3},
            { 1, 5, 4, 2, 3, 7, 8, 9, 6},
            { 3, 6, 9, 8, 4, 5, 7, 2, 1},
            { 2, 8, 7, 1, 6, 9, 5, 3, 4},
            { 5, 2, 1, 9, 7, 4, 3, 6, 8},
            { 4, 3, 8, 5, 2, 6, 9, 1, 7},
            { 7, 9, 6, 3, 1, 8, 4, 5, 2}

},   unsolvedBoard= {
        { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
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
    public void allPossibleNumbersAreInRow() {
        Sudoku sudo = new Sudoku(solvedBoard);
        for (int i = 0; i < 9; i++) {
            for (int j=0;j<9;j++)
               assertTrue(sudo.isInRow(i,solvedBoard[i][j]));
        }

    }

   @Test
    public void allPossibleNumbersAreNotInRow() {
        Sudoku sudo = new Sudoku(unsolvedBoard);
        boolean bool=true;

        for (int i = 0; i < 9; i++) {
            for (int j=0;j<9;j++)
               {bool=sudo.isInRow(i, unsolvedBoard[i][j]);
                   System.out.print(bool); }
        }

    }









