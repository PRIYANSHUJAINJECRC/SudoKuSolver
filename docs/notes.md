
---

## 📄 `docs/design_notes.md`

```markdown
# 📝 Design Notes – Sudoku Solver

## 🔢 Algorithm – Backtracking
- The solver uses **backtracking**, a depth-first search (DFS) technique.
- Steps:
  1. Find the first empty cell.
  2. Attempt to insert numbers 1–9.
  3. Validate placement:
     - Check row
     - Check column
     - Check 3×3 subgrid
  4. If valid → move to next empty cell.
  5. If invalid → backtrack to the previous cell and try the next number.
  6. Continue until puzzle is solved or no solution exists.

✅ Advantages:
- Guarantees a solution if one exists.
- Simple and intuitive to implement.

⚠️ Limitations:
- Performance decreases for very complex or invalid puzzles.
- Doesn’t handle multiple-solution cases explicitly (stops at first valid solution).

---

## 🎨 GUI – Java Swing
- Implemented using **Java Swing**.
- Components:
  - `JFrame` → Main window
  - `JPanel` + `GridLayout` → Sudoku grid
  - `JTextField` → User input for each cell
  - `JButton` → "Solve" and "Reset" buttons
  - `JLabel` → Status messages

- The GUI interacts directly with the solver:
  - Reads user input
  - Passes board state to `SudokuSolver`
  - Updates grid after solving

---

## 🏗️ Code Organization
- `Main.java` → Entry point, launches GUI
- `SudokuSolver.java` → Core backtracking algorithm
- `SudokuGUI.java` → Handles all GUI logic
- `Utils.java` → Helper methods (e.g., validation, board formatting)

---

## 📌 Future Improvements
- Add **difficulty level generator** (Easy, Medium, Hard puzzles).
- Add **timer and score system** for gameplay mode.
- Add **step-by-step visualization** of backtracking process.
- Improve UI with colors & themes.
- Optimize solver using constraint propagation techniques.
