public class BSTTest {
    public static void main(String[] args) {
        BST<Integer, String> tree = new BST<>();

        // 1. Add elements
        tree.put(8, "eight");
        tree.put(3, "three");
        tree.put(10, "ten");
        tree.put(1, "one");
        tree.put(6, "six");
        tree.put(14, "fourteen");
        tree.put(4, "four");
        tree.put(7, "seven");
        tree.put(13, "thirteen");

        // 2. Check size
        System.out.println("Size: " + tree.size());

        // 3. Check get()
        System.out.println("Get key 6: " + tree.get(6));
        System.out.println("Get key 10: " + tree.get(10));
        System.out.println("Get key 100: " + tree.get(100));

        // 4. Check in-order iteration
        System.out.println("\nTree elements in-order:");
        for (var elem : tree) {
            System.out.println("key is " + elem.getKey() + " and value is " + elem.getValue());
        }

        // 5. Check delete()
        tree.delete(10);

        System.out.println("\nAfter deleting key 10:");
        System.out.println("Size: " + tree.size());

        for (var elem : tree) {
            System.out.println("key is " + elem.getKey() + " and value is " + elem.getValue());
        }
    }
}