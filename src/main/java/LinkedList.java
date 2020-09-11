import java.util.ArrayList;
import java.util.List;

public class LinkedList<T> {
    private Node<T> head;

    public LinkedList() {
        head = null;
    }

    public static void main(String[] args) {
        LinkedList<String> stringList = new LinkedList<String>();
        stringList.insertFirst("Apple");
        stringList.insertFirst("Orange");
        stringList.insertLast("Banana");
        System.out.println(stringList); // "Orange" -> "Apple" -> "Banana" -> null

        System.out.println(stringList.search("Apple")); // true
        System.out.println(stringList.search("Pineapple")); // false

        System.out.println(stringList.removeFirst()); // "Orange"
        System.out.println(stringList.removeLast()); // "Banana"
        System.out.println(stringList); // "Apple" -> null

        LinkedList<Double> doubleList = new LinkedList<Double>();
        doubleList.insertFirst(2.2);
        doubleList.insertFirst(1.1);
        doubleList.insertLast(3.3);
        System.out.println(doubleList); // "1.1" -> "2.2" -> "3.3" -> null

        System.out.println(doubleList.search(4.4)); // false
        System.out.println(doubleList.search(2.2)); // true

        System.out.println(doubleList.removeFirst()); // "1.1"
        System.out.println(doubleList.removeLast()); // "3.3"
        System.out.println(doubleList); // "2.2" -> null
    }

    public int countNodes() {
        if (head == null) {
            return 0;
        } else {
            int count = 1;
            Node<T> current = head;

            while (current.next != null) {
                current = current.next;
                count += 1;
            }
            return count;
        }
    }

    public void insertFirst(T data) {
        Node<T> newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void insertLast(T data) {
        Node<T> newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public boolean search(T val) {
        Node<T> current = head;
        while (current.next != null) {
            if (current.data.equals(val)) {
                return true;
            }
            current = current.next;
        }
        return current.data == val;
    }

    public T removeFirst() {
        if (head == null) {
            return null;
        }
        T hd = head.data;
        head = head.next;
        return hd;
    }

    public T removeLast() {
        Node<T> current = head;
        head = null;

        while (current != null && current.next != null) {
            insertLast(current.data);
            current = current.next;
        }
        return current.data;
    }

    public void removeAll(T val) {
        Node<T> current = head;
        head = null;

        while (current != null && current.next != null) {
            if (current.data != val)
                insertLast(current.data);
            current = current.next;
        }

        if (current != null && current.data != val)
            insertLast(current.data);
    }

    public void reverse() {
        Node<T> current = head;
        head = null;

        while (current != null && current.next != null) {
            insertFirst(current.data);
            current = current.next;
        }

        if (current != null)
            insertFirst(current.data);
    }

    public boolean hasCycle() {
        Node<T> current = head;
        List<T> result = new ArrayList<T>();
        while (current != null && current.next != null) {
            if (result.contains(current.data)) {
                return true;
            }
            result.add(current.data);
            current = current.next;
        }
        return false;
    }

    public String toString() {
        String str = "";
        Node<T> current = head;
        while (current != null) {
            str = str + current.data + " -> ";
            current = current.next;
        }
        str += "null";
        return str;
    }
}