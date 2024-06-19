import java.io.*;
import java.util.Scanner;

public class OperationToProduct {

    /**
     * 1. Read all product from file
     * and save to list
     */
    public void readFile(String filePath, MyList list) {
        try {
            FileInputStream file = new FileInputStream(filePath);
            Scanner input = new Scanner(file);
            input.nextLine();
            while (input.hasNextLine()) {
                String line = input.nextLine();
                Product newProduct = createProduct(line);
                list.insertToTail(newProduct);
            }
            input.close();
            file.close();
        } catch (FileNotFoundException e) {
            System.err.println("File Not Found!");
        } catch (IOException e) {
            System.err.println("Can not read file!");
        }
    }

    public Product createProduct(String data) {
        int numberOfFields = 4;
        String[] info = data.split("\\|");
        String id = info[0].trim();
        String title = info[1].trim();
        int quantity = Integer.parseInt(info[2].trim());
        double price = Double.parseDouble(info[3].trim());
        return new Product(id, title, price, quantity);
    }

    /**
     * 2. Import new product's data from keyboard
     * and add to the last on list.
     */
    public void importProductToList(MyList list, Scanner console) {
        Console.print("Input new ID: ");
        String id = importId(console);
        String title = importTitle(console);
        int quantity = importQuantity(console);
        double price = importPrice(console);
        Product newProduct = new Product(id, title, price, quantity);
        list.insertToTail(newProduct);
    }

    public String importId(Scanner console) {
        return console.nextLine().trim();
    }

    public String importTitle(Scanner console) {
        Console.print("Input Product's Name: ");
        return console.nextLine().trim();
    }

    public double importPrice(Scanner console) {
        Console.print("Input Product's price: ");
        double price = console.nextDouble();
        console.nextLine();
        return price;
    }

    public int importQuantity(Scanner console) {
        Console.print("Input Product's quantity: ");
        int quantity = console.nextInt();
        console.nextLine();
        return quantity;
    }

    /**
     * 3. Display information of all product on list
     */
    public void display(MyList list) {
        if (list.isEmpty()) {
            Console.println("List is empty. Can not display list!");
            return;
        }

        Console.println();
        Console.println(Product.PRINT_HEAD);
        Console.println(Product.DASH);
        Console.println(list.traverse());
    }

    /**
     * 4. Write information of all product on list to file
     */
    public void writeFile(String filePath, MyList list) {
        try {
            FileOutputStream file = new FileOutputStream(filePath);
            PrintStream output = new PrintStream(file);
            output.println(Product.PRINT_HEAD);
            Node currentNode = list.head;
            while (currentNode != null) {
                output.println(currentNode);
                currentNode = currentNode.next;
            }
            Console.println("Successfully!");
            output.close();
            file.close();
        } catch (FileNotFoundException e) {
            Console.println("File Not Found!");
        } catch (IOException e) {
            Console.println("Can not write to file.");
        }
    }

    /**
     * 5. Search and display first product on list by id
     */
    public void displayById(MyList list, String id) {
        Node currentNode = searchById(list, id);
        if (currentNode == null) {
            Console.println("Product not found. Can not display product!");
            return;
        }

        Console.println();
        Console.print("Result: ");
        Console.println(currentNode.toString());
    }

    public Node searchById(MyList list, String id) {
        Node currentNode = list.head;
        while (currentNode != null) {
            if (currentNode.info.getId().equals(id)) {
                return currentNode;
            }
            currentNode = currentNode.next;
        }
        return null;
    }

    /**
     * 6. Delete first product on list by id
     */
    public void deleteById(MyList list, String id) {
        if (list.isEmpty()) {
            Console.println("List is empty. Can not delete any element!");
            return;
        }
        Node currentNode = searchById(list, id);
        if (currentNode == null) {
            Console.println("Product not found. Can not delete product!");
            return;
        }
        list.deleteAtNode(currentNode);
        Console.println("Deleted");
    }

    /**
     * 7. Sort list of product by id
     * (Selection sort - Recursion)
     */
    public void sortById(MyList list) {
        if (list.isEmpty()) {
            Console.println("List is empty. Can not sort list!");
            return;
        }
        setAtNode(list, list.head);
        Console.println("Successfully!");
    }

    /**
     * Find and swap to product has min id
     */
    public void setAtNode(MyList list, Node currentNode) {
        if (currentNode == list.tail || currentNode == null) {
            return;
        }
        Node minNode = minFromNode(list, currentNode);
        if (currentNode != minNode) {
            Product tmp = currentNode.info;
            currentNode.info = minNode.info;
            minNode.info = tmp;
        }
        setAtNode(list, currentNode.next);
    }

    /**
     * Find node has min id from current Node to tail of list
     */
    public Node minFromNode(MyList list, Node currentNode) {
        if (currentNode == list.tail) {
            return currentNode;
        }
        Node tmp = minFromNode(list, currentNode.next);
        if (isSmaller(tmp.info.getId(), currentNode.info.getId())) return tmp;
        return currentNode;
    }

    /**
     * Compare 2 string
     * @return boolean, true if s1 < s2
     */
    public boolean isSmaller(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        int lMin = Math.min(l1, l2);
        for (int i = 0; i < lMin; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 == c2) {
                continue;
            }
            return c1 < c2;
        }
        return l1 < l2;
    }

    /**
     * 8. Convert first product quantity to binary
     */
    public void quantityToBinary(MyList list) {
        if (list.isEmpty()) {
            Console.println("List is empty. Can not display quantity to binary!");
            return;
        }
        int quantity = list.head.info.getQuantity();
        String quantityBinary = toBinary(quantity);
        Console.println("Quantity = " + quantity + " => " + quantityBinary);
    }

    public String toBinary(int value) {
        if (value == 0) {
            return "";
        }
        return toBinary(value/2) + value % 2;
    }

    /**
     * 9. Read all product from file,
     * save to stack and display
     */
    public void readFile(String filePath, MyStack stack) {
        try {
            FileInputStream file = new FileInputStream(filePath);
            Scanner input = new Scanner(file);
            input.nextLine();
            while (input.hasNextLine()) {
                String line = input.nextLine();
                Product newProduct = createProduct(line);
                stack.push(newProduct);
            }
            input.close();
            file.close();
        } catch (FileNotFoundException e) {
            System.err.println("File Not Found!");
        } catch (IOException e) {
            System.err.println("Can not read file!");
        }
    }

    public void display(MyStack stack) {
        if (stack.isEmpty()) {
            Console.println("Stack is empty. Can not display!");
            return;
        }
        Console.println();
        Console.println(Product.PRINT_HEAD);
        Console.println(Product.DASH);
        Console.println(stack.traverse());
    }

    /**
     * 10. Read all product from file,
     * save to queue and display
     */
    public void readFile(String filePath, MyQueue queue) {
        try {
            FileInputStream file = new FileInputStream(filePath);
            Scanner input = new Scanner(file);
            input.nextLine();
            while (input.hasNextLine()) {
                String line = input.nextLine();
                Product newProduct = createProduct(line);
                queue.enqueue(newProduct);
            }
            input.close();
            file.close();
        } catch (FileNotFoundException e) {
            System.err.println("File Not Found!");
        } catch (IOException e) {
            System.err.println("Can not read file!");
        }
    }

    public void display(MyQueue queue) {
        if (queue.isEmpty()) {
            Console.println("Queue is empty. Can not display!");
            return;
        }
        Console.println();
        Console.println(Product.PRINT_HEAD);
        Console.println(Product.DASH);
        Console.println(queue.traverse());
    }

    /**
     * 11. Save console log to file
     */
    public void saveConsole() throws IOException {
        Console.open();
        Console.save();
        System.out.println("Save console log successfully!");
    }

    /**
     * 12. Clear data console log file
     */
    public void clearConsole() throws IOException {
        Console.clear();
        Console.open();
        Console.save();
        System.out.println("Delete console log successfully!");
    }
}
