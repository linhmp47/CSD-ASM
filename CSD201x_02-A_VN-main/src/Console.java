import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Console {
    public static final String CONSOLE_FILE = "console_output.txt";
    public static FileOutputStream file;
    public static PrintStream output;
    // consoleLog save all content of console
    public static String consoleLog = "";

    /**
     * Clear console log content
     */
    public static void clear() {
        consoleLog = "";
    }

    public static void open() throws FileNotFoundException {
        file = new FileOutputStream(CONSOLE_FILE);
        output = new PrintStream(file);
    }

    /**
     * Print content and add to consoleLog
     */
    public static void print(String content) {
        System.out.print(content);
        consoleLog += content;
    }

    /**
     * Print break line and add to consoleLog
     */
    public static void println() {
        System.out.println();
        consoleLog += "\n";
    }

    public static void println(String content) {
        print(content);
        println();
    }

    /**
     * Save consoleLog to file
     */
    public static void save() throws IOException {
        output.print(consoleLog);
        output.flush();
        file.close();
    }
}
