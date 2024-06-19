public class Product {
    public static final String PRINT_FORMAT = "%-5s | %-10s | %-10s | %s";
    public static final String PRINT_HEAD = String.format(PRINT_FORMAT, "ID", "TITLE", "QUANTITY", "PRICE");
    public static final String DASH = "---------------------------------------";
    public static final String SUCCCESS = "Successfully!";
    /**
     * Declare fields of Product
     * id, title, price, quantity
     */
    private String id;
    private String title;
    private double price;
    private int quantity;

    /**
     * Constructor method
     */
    public Product() {

    }

    public Product(String id, String title, double price, int quantity) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Getter and setter fields of Product
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Overriding toString method, using for display information
     * @return String, This returns fields of Product
     */
    @Override
    public String toString() {
        return String.format(PRINT_FORMAT, id, title, quantity, price);
    }
}
