public class Node {
    /**
     * Declare fields of Node
     * info, next, prev
     */
    Product info;
    Node next;
    Node prev;

    /**
     * Constructor method
     */
    public Node() {

    }

    public Node(Product info) {
        this.info = info;
        this.next = null;
        this.prev = null;
    }

    /**
     * Overriding toString method, using for display info
     * @return String, return info as a String
     */
    @Override
    public String toString() {
        return info.toString();
    }
}
