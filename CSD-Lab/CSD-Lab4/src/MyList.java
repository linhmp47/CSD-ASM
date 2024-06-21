public class MyList {
    Node head, tail;

    MyList() {
        head = tail = null;
    }

    void clear() {
        head = tail = null;
    }

    boolean isEmpty() {
        return(head == null);
    }

    // Hàm thêm 1 người vào đuôi danh sách liên kết
    void add(Person x) {
        Node newNode = new Node(x);
        if(isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Hàm thêm nhiều người vào danh sách liên kết, thông tin ( tên và tuổi) của mọi người được lưu trong 2 mảng a và b
    void addMany(String[] a, int[] b) {
        for(int i = 0; i < a.length; i++) {
            add(new Person(a[i], b[i]));
        }
    }

    // Hàm duyệt danh sách liên kết
    void traverse() {
        Node p = head;
        while(p != null) {
            System.out.println(p.info);
            p = p.next;
        }
    }

    // Hàm sắp xếp theo tên
    void sortByName() {
        if(isEmpty()) return;

        // Bubble sort for simplicity
        Node current, index;
        Person temp;

        for(current = head; current != null; current = current.next) {
            for(index = current.next; index != null; index = index.next) {
                if(current.info.name.compareTo(index.info.name) > 0) {
                    temp = current.info;
                    current.info = index.info;
                    index.info = temp;
                }
            }
        }
    }
}