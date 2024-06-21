public class Main {
    public static void main(String[] args) {
        Queen queen = new Queen();
        queen.init();
        queen.test(1);
    }
}

//public class NQueens {
//
//    int n;
//    boolean[] colUsed;
//    boolean[] diagUsedLeft;
//    boolean[] diagUsedRight;
//    int[][] solutions;
//    int solutionCount = 0;
//
//    public NQueens(int n) {
//        this.n = n;
//        colUsed = new boolean[n];
//        diagUsedLeft = new boolean[2 * n - 1];
//        diagUsedRight = new boolean[2 * n - 1];
//        solutions = new int[n][n]; // Array to store solutions
//    }
//
//    // Check if a queen can be placed at (row, col)
//    private boolean isSafe(int row, int col) {
//        return !colUsed[col] && !diagUsedLeft[row + col] && !diagUsedRight[row - col + n - 1];
//    }
//
//    // Place a queen at (row, col)
//    private void placeQueen(int row, int col) {
//        colUsed[col] = true;
//        diagUsedLeft[row + col] = true;
//        diagUsedRight[row - col + n - 1] = true;
//        solutions[row][col] = 1;
//    }
//
//    // Remove a queen from (row, col)
//    private void removeQueen(int row, int col) {
//        colUsed[col] = false;
//        diagUsedLeft[row + col] = false;
//        diagUsedRight[row - col + n - 1] = false;
//        solutions[row][col] = 0;
//    }
//
//    // Solve N-Queens problem using backtracking
//    private void solveNQueens(int row) {
//        if (row == n) {
//            // Found a solution
//            for (int[] solution : solutions) {
//                for (int value : solution) {
//                    System.out.print(value + " ");
//                }
//                System.out.println();
//            }
//            solutionCount++;
//            return;
//        }
//
//        for (int col = 0; col < n; col++) {
//            if (isSafe(row, col)) {
//                placeQueen(row, col);
//                solveNQueens(row + 1);
//                removeQueen(row, col);
//            }
//        }
//    }
//
//    public void findSolutions() {
//        solveNQueens(0);
//        if (solutionCount == 0) {
//            System.out.println("No solutions found!");
//        }
//    }
//
//    public static void main(String[] args) {
//        int n = 4; // Change n for different board sizes
//        NQueens queens = new NQueens(n);
//        queens.findSolutions();
//    }
//}