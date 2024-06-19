import java.util.EmptyStackException;

public class MyStack {
    Node head;

    /**
     * Constructor method
     */
    public MyStack() {

    }

    public MyStack(Node head) {
        this.head = head;
    }

    /**
     * Check empty stack
     */
    public boolean isEmpty() {
        return head == null;
    }

    public void clear() {
        head = null;
    }

    /**
     * Insert element to head of stack
     */
    public void push(Product info) {
        Node newNode = new Node(info);
        if (isEmpty()) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    /**
     * Take product's info at head of stack
     */
    public Product pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Product info = head.info;
        head = head.next;
        return info;
    }

    /**
     * @return String, all product on stack
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
