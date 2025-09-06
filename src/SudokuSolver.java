/**
 * SudokuSolver.java
 *
 * This class contains the logic for solving Sudoku using backtracking.
 * It can be tested independently without the GUI.
 */
public class SudokuSolver {

    /**
     * Solve the Sudoku puzzle using backtracking
     * @param board 9x9 Sudoku grid
     * @return true if solved, false otherwise
     */
    public boolean solve(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {  // Empty cell
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;

                            if (solve(board)) {
                                return true;
                            }

                            board[row][col] = 0; // Backtrack
                        }
                    }
                    return false; // No valid number found
                }
            }
        }
        return true; // Solved
    }

    /**
     * Check if placing a number is valid at given row & col
     * @param board Sudoku grid
     * @param row row index
     * @param col column index
     * @param num number to check
     * @return true if valid, false otherwise
     */
    public boolean isValid(int[][] board, int row, int col, int num) {
        // Row & Column check
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }

        // 3x3 subgrid check
        int startRow = row - row % 3, startCol = col - col % 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}
