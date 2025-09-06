# 🧩 Sudoku Solver (Java + Backtracking + GUI)

## 📌 Overview
This project is a **Sudoku Solver** built in **Java** with a **Graphical User Interface (GUI)**.  
It uses the **backtracking algorithm** to solve Sudoku puzzles and allows users to **input numbers directly into the grid**.

### ✨ Features
- ✅ Solve any valid Sudoku puzzle
- ✅ Interactive GUI (Java Swing)
- ✅ Backtracking algorithm for efficient solving
- ✅ Input validation (row, column, and 3x3 grid checks)
- ✅ Reset / Clear board functionality
- ✅ Simple and lightweight – runs on any system with Java installed

---

## 📂 Project Structure
sudoku-solver/
│── README.md
│── LICENSE
│── .gitignore
│── src/
│ ├── Main.java # Entry point
│ ├── SudokuSolver.java # Backtracking algorithm
│ ├── SudokuGUI.java # GUI implementation (Java Swing)
│
├── assets/
│ ├── screenshot.png # GUI screenshot
│
└── docs/
├── usage.md # Detailed usage guide
└── design_notes.md # Notes about design & algorithm


---

## 🚀 Getting Started

### 1️⃣ Prerequisites
- Install **Java 8 or above**
- IDE (IntelliJ, Eclipse, or VS Code with Java extension) OR plain terminal

### 2️⃣ Compile and Run
Using terminal:
```bash
javac -d bin src/*.java
java -cp bin Main
📊 Screenshots

<img width="599" height="666" alt="Screenshot 2025-09-06 113655" src="https://github.com/user-attachments/assets/723c5950-f00a-4ab2-8b37-306d6ee08de2" />
⚙️ How It Works
🔢 Algorithm (Backtracking)

Find the first empty cell.

Try placing digits 1-9.

Check if the number is valid in:

Row

Column

3x3 subgrid

If valid → move to next empty cell.

If invalid → backtrack and try another number.

Continue until the board is solved.

🎨 GUI

Implemented using Java Swing.

Provides an interactive grid where users can:

Enter numbers manually

Click "Solve" to fill in the solution

Reset / Clear the board

📜 License

This project is licensed under the MIT License – see the LICENSE
 file for details.
👨‍💻 Author

Priyanshu Jain
📧 jpriyanshu87@gmail.com
