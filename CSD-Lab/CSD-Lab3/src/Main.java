public class Main {
    public static void main(String[] args) {
        MyList t = new MyList();

        int[] a = {7, 2, 9, 8, 6, 3};

        t.addMany(a);

        System.out.println("\nTraverse:");
        t.traverse();

        System.out.println("\nSearch(8):");
        t.search(8);

    }
}