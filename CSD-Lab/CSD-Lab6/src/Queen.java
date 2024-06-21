import java.util.Scanner;

public class Queen {
    int n, count;
    boolean[] a, b, c;
    int[] x;
    Scanner in;

    public Queen() {
        x = new int[20];
        a = new boolean[20];
        b = new boolean[40];
        c = new boolean[40];
        in = new Scanner(System.in);
    }

    // Initialize the board
    void init() {
        int i;
        System.out.print(" n = ");
        n = in.nextInt();
        count = 0;
        for (i = 1; i <= n; i++)
            a[i] = true;
        for (i = 1; i <= 2 * n - 1; i++)
            b[i] = true;
        for (i = 1; i <= 2 * n - 1; i++)
            c[i] = true;
    }

    // Display a solution
    void result() {
        int i;
        System.out.printf("\n%3d: ", ++count);
        for (i = 1; i <= n; i++)
            System.out.printf("%4d", x[i]);
    }

    // Check if a queen can be placed at (row, col)
    boolean isSafe(int row, int col) {
        return a[col] && b[row + col] && c[row - col + n - 1];
    }

    // Place a queen at (row, col)
    void place(int row, int col) {
        a[col] = false;
        b[row + col] = false;
        c[row - col + n - 1] = false;
        x[row] = col;
    }

    // Remove a queen from (row, col)
    void remove(int row, int col) {
        a[col] = true;
        b[row + col] = true;
        c[row - col + n - 1] = true;
    }

    // Solve N-Queens problem using backtracking
    void test(int row) {
        if (row == n) {
            result();
            return;
        }

        for (int col = 1; col <= n; col++) {
            if (isSafe(row, col)) {
                place(row, col);
                test(row + 1);
                remove(row, col);
            }
        }
    }
}