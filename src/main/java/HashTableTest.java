import java.util.Random;

public class HashTableTest {
    public static void main(String[] args) {
        Random random = new Random();
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>(101);
        for (int i = 0; i < 10000; i++) {
            int id = i;
            String name = "Name" + random.nextInt(100000);

            MyTestingClass key = new MyTestingClass(id, name);
            Student student = new Student(i, "Student" + i, 2.0 + random.nextDouble() * 2.0);

            table.put(key, student);
        }
        System.out.println("Total elements: " + table.size());
        table.printBucketSizes();
    }
}