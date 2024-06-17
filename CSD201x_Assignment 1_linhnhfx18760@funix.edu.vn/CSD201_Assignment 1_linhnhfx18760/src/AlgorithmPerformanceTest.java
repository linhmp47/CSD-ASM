import java.util.Random;

public class AlgorithmPerformanceTest {

    public static void main(String[] args) {
        Algorithm a = new Algorithm();
        int dataSize = 1000;

        // Tạo mảng dữ liệu ngẫu nhiên.
        Float[] randomData = generateRandomData(dataSize);

        // Tạo mảng dữ liệu đã sắp xếp.
        Float[] sortedData = generateSortedData(dataSize);

        //Tạo mảng dữ liệu sắp xếp theo thứ tự ngược lại.
        Float[] reversedData = generateReversedData(dataSize);

        System.out.println("Bubble Sort:");
        testAlgorithmPerformance(a::bubbleSort, randomData.clone(), "Random Data");
        testAlgorithmPerformance(a::bubbleSort, sortedData.clone(), "Sorted Data");
        testAlgorithmPerformance(a::bubbleSort, reversedData.clone(), "Reversed Data");

        System.out.println("\nSelection Sort:");
        testAlgorithmPerformance(a::selectionSort, randomData.clone(), "Random Data");
        testAlgorithmPerformance(a::selectionSort, sortedData.clone(), "Sorted Data");
        testAlgorithmPerformance(a::selectionSort, reversedData.clone(), "Reversed Data");

        System.out.println("\nInsertion Sort:");
        testAlgorithmPerformance(a::insertionSort, randomData.clone(), "Random Data");
        testAlgorithmPerformance(a::insertionSort, sortedData.clone(), "Sorted Data");
        testAlgorithmPerformance(a::insertionSort, reversedData.clone(), "Reversed Data");

        System.out.println("\n Nhận Xét Hiệu Năng\n" +
                "Dữ liệu sắp xếp theo thứ tự ngược lại: Thường là trường hợp tệ nhất cho\n" +
                " các thuật toán sắp xếp đơn giản như Bubble Sort và Insertion Sort.\n" +
                "\n" +
                "Dữ liệu đã được sắp xếp: Thường là trường hợp tốt nhất cho Insertion Sort và\n" +
                " có thể tốt cho các thuật toán khác nếu chúng có thể nhận ra rằng dữ liệu đã được sắp xếp.\n" +
                "\n" +
                "Dữ liệu có xáo trộn ngẫu nhiên: Cung cấp cái nhìn thực tế hơn về hiệu năng trung bình của các thuật toán. \n");
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println("Kết quả thực nghiệm và nhận xét\n" +
                "1. Bubble Sort\n" +
                "Dữ liệu ngẫu nhiên:\n" +
                "Thời gian chạy khá chậm so với Selection Sort và Insertion Sort.\n" +
                "Dữ liệu đã sắp xếp:\n" +
                "Thời gian chạy nhanh nhất trong ba trường hợp do Bubble Sort có thể dừng sớm khi không cần hoán đổi.\n" +
                "Dữ liệu ngược lại:\n" +
                "Thời gian chạy chậm nhất vì phải thực hiện tất cả các phép hoán đổi.\n" +
                "\n" +
                "2. Selection Sort\n" +
                "Dữ liệu ngẫu nhiên:\n" +
                "Thời gian chạy tương đối ổn định, nhưng chậm hơn Insertion Sort.\n" +
                "Dữ liệu đã sắp xếp:\n" +
                "Thời gian chạy không khác biệt nhiều so với dữ liệu ngẫu nhiên.\n" +
                "Dữ liệu ngược lại:\n" +
                "Thời gian chạy tương đối ổn định, không khác biệt nhiều so với dữ liệu ngẫu nhiên và dữ liệu đã sắp xếp.\n" +
                "\n" +
                "3. Insertion Sort\n" +
                "Dữ liệu ngẫu nhiên:\n" +
                "Thời gian chạy tốt hơn Bubble Sort và Selection Sort.\n" +
                "Dữ liệu đã sắp xếp:\n" +
                "Thời gian chạy nhanh nhất do Insertion Sort có thể dừng sớm khi không cần chèn.\n" +
                "Dữ liệu ngược lại:\n" +
                "Thời gian chạy chậm hơn so với dữ liệu đã sắp xếp nhưng tốt hơn Bubble Sort.\n" +
                "Phân tích độ phức tạp thời gian");
        System.out.println("----------------------------------------------------------------------------------------------------");

        System.out.println("\n1. Bubble Sort\n" +
                "Best Case: O(n)\n" +
                "Xảy ra khi mảng đã được sắp xếp. Bubble Sort sẽ không thực hiện bất kỳ phép hoán đổi nào.\n" +
                "Worst Case: O(n^2)\n" +
                "Xảy ra khi mảng sắp xếp ngược lại. Mỗi phần tử phải được so sánh và hoán đổi.\n" +
                "Average Case: O(n^2)\n" +
                "Thông thường, Bubble Sort phải thực hiện hoán đổi nhiều lần.\n" +
                "\n" +
                "2. Selection Sort\n" +
                "Best Case: O(n^2)\n" +
                "Dù mảng đã sắp xếp, Selection Sort vẫn phải duyệt qua toàn bộ mảng để tìm phần tử nhỏ nhất.\n" +
                "Worst Case: O(n^2)\n" +
                "Xảy ra khi mảng sắp xếp ngược lại. Mỗi phần tử phải được so sánh để tìm phần tử nhỏ nhất.\n" +
                "Average Case: O(n^2)\n" +
                "Mỗi phần tử phải được so sánh với tất cả các phần tử còn lại.\n" +
                "\n" +
                "3. Insertion Sort\n" +
                "Best Case: O(n)\n" +
                "Xảy ra khi mảng đã được sắp xếp. Insertion Sort sẽ không thực hiện bất kỳ phép chèn nào.\n" +
                "Worst Case: O(n^2)\n" +
                "Xảy ra khi mảng sắp xếp ngược lại. Mỗi phần tử phải được chèn vào vị trí đúng.\n" +
                "Average Case: O(n^2)\n" +
                "Thông thường, Insertion Sort phải thực hiện chèn nhiều lần.\n");
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println("Nhận xét và đánh giá\n" +
                "Bubble Sort\n" +
                "Hiệu năng: Chậm nhất trong ba thuật toán, đặc biệt khi dữ liệu đã sắp xếp ngược lại hoặc ngẫu nhiên.\n" +
                "Ưu điểm: Hiệu quả tốt hơn khi dữ liệu đã được sắp xếp hoặc gần sắp xếp.\n" +
                "Khuyết điểm: Số lượng hoán đổi lớn làm cho thời gian chạy tăng đáng kể khi dữ liệu không được sắp xếp.\n" +
                "\n" +
                "Selection Sort\n" +
                "Hiệu năng: Thời gian chạy ổn định, không bị ảnh hưởng nhiều bởi việc dữ liệu đã sắp xếp hay ngẫu nhiên.\n" +
                "Ưu điểm: Số lượng so sánh cố định, do đó thời gian chạy ít biến động.\n" +
                "Khuyết điểm: Số lượng so sánh cao khiến thời gian chạy chậm hơn so với Insertion Sort.\n" +
                "\n" +
                "Insertion Sort\n" +
                "Hiệu năng: Tốt nhất khi dữ liệu đã được sắp xếp hoặc gần sắp xếp, nhưng chậm hơn với dữ liệu ngẫu nhiên.\n" +
                "Ưu điểm: Số lượng chèn ít hơn dẫn đến thời gian chạy nhanh hơn khi dữ liệu đã sắp xếp.\n" +
                "Khuyết điểm: Hiệu năng giảm khi dữ liệu đã sắp xếp ngược lại.\n" +
                "\n" +
                "Các kết quả thực nghiệm này phù hợp với lý thuyết về độ phức tạp thời gian của các thuật toán." +
                "\n--------------------------------------------------------------------------------------------------------\n" +
                "Tổng kết\n" +
                "Bubble Sort: Không phải là lựa chọn tốt cho dữ liệu ngẫu nhiên hoặc sắp xếp ngược lại, nhưng có thể hữu ích khi dữ liệu gần như đã sắp xếp.\n" +
                "Selection Sort: Thời gian chạy ổn định nhưng thường chậm hơn so với Insertion Sort do số lượng so sánh cao.\n" +
                "Insertion Sort: Lựa chọn tốt nhất trong ba thuật toán cho dữ liệu đã sắp xếp hoặc gần sắp xếp, nhưng cần cẩn trọng với dữ liệu ngẫu nhiên hoặc ngược lại.");
    }

    // Phương Thức Đo Thời Gian Chạy: Đo thời gian chạy của thuật toán sắp xếp trên loại dữ liệu nhất định.
    private static void testAlgorithmPerformance(SortingAlgorithm algorithm, Float[] data, String dataType) {
        long startTime = System.nanoTime();
        algorithm.sort(data);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.printf("%s: %d ns%n", dataType, duration);
    }

    private static Float[] generateRandomData(int size) {
        Float[] data = new Float[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            data[i] = random.nextFloat() * size;
        }
        return data;
    }

    private static Float[] generateSortedData(int size) {
        Float[] data = new Float[size];
        for (int i = 0; i < size; i++) {
            data[i] = (float) i;
        }
        return data;
    }

    private static Float[] generateReversedData(int size) {
        Float[] data = new Float[size];
        for (int i = 0; i < size; i++) {
            data[i] = (float) (size - i);
        }
        return data;
    }

    @FunctionalInterface
    interface SortingAlgorithm {
        Float[] sort(Float[] data);
    }
}


// Nhận Xét Hiệu Năng
//Dữ liệu sắp xếp theo thứ tự ngược lại: Thường là trường hợp tệ nhất cho
// các thuật toán sắp xếp đơn giản như Bubble Sort và Insertion Sort.

//Dữ liệu đã được sắp xếp: Thường là trường hợp tốt nhất cho Insertion Sort và
// có thể tốt cho các thuật toán khác nếu chúng có thể nhận ra rằng dữ liệu đã được sắp xếp.

//Dữ liệu có xáo trộn ngẫu nhiên: Cung cấp cái nhìn thực tế hơn về hiệu năng trung bình của các thuật toán.

////////////////////////////////////////////////////////////////////

//Kết quả thực nghiệm và nhận xét
//1. Bubble Sort
//Dữ liệu ngẫu nhiên:
//Thời gian chạy khá chậm so với Selection Sort và Insertion Sort.
//Dữ liệu đã sắp xếp:
//Thời gian chạy nhanh nhất trong ba trường hợp do Bubble Sort có thể dừng sớm khi không cần hoán đổi.
//Dữ liệu ngược lại:
//Thời gian chạy chậm nhất vì phải thực hiện tất cả các phép hoán đổi.

//2. Selection Sort
//Dữ liệu ngẫu nhiên:
//Thời gian chạy tương đối ổn định, nhưng chậm hơn Insertion Sort.
//Dữ liệu đã sắp xếp:
//Thời gian chạy không khác biệt nhiều so với dữ liệu ngẫu nhiên.
//Dữ liệu ngược lại:
//Thời gian chạy tương đối ổn định, không khác biệt nhiều so với dữ liệu ngẫu nhiên và dữ liệu đã sắp xếp.

//3. Insertion Sort
//Dữ liệu ngẫu nhiên:
//Thời gian chạy tốt hơn Bubble Sort và Selection Sort.
//Dữ liệu đã sắp xếp:
//Thời gian chạy nhanh nhất do Insertion Sort có thể dừng sớm khi không cần chèn.
//Dữ liệu ngược lại:
//Thời gian chạy chậm hơn so với dữ liệu đã sắp xếp nhưng tốt hơn Bubble Sort.
//Phân tích độ phức tạp thời gian

//1. Bubble Sort
//Best Case: O(n)
//Xảy ra khi mảng đã được sắp xếp. Bubble Sort sẽ không thực hiện bất kỳ phép hoán đổi nào.
//Worst Case: O(n^2)
//Xảy ra khi mảng sắp xếp ngược lại. Mỗi phần tử phải được so sánh và hoán đổi.
//Average Case: O(n^2)
//Thông thường, Bubble Sort phải thực hiện hoán đổi nhiều lần.

//2. Selection Sort
//Best Case: O(n^2)
//Dù mảng đã sắp xếp, Selection Sort vẫn phải duyệt qua toàn bộ mảng để tìm phần tử nhỏ nhất.
//Worst Case: O(n^2)
//Xảy ra khi mảng sắp xếp ngược lại. Mỗi phần tử phải được so sánh để tìm phần tử nhỏ nhất.
//Average Case: O(n^2)
//Mỗi phần tử phải được so sánh với tất cả các phần tử còn lại.

//3. Insertion Sort
//Best Case: O(n)
//Xảy ra khi mảng đã được sắp xếp. Insertion Sort sẽ không thực hiện bất kỳ phép chèn nào.
//Worst Case: O(n^2)
//Xảy ra khi mảng sắp xếp ngược lại. Mỗi phần tử phải được chèn vào vị trí đúng.
//Average Case: O(n^2)
//Thông thường, Insertion Sort phải thực hiện chèn nhiều lần.


//Nhận xét và đánh giá
//Bubble Sort
//Hiệu năng: Chậm nhất trong ba thuật toán, đặc biệt khi dữ liệu đã sắp xếp ngược lại hoặc ngẫu nhiên.
//Ưu điểm: Hiệu quả tốt hơn khi dữ liệu đã được sắp xếp hoặc gần sắp xếp.
//Khuyết điểm: Số lượng hoán đổi lớn làm cho thời gian chạy tăng đáng kể khi dữ liệu không được sắp xếp.

//Selection Sort
//Hiệu năng: Thời gian chạy ổn định, không bị ảnh hưởng nhiều bởi việc dữ liệu đã sắp xếp hay ngẫu nhiên.
//Ưu điểm: Số lượng so sánh cố định, do đó thời gian chạy ít biến động.
//Khuyết điểm: Số lượng so sánh cao khiến thời gian chạy chậm hơn so với Insertion Sort.

//        Insertion Sort
//Hiệu năng: Tốt nhất khi dữ liệu đã được sắp xếp hoặc gần sắp xếp, nhưng chậm hơn với dữ liệu ngẫu nhiên.
//Ưu điểm: Số lượng chèn ít hơn dẫn đến thời gian chạy nhanh hơn khi dữ liệu đã sắp xếp.
//Khuyết điểm: Hiệu năng giảm khi dữ liệu đã sắp xếp ngược lại.

//Các kết quả thực nghiệm này phù hợp với lý thuyết về độ phức tạp thời gian của các thuật toán.


//Tổng kết
//Bubble Sort: Không phải là lựa chọn tốt cho dữ liệu ngẫu nhiên hoặc sắp xếp ngược lại, nhưng có thể hữu ích khi dữ liệu gần như đã sắp xếp.
//Selection Sort: Thời gian chạy ổn định nhưng thường chậm hơn so với Insertion Sort do số lượng so sánh cao.
//Insertion Sort: Lựa chọn tốt nhất trong ba thuật toán cho dữ liệu đã sắp xếp hoặc gần sắp xếp, nhưng cần cẩn trọng với dữ liệu ngẫu nhiên hoặc ngược lại.