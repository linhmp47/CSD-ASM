import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static final String FILE_PATH = "data.txt";

    public static void main(String[] args) throws IOException {
        OperationToProduct program = new OperationToProduct();
        MyList list = new MyList();
        MyStack stack = new MyStack();
        MyQueue queue = new MyQueue();

        Scanner console = new Scanner(System.in);
        while (true) {
            showMenu();
            int userChoice = getUserChoice(console);
            if (userChoice == 0) {
                Console.println("Program ends! See you again!");
                break;
            }
            switch (userChoice) {
                case 1:
                    list.clear();
                    program.readFile(FILE_PATH, list);
                    program.display(list);
                    Console.println("Successfully!");
                    break;
                case 2:
                    program.importProductToList(list, console);
                    break;
                case 3:
                    program.display(list);
                    break;
                case 4:
                    program.writeFile(FILE_PATH, list);
                    break;
                case 5:
                    Console.print("Input the ID to search = ");
                    String idSearch = program.importId(console);
                    program.displayById(list, idSearch);
                    break;
                case 6:
                    Console.print("Input the ID to delete = ");
                    String idDelete = program.importId(console);
                    program.deleteById(list, idDelete);
                    break;
                case 7:
                    program.sortById(list);
                    break;
                case 8:
                    program.quantityToBinary(list);
                    break;
                case 9:
                    stack.clear();
                    program.readFile(FILE_PATH, stack);
                    program.display(stack);
                    Console.println("Successfully!");
                    break;
                case 10:
                    queue.clear();
                    program.readFile(FILE_PATH, queue);
                    program.display(queue);
                    break;
                case 11:
                    program.saveConsole();
                    break;
                case 12:
                    program.clearConsole();
                    break;
                default:
                    invalidChoice();
            }
            Console.println();
        }
    }

    public static void showMenu() {
        Console.println("Choose one of this options:");
        Console.println("1.  Load data from file and display");
        Console.println("2.  Input & add to the end");
        Console.println("3.  Display data");
        Console.println("4.  Save product list to file");
        Console.println("5.  Search by ID");
        Console.println("6.  Delete by ID");
        Console.println("7.  Sort by ID (Selection sort - Recursion)");
        Console.println("8.  Convert to Binary");
        Console.println("9.  Load to stack and display");
        Console.println("10. Load to queue and display");
        Console.println("11. Save console log to file");
        Console.println("12. Clear data console log file");
        Console.println("0.  Exit");
        Console.println("");
    }

    public static int getUserChoice(Scanner console) {
        Console.print("Choice = ");
        int userChoice = console.nextInt();
        console.nextLine();
        return userChoice;
    }

    public static void invalidChoice() {
        Console.println("Invalid choice! Try again!");
    }
}
