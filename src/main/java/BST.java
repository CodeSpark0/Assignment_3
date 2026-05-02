import java.util.*;

public class BST<K extends Comparable<K>, V> implements Iterable<BST.Entry<K, V>> {

    private Node root;
    private int size;

    private class Node {
        K key;
        V value;
        Node left, right, parent;

        Node(K key, V value, Node parent) {
            this.key = key;
            this.value = value;
            this.parent = parent;
        }
    }

    public static class Entry<K, V> {
        private K key;
        private V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    public int size() {
        return size;
    }

    public void put(K key, V value) {
        if (root == null) {
            root = new Node(key, value, null);
            size++;
            return;
        }

        Node current = root;
        Node parent = null;

        while (current != null) {
            parent = current;
            int cmp = key.compareTo(current.key);

            if (cmp < 0) {
                current = current.left;
            } else if (cmp > 0) {
                current = current.right;
            } else {
                current.value = value;
                return;
            }
        }

        Node newNode = new Node(key, value, parent);

        if (key.compareTo(parent.key) < 0) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }

        size++;
    }

    public V get(K key) {
        Node current = root;

        while (current != null) {
            int cmp = key.compareTo(current.key);

            if (cmp < 0) {
                current = current.left;
            } else if (cmp > 0) {
                current = current.right;
            } else {
                return current.value;
            }
        }

        return null;
    }

    public void delete(K key) {
        Node node = findNode(key);

        if (node == null) {
            return;
        }

        if (node.left != null && node.right != null) {
            Node successor = min(node.right);
            node.key = successor.key;
            node.value = successor.value;
            node = successor;
        }

        Node child = node.left != null ? node.left : node.right;

        if (node.parent == null) {
            root = child;
        } else if (node == node.parent.left) {
            node.parent.left = child;
        } else {
            node.parent.right = child;
        }

        if (child != null) {
            child.parent = node.parent;
        }

        size--;
    }

    private Node findNode(K key) {
        Node current = root;

        while (current != null) {
            int cmp = key.compareTo(current.key);

            if (cmp < 0) {
                current = current.left;
            } else if (cmp > 0) {
                current = current.right;
            } else {
                return current;
            }
        }

        return null;
    }

    private Node min(Node node) {
        while (node.left != null) {
            node = node.left;
        }

        return node;
    }

    @Override
    public Iterator<Entry<K, V>> iterator() {
        return new Iterator<Entry<K, V>>() {
            Stack<Node> stack = new Stack<>();

            {
                pushLeft(root);
            }

            private void pushLeft(Node node) {
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }

            @Override
            public boolean hasNext() {
                return !stack.isEmpty();
            }

            @Override
            public Entry<K, V> next() {
                Node node = stack.pop();

                if (node.right != null) {
                    pushLeft(node.right);
                }

                return new Entry<>(node.key, node.value);
            }
        };
    }
}