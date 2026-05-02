public class BSTTest {
    public static void main(String[] args) {

        // Create a hard coded BST.
        //
        //             20
        //            /  \
        //           8    22
        //          / \
        //         4   12
        //            /  \
        //           10   14

        BST<Integer, String> tree = new BST<>();

        tree.put(20, "twenty");
        tree.put(8, "eight");
        tree.put(22, "twenty two");
        tree.put(4, "four");
        tree.put(12, "twelve");
        tree.put(10, "ten");
        tree.put(14, "fourteen");

        System.out.println("Size: " + tree.size());

        System.out.println("Get key 12: " + tree.get(12));
        System.out.println("Get key 100: " + tree.get(100));

        System.out.println("\nIn-order traversal:");
        for (var elem : tree) {
            System.out.println("key is " + elem.getKey() + " and value is " + elem.getValue());
        }

        tree.delete(8);

        System.out.println("\nAfter deleting key 8:");
        System.out.println("Size: " + tree.size());

        for (var elem : tree) {
            System.out.println("key is " + elem.getKey() + " and value is " + elem.getValue());
        }
    }
}