public class MyList {
    Node head, tail;

    MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    // Hàm thêm một phần tử vào cuối danh sách
    void addTail(int x) {
        Node newNode = new Node(x);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Hàm thêm nhiều phần tử vào cuối danh sách
    void addMany(int[] a) {
        for (int i : a) {
            addTail(i);
        }
    }

    // Hàm hiển thị giá trị info của node p
    void visit(Node p) {
        System.out.print(p.info + "  ");
    }

    // Hàm Duyệt danh sách
    void traverse() {
        Node p = head;
        while (p != null) {
            visit(p);
            p = p.next;
        }
    }

    // Hàm tìm kiếm phần tử có giá trị lớn hơn x, nếu tìm thấy thì hiển thị chỉ số của phần tử ra màn hình, giả sử phần tử đầu tiên có chỉ số là 0
    void search(int x) {
        Node p = head;
        int index = 0;
        while (p != null) {
            if (p.info > x) {
                System.out.println(index);
                return;
            }
            p = p.next;
            index++;
        }
        System.out.println("No element found with value greater than " + x);
    }
}