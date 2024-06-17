
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    // Đối tượng Scanner để nhận đầu vào từ người dùng
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Tạo một đối tượng của lớp Algorithm
        Algorithm a = new Algorithm();
        // Mảng để chứa các giá trị kiểu float
        Float[] f = null;

        // Tạo các tệp tin
        String[] fileNames = {"INPUT.txt", "OUTPUT1.txt", "OUTPUT2.txt", "OUTPUT3.txt", "OUTPUT4.txt", "OUTPUT5.txt"};
        File[] files = new File[fileNames.length];

        // Vòng lặp để tạo các tệp tin nếu chúng chưa tồn tại
        for (int i = 0; i < fileNames.length; i++) {
            files[i] = new File(fileNames[i]);
            if (!files[i].exists()) {
                try {
                    files[i].createNewFile(); // Tạo tệp mới
                } catch (IOException e) {
                    System.out.println("Error creating file: " + files[i].getName() + " - " + e.getMessage());
                }
            }
        }

        int choice;

        // Vòng lặp để hiển thị menu và nhận lựa chọn của người dùng cho đến khi họ chọn thoát
        do {
            showMenu();
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    // Khởi tạo mảng và ghi vào tệp đầu vào
                    f = init();
                    a.writeFile(fileNames[0], f);
                    break;
                case 2:
                    // Đọc mảng từ tệp đầu vào và hiển thị nó
                    f = a.readFile(fileNames[0]);
                    System.out.println("Read array: " + Arrays.toString(f));
                    break;
                case 3:
                    // Thực hiện sắp xếp nổi bọt nếu mảng đã được khởi tạo, sau đó ghi vào tệp đầu ra
                    if (f != null) {
                        f = a.readFile(fileNames[0]);
                        System.out.println("BubbleSort ");
//                        System.out.println("Current array: " + Arrays.toString(f));
                        System.out.println(Arrays.toString(f));
                        Float[] sortedBubble = a.bubbleSort(f);
//                        System.out.println("Sorted array: " + Arrays.toString(sortedBubble));
                        a.writeFile(fileNames[1], sortedBubble);
                    } else {
                        System.out.println("Please initialize the array first.");
                    }
                    break;
                case 4:
                    // Thực hiện sắp xếp chọn nếu mảng đã được khởi tạo, sau đó ghi vào tệp đầu ra
                    if (f != null) {
                        f = a.readFile(fileNames[0]);
                        System.out.println("SelectionSort ");
//                        System.out.println("Current array: " + Arrays.toString(f));
                        System.out.println(Arrays.toString(f));
                        Float[] sortedSelection = a.selectionSort(f);
//                        System.out.println("Sorted array: " + Arrays.toString(sortedSelection));
                        a.writeFile(fileNames[2], sortedSelection);
                    } else {
                        System.out.println("Please initialize the array first.");
                    }
                    break;
                case 5:
                    // Thực hiện sắp xếp chèn nếu mảng đã được khởi tạo, sau đó ghi vào tệp đầu ra
                    if (f != null) {
                        f = a.readFile(fileNames[0]);
                        System.out.println("InsertionSort");
//                        System.out.println("Current array: " + Arrays.toString(f));
                        System.out.println(Arrays.toString(f));
                        Float[] sortedInsertion = a.insertionSort(f);
//                        System.out.println("Sorted array: " + Arrays.toString(sortedInsertion));
                        a.writeFile(fileNames[3], sortedInsertion);
                    } else {
                        System.out.println("Please initialize the array first.");
                    }
                    break;
                case 6:
                    // Thực hiện tìm kiếm tuyến tính nếu mảng đã được khởi tạo, sau đó ghi kết quả vào tệp đầu ra
                    if (f != null) {
                        System.out.println("Search value: ");
                        Float value = sc.nextFloat();
                        Float[] linearSearchResult = a.linearSearch(f, value);
                        a.writeFile(fileNames[4], linearSearchResult);
                        System.out.println("Search results: " + Arrays.toString(linearSearchResult));
                    } else {
                        System.out.println("Please initialize the array first.");
                    }
                    break;
                case 7:
                    // Thực hiện tìm kiếm nhị phân nếu mảng đã được khởi tạo, sau đó ghi kết quả vào tệp đầu ra
                    if (f != null) {
                        System.out.println("Search value: ");
                        Float value1 = sc.nextFloat();
                        int result = a.binarySearch(f, 0, f.length - 1, value1);
                        if (result == -1) {
                            System.out.println("No result found");
                        } else {
                            System.out.println("Value's index found: [" + result + "]");
                            try (BufferedWriter out = new BufferedWriter(new FileWriter(fileNames[5]))) {
                                out.write(String.valueOf(result));
                            } catch (IOException e) {
                                System.out.println("Error writing to file: " + e.getMessage());
                            }
                        }
                    } else {
                        System.out.println("Please initialize the array first.");
                    }
                    break;

                case 0:
                    // Thoát chương trình
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (choice != 0);
        sc.close();
    }

    // Hiển thị menu
    private static void showMenu() {
        System.out.println("What do you want to do? ");
        System.out.println("1. Write");
        System.out.println("2. Read");
        System.out.println("3. BubbleSort");
        System.out.println("4. SelectionSort");
        System.out.println("5. InsertionSort");
        System.out.println("6. LinearSearch");
        System.out.println("7. BinarySearch");
        System.out.println("0. Exit");
        System.out.println("Your choice: ");
    }

    // Khởi tạo mảng
    private static Float[] init() {
        System.out.println("Input number of elements: ");
        int n = sc.nextInt();

        // Kiểm tra n có thỏa mãn điều kiện n <= 20 không
        while (n > 20 || n <= 0) {
            System.out.println("Invalid input. Number of elements must be between 1 and 20. Please input again: ");
            n = sc.nextInt();
        }

        Float[] f = new Float[n];
        for (int i = 0; i < n; i++) {
            System.out.printf("a[%d] = ", i);
            f[i] = sc.nextFloat();
        }
        return f;
    }
}
