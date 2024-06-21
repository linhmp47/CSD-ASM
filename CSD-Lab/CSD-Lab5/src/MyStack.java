public class MyStack {
    Node head;

    MyStack() {
        head = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    // Hàm đẩy 1 phần tử vào stack
    void push(int x) {
        Node newNode = new Node(x, head);
        head = newNode;
    }

    // Hàm lấy 1 phần tử ra khỏi stack
    int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            int value = head.info;
            head = head.next;
            return value;
        }
    }

    // Hàm thuật toán chuyển đổi 1 số nguyên ở hệ đếm thập phân sang nhị phân
    void convertToBinary(int x) {
        while (x > 0) {
            int remainder = x % 2;
            push(remainder);
            x = x / 2;
        }

        while (!isEmpty()) {
            System.out.print(pop());
        }
        System.out.println();
    }
}