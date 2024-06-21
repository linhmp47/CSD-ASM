import java.util.Scanner;

class SimpleSort {
    int[] a;  // Mảng để chứa các phần tử cần sắp xếp
    int n;    // Số lượng phần tử trong mảng

    // Constructor mặc định
    SimpleSort() {}

    // Constructor có tham số để khởi tạo mảng với các phần tử
    SimpleSort(int[] b) {
        n = b.length;  // Đặt kích thước của mảng
        a = new int[n];  // Tạo một mảng mới với kích thước n
        for (int i = 0; i < n; i++) {
            a[i] = b[i];  // Sao chép các phần tử từ mảng đầu vào b vào a
        }
    }

    // Phương thức để hiển thị các phần tử của mảng
    void display() {
        for (int i = 0; i < n; i++) {
            System.out.print("  " + a[i]);  // In từng phần tử kèm theo khoảng trắng
        }
        System.out.println();  // Chuyển sang dòng mới sau khi in hết các phần tử
    }

    // Phương thức để hoán đổi hai phần tử trong mảng
    void swap(int i, int k) {
        int x = a[i];  // Lưu giá trị của a[i] vào biến tạm thời x
        a[i] = a[k];  // Gán giá trị của a[k] cho a[i]
        a[k] = x;  // Gán giá trị của x cho a[k]
    }

    // Phương thức để thực hiện sắp xếp nổi bọt trên mảng
    void bubbleSort() {
        for (int i = 0; i < n - 1; i++) {  // Lặp qua từng phần tử trừ phần tử cuối cùng
            for (int j = 0; j < n - i - 1; j++) {  // Lặp để so sánh các phần tử liền kề
                if (a[j] > a[j + 1]) {  // Nếu phần tử hiện tại lớn hơn phần tử kế tiếp
                    swap(j, j + 1);  // Hoán đổi các phần tử
                }
            }
            display();  // Hiển thị mảng sau mỗi lần lặp của vòng lặp ngoài
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Tạo đối tượng Scanner để nhập liệu

        System.out.print("n = ");  // Hiển thị yêu cầu người dùng nhập số lượng phần tử
        int n = scanner.nextInt();  // Đọc số lượng phần tử

        int[] array = new int[n];  // Tạo mảng với kích thước đã nhập
        System.out.print("a[] = ");  // Hiển thị yêu cầu người dùng nhập các phần tử
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();  // Đọc từng phần tử vào mảng
        }

        SimpleSort sorter = new SimpleSort(array);  // Tạo đối tượng SimpleSort với mảng đầu vào
        sorter.bubbleSort();  // Thực hiện sắp xếp nổi bọt trên mảng và hiển thị mảng đã sắp xếp sau mỗi lần lặp
    }
}
