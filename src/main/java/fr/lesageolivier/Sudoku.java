package fr.lesageolivier;

public class Sudoku {
    /**
     * Taille de la grille
     */
    public static final int SIZE = 9;

    /**
     * Tableau contenant le Sudoku
     */
    private Cell[][] board;

    /**
     * Constructeur
     *
     * @param board Tableau contenant les valeur de la grille de jeu
     */
    public Sudoku(int[][] board) {
        this.board = new Cell[SIZE][];

        for (int i = 0; i < SIZE; ++i) {
            this.board[i] = new Cell[SIZE];

            for (int j = 0; j < SIZE; ++j)
                this.board[i][j] = new Cell(board[i][j]);
        }
        this.show();
    }

    /**
     * Méthode permettant de savoir si un nombre est dans une ligne
     *
     * @param row    Le numéro de la ligne
     * @param cell La case dont on veut connaitre la présence
     * @return true si le nombre est présent dans la ligne, false sinon
     */
    private boolean isInRow(int row, Cell cell) {
        for (int i = 0; i < SIZE; i++)
            if (board[row][i].equals(cell))
                return true;

        return false;
    }

    /**
     * Méthode permettant de savoir si un nombre est dans une colonne
     *
     * @param col    Le numéro de la colonne
     * @param cell La case dont on veut connaitre la présence
     * @return true si le nombre est présent dans la colonne, false sinon
     */
    private boolean isInCol(int col, Cell cell) {
        for (int i = 0; i < SIZE; i++)
            if (board[i][col].equals(cell))
                return true;

        return false;
    }

    /**
     * Méthode permettant de savoir si un élément est dans un 3x3
     *
     * @param row    Ligne appartenant au 3x3
     * @param col    Colonne appartenant au 3x3
     * @param cell La case dont on veut connaitre la présence
     * @return true si le nombre est présent dans le 3x3, false sinon
     */
    private boolean isInSub3x3(int row, int col, Cell cell) {
        int r = row - row % 3;
        int c = col - col % 3;

        for (int i = r; i < r + 3; i++)
            for (int j = c; j < c + 3; j++)
                if (board[i][j].equals(cell))
                    return true;

        return false;
    }

    /**
     * Méthode permettant de savoir si un nombre placé dans la case désignée
     *
     * @param row    Ligne dans laquelle on veut placer le nombre
     * @param col    Colonne dans laquelle on veut placer le nombre
     * @param cell La case que l'on veut placer
     * @return true si le nombre peut être placer dans la case désignée, false sinon
     */
    private boolean canBeHere(int row, int col, Cell cell) {
        return !isInRow(row, cell) && !isInCol(col, cell) && !isInSub3x3(row, col, cell);
    }

    /**
     * Méthode permettant de résoudre la grille
     *
     * @return true si la grill est résolue, false sinon
     */
    public boolean solve() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col].isEmpty()) {
                    for (Cell cell = new Cell(1); cell.getValue() <= SIZE; cell.increment()) {
                        if (canBeHere(row, col, cell)) {
                            board[row][col] = new Cell(cell);

                            if (solve()) {
                                return true;
                            } else {
                                board[row][col].setValue(Cell.EMPTY);
                            }
                        }
                    }

                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Méthode permettant d'afficher la grille
     */
    public void show() {
        for (Cell[] line : this.board) {
            for (Cell cell : line) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }
}
