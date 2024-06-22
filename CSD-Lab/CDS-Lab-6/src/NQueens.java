public class NQueens {
    static final int N = 4;

    // Hàm hiển thị kết quả bàn cờ
    static void showResult(int[][] b) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Hàm kiểm tra xem vị trí (row, col) có an toàn để đặt quân hậu hay không
    static boolean isOk(int[][] b, int row, int col) {
        int i, j;

        // Kiểm tra hàng ngang bên trái
        for (i = 0; i < col; i++) {
            if (b[row][i] == 1) {
                return false;
            }
        }

        // Kiểm tra đường chéo trên bên trái
        i = row; j = col;
        while(i >= 0 && j >= 0) {
            if (b[i][j] == 1) {
                return false;
            }
            i--;
            j--;
        }

        // Kiểm tra đường chéo dưới bên trái
        i = row; j = col;
        while(i < N && j >= 0) {
            if (b[i][j] == 1) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    // Hàm đặt quân hậu vào bàn cờ
    static boolean setQueen(int[][] b, int col) {
        // Nếu đã đặt đủ N quân hậu thì trả về true
        if (col >= N) {
            return true;
        }

        // Thử đặt quân hậu vào từng hàng của cột hiện tại
        for (int i = 0; i < N; i++) {
            if (isOk(b, i, col)) {
                b[i][col] = 1; // Đặt quân hậu
                // Đệ quy đặt quân hậu vào các cột tiếp theo
                if(setQueen(b, col + 1)) {
                    return true;
                }
                b[i][col] = 0; // Quay lui
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // NQueen backtracking
        int[][] b = new int[N][N]; // Khởi tạo bàn cờ với các ô đều bằng 0
        if (setQueen(b, 0)) {
            showResult(b); // Hiển thị kết quả nếu tìm được cách đặt
        } else {
            System.out.println("No solution!"); // Không tìm được cách đặt
        }
    }
}
