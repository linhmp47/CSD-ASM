import java.io.*;
import java.util.Arrays;

public class Algorithm {

    public void writeFile(String fileName, Float[] arr) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Float num : arr) {
                writer.write(num + " ");
            }
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public Float[] readFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            if (line != null) {
                String[] parts = line.trim().split("\\s+");
                Float[] arr = new Float[parts.length];
                for (int i = 0; i < parts.length; i++) {
                    arr[i] = Float.parseFloat(parts[i]);
                }
                return arr;
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
        return new Float[0];
    }

    public Float[] bubbleSort(Float[] arr) {
        Float[] b = arr.clone();
        int n = b.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (b[j] > b[j + 1]) {
                    float temp = b[j];
                    b[j] = b[j + 1];
                    b[j + 1] = temp;
                }
            }
            System.out.println(Arrays.toString(b));
        }
        return b;
    }

    public Float[] selectionSort(Float[] arr) {
        Float[] b = arr.clone();
        int n = b.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (b[j] < b[minIdx]) {
                    minIdx = j;
                }
            }
            float temp = b[minIdx];
            b[minIdx] = b[i];
            b[i] = temp;

            System.out.println(Arrays.toString(b));
        }
        return b;
    }

    public Float[] insertionSort(Float[] arr) {
        Float[] b = arr.clone();
        int n = b.length;
        for (int i = 1; i < n; ++i) {
            float key = b[i];
            int j = i - 1;
            while (j >= 0 && b[j] > key) {
                b[j + 1] = b[j];
                j = j - 1;
            }
            b[j + 1] = key;

            System.out.println(Arrays.toString(b));
        }
        return b;
    }

    public Float[] linearSearch(Float[] arr, float value) {
        StringBuilder result = new StringBuilder();
        boolean found = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > value) {
                result.append(i).append(" ");
                found = true;
            }
        }
        if (!found) {
            result.append("Không tìm thấy");
        }
        System.out.println("Các vị trí có giá trị lớn hơn " + value + ": " + result.toString().trim());
        return arr;
    }

    public int binarySearch(Float[] arr, int left, int right, float value) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid].equals(value)) {
                writeResultToFile("OUTPUT5.txt", mid);
                return mid;
            }
            if (arr[mid] < value) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        writeResultToFile("OUTPUT5.txt", -1);
        return -1;
    }

    private void writeResultToFile(String fileName, int result) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(String.valueOf(result));
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public void calculateRunTimes() {
        System.out.println("Runtime calculation is not implemented.");
    }
}

