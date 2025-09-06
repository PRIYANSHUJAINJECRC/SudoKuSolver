/**
 * Main.java
 *
 * Entry point of the program.
 * Simply launches the SudokuSolverGUI.
 */

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SudokuSolverGUI());
    }
}
