import java.util.Scanner;

public class SudokuSolver {

    private static final int SIZE = 9;
    private static final String RESET = "\u001B[0m";  // Reset color
    private static final String GREEN = "\u001B[32m"; // Solver-filled numbers
    private static final String WHITE = "\u001B[37m"; // Original puzzle numbers

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] board = new int[SIZE][SIZE];
        boolean[][] isOriginal = new boolean[SIZE][SIZE]; // Track original cells

        System.out.println("Enter the Sudoku puzzle (0 for empty cells):");
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                int num = readValidNumber(sc, row, col);
                board[row][col] = num;
                if (num != 0) {
                    isOriginal[row][col] = true;
                }
            }
        }

        System.out.println("\nSudoku Puzzle:");
        printBoard(board, isOriginal);

        if (solveSudoku(board)) {
            System.out.println("\nSolved Sudoku:");
            printBoard(board, isOriginal);
        } else {
            System.out.println("No solution exists for this puzzle.");
        }

        sc.close();
    }

    // Reads a valid number from 0–9
    private static int readValidNumber(Scanner sc, int row, int col) {
        int num;
        while (true) {
            System.out.printf("Enter value for cell (%d,%d) [0-9]: ", row + 1, col + 1);
            if (sc.hasNextInt()) {
                num = sc.nextInt();
                if (num >= 0 && num <= 9) {
                    return num;
                } else {
                    System.out.println("❌ Invalid! Please enter a number between 0 and 9.");
                }
            } else {
                System.out.println("❌ Invalid input! Please enter a number.");
                sc.next(); // clear invalid input
            }
        }
    }

    private static boolean solveSudoku(int[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == 0) {
                    for (int num = 1; num <= SIZE; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;
                            if (solveSudoku(board)) {
                                return true;
                            }
                            board[row][col] = 0; // Backtrack
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(int[][] board, int row, int col, int num) {
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }

        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (board[startRow + r][startCol + c] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void printBoard(int[][] board, boolean[][] isOriginal) {
        for (int r = 0; r < SIZE; r++) {
            if (r % 3 == 0 && r != 0) {
                System.out.println("------+-------+------");
            }
            for (int c = 0; c < SIZE; c++) {
                if (c % 3 == 0 && c != 0) {
                    System.out.print("| ");
                }
                if (board[r][c] == 0) {
                    System.out.print(". ");
                } else {
                    if (isOriginal[r][c]) {
                        System.out.print(WHITE + board[r][c] + " " + RESET);
                    } else {
                        System.out.print(GREEN + board[r][c] + " " + RESET);
                    }
                }
            }
            System.out.println();
        }
    }
}
