public class MyList {
    /**
     * Declare fields of list
     * head, tail
     */
    Node head;
    Node tail;

    /**
     * Constructor method
     */
    public MyList() {

    }

    public MyList(Node head, Node tail) {
        this.head = head;
        this.tail = tail;
    }

    /**
     * Check empty list
     */
    public boolean isEmpty() {
        return head == null;
    }

    public void clear() {
        head = null;
        tail = null;
    }

    /**
     * @return String, all product on list
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

    /**
     * Insert node to tail with given info
     */
    public void insertToTail(Product info) {
        Node newNode = new Node(info);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    /**
     * Delete node on list
     */
    public void deleteAtNode(Node currentNode) {
        if (isEmpty() || currentNode == null) {
            return;
        }
        if (head == currentNode) {
            head = head.next;
        }
        if (tail == currentNode) {
            tail = tail.prev;
        }
        if (currentNode.next != null) {
            currentNode.next.prev = currentNode.prev;
        }
        if (currentNode.prev != null) {
            currentNode.prev.next = currentNode.next;
        }
    }
}
