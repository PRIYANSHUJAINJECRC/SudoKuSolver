/**
 * SudokuSolverGUI.java
 *
 * This class handles the GUI for the Sudoku solver using Swing.
 * It interacts with SudokuSolver.java to solve the puzzle.
 */

import javax.swing.*;
import java.awt.*;

public class SudokuSolverGUI extends JFrame {
    private JTextField[][] cells = new JTextField[9][9]; // 9x9 Sudoku grid
    private JButton solveButton, clearButton;
    private SudokuSolver solver = new SudokuSolver(); // Logic class object

    public SudokuSolverGUI() {
        setTitle("Sudoku Solver");
        setSize(500, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel for Sudoku grid
        JPanel gridPanel = new JPanel(new GridLayout(9, 9));
        Font font = new Font("Arial", Font.BOLD, 20);

        // Create 9x9 input cells
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                JTextField cell = new JTextField();
                cell.setHorizontalAlignment(JTextField.CENTER);
                cell.setFont(font);

                // Borders for 3x3 subgrids
                int top = (row % 3 == 0) ? 3 : 1;
                int left = (col % 3 == 0) ? 3 : 1;
                int bottom = (row == 8) ? 3 : 1;
                int right = (col == 8) ? 3 : 1;
                cell.setBorder(BorderFactory.createMatteBorder(top, left, bottom, right, Color.BLACK));

                cells[row][col] = cell;
                gridPanel.add(cell);
            }
        }

        // Buttons panel
        JPanel buttonPanel = new JPanel();
        solveButton = new JButton("Solve");
        clearButton = new JButton("Clear");

        // Button Actions
        solveButton.addActionListener(e -> solveSudoku());
        clearButton.addActionListener(e -> clearGrid());

        buttonPanel.add(solveButton);
        buttonPanel.add(clearButton);

        // Add panels to frame
        add(gridPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    /**
     * Extract Sudoku numbers from GUI into a 2D array
     */
    private int[][] getBoard() {
        int[][] board = new int[9][9];
        try {
            for (int row = 0; row < 9; row++) {
                for (int col = 0; col < 9; col++) {
                    String text = cells[row][col].getText();
                    if (text.isEmpty()) {
                        board[row][col] = 0;
                    } else {
                        int num = Integer.parseInt(text);
                        if (num < 1 || num > 9) {
                            JOptionPane.showMessageDialog(this, "Enter numbers 1-9 only.");
                            return null;
                        }
                        board[row][col] = num;
                    }
                }
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input! Only numbers allowed.");
            return null;
        }
        return board;
    }

    /**
     * Update GUI cells with solved Sudoku board
     */
    private void setBoard(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                cells[row][col].setText(board[row][col] == 0 ? "" : String.valueOf(board[row][col]));
            }
        }
    }

    /**
     * Action for Solve button
     */
    private void solveSudoku() {
        int[][] board = getBoard();
        if (board == null) return;

        if (solver.solve(board)) {
            setBoard(board);
        } else {
            JOptionPane.showMessageDialog(this, "No solution exists!");
        }
    }

    /**
     * Action for Clear button
     */
    private void clearGrid() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                cells[row][col].setText("");
            }
        }
    }
}
