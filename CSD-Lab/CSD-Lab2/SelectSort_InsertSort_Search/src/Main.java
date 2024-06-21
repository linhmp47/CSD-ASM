import java.util.Scanner;

class SimpleSort {
    // Phương thức để hiển thị các phần tử của mảng
    void display(int[] a) {
        for (int i = 0; i < a.length; i++)
            System.out.print("  " + a[i]);
        System.out.println();
    }

    // Phương thức để hoán đổi hai phần tử trong mảng
    void swap(int[] a, int i, int k) {
        int x = a[i];
        a[i] = a[k];
        a[k] = x;
    }

    // Phương thức sắp xếp bằng phương pháp lựa chọn
    void selectSort(int[] a) {
        int n = a.length;
        int[] b = new int[n];
        for (int i = 0; i < n; i++) b[i] = a[i];

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (b[j] < b[minIndex]) {
                    minIndex = j;
                }
            }
            swap(b, i, minIndex);
        }

        // Hiển thị kết quả sắp xếp
        display(b);
    }

    // Phương thức sắp xếp bằng phương pháp chèn
    void insertSort(int[] a) {
        int n = a.length;
        int[] b = new int[n];
        for (int i = 0; i < n; i++) b[i] = a[i];

        for (int i = 1; i < n; i++) {
            int key = b[i];
            int j = i - 1;
            while (j >= 0 && b[j] > key) {
                b[j + 1] = b[j];
                j = j - 1;
            }
            b[j + 1] = key;
        }

        // Hiển thị kết quả sắp xếp
        display(b);
    }

    // Phương thức tìm kiếm tuyến tính
    int search(int[] a, int value) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == value) {
                return i;
            }
        }
        return -1; // Trả về -1 nếu không tìm thấy giá trị
    }

    // Lớp chính để chạy chương trình
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n, choice;
        int[] a = {5, 7, 11, 3, 9, 2, 6};
        SimpleSort t = new SimpleSort();

        while (true) {
            System.out.println("\nChọn tùy chọn của bạn:");
            System.out.println("  1. Hiển thị dữ liệu");
            System.out.println("  2. Sắp xếp lựa chọn");
            System.out.println("  3. Sắp xếp chèn");
            System.out.println("  4. Tìm kiếm");
            System.out.println("  0. Thoát\n");
            System.out.print("  Lựa chọn của bạn (0 -> 4): ");
            choice = s.nextInt();
            if (choice == 0) {
                System.out.println("Tạm biệt, chúc bạn một ngày tốt lành!");
                break;
            }
            switch (choice) {
                case 1:
                    t.display(a);
                    break;
                case 2:
                    t.selectSort(a);
                    break;
                case 3:
                    t.insertSort(a);
                    break;
                case 4:
                    System.out.print("Nhập giá trị cần tìm: ");
                    int value = s.nextInt();
                    int result = t.search(a, value);
                    if (result != -1) {
                        System.out.println("Giá trị " + value + " được tìm thấy tại vị trí: " + result);
                    } else {
                        System.out.println("Giá trị " + value + " không tồn tại trong mảng.");
                    }
                    break;
                default:
                    System.out.println("**Lựa chọn không hợp lệ. Thử lại.**");
            }
        }
        s.close();
    }
}
