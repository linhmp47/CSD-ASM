public class Main {
    public static void main(String[] args) {
        int x = 5; // Thay đổi giá trị của x để kiểm tra với các số khác
        MyStack stack = new MyStack();
        System.out.print("Binary of " + x + " is: ");
        stack.convertToBinary(x);
    }
}