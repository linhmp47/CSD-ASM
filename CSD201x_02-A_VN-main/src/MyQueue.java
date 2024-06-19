import java.util.EmptyStackException;

public class MyQueue {
    /**
     * Declare fields of queue
     * head, tail
     */
    Node head;
    Node tail;

    /**
     * Constructor method
     */
    public MyQueue() {

    }

    public MyQueue(Node head, Node tail) {
        this.head = head;
        this.tail = tail;
    }

    /**
     * Check empty queue
     */
    public boolean isEmpty() {
        return head == null;
    }

    public void clear() {
        head = null;
        tail = null;
    }

    /**
     * Insert element to tail of queue
     */
    public void enqueue(Product info) {
        Node newNode = new Node(info);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    /**
     * Take product's info at head of queue
     */
    public Product dequeue() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Product info = head.info;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return info;
    }

    /**
     * @return String, all product on queue
     */
    public String traverse() {
        String res = "";
        Node currentNode = head;
        while (currentNode != null) {
            res += currentNode + "\n";
            currentNode = currentNode.next;
        }
        return res;
    }
}
