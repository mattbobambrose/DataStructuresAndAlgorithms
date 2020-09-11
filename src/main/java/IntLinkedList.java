import java.util.ArrayList;
import java.util.List;

public class IntLinkedList implements Stack {
    private IntNode head;

    public IntLinkedList() {
        head = null;
    }

    public static void main(String[] args) {
        //Stack tests
        Stack stack = new IntLinkedList();
        stack.push(10);
        stack.push(5);
        stack.push(2);
        stack.push(7);

        System.out.println(stack.peek()); // 7

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
// 7
// 2
// 5
// 10

        //Regular IntLinkedList tests

        // Test 1: insertFirst method
        // We are going to make a list containing 4 -> 2 -> 3 -> null
        System.out.println("Test 1:");
        IntLinkedList list1 = new IntLinkedList();
        list1.insertFirst(3);
        list1.insertFirst(2);
        list1.insertFirst(4);
        System.out.println(list1); // 4 -> 2 -> 3 -> null

        // Test 2: insertLast method
        // We are going to make a list containing 7 -> 2 -> 5 -> 10 -> null
        System.out.println("\nTest 2:");
        IntLinkedList list2 = new IntLinkedList();
        list2.insertLast(7);
        list2.insertLast(2);
        list2.insertLast(5);
        list2.insertLast(10);
        System.out.println(list2); // 7 -> 2 -> 5 -> 10 -> null

        // Test 3: search method
        System.out.println("\nTest 3:");
        System.out.println(list2.search(7)); // true
        System.out.println(list2.search(2)); // true
        System.out.println(list2.search(5)); // true
        System.out.println(list2.search(10)); // true
        System.out.println(list2.search(13)); // false

        // Test 4: removeFirst method
        System.out.println("\nTest 4:");
        list1.removeFirst();
        System.out.println(list1); // 2 -> 3 -> null

        list2.removeFirst();
        System.out.println(list2); // 2 -> 5 -> 10 -> null
        list2.removeFirst();
        System.out.println(list2); // 5 -> 10 -> null

        // Test 5: removeLast method
        System.out.println("\nTest 5:");
        list1.removeLast();
        System.out.println(list1); // 2 -> null
        list1.removeLast();
        System.out.println(list1); // null

        list2.removeFirst();
        System.out.println(list2); // 10 -> null
        list2.removeFirst();
        System.out.println(list2); // null

        // Test 6: removeAll method
        System.out.println("\nTest 6:");
        IntLinkedList list3 = new IntLinkedList();
        list3.insertLast(1);
        list3.insertLast(2);
        list3.insertLast(6);
        list3.insertLast(3);
        list3.insertLast(4);
        list3.insertLast(6);
        list3.insertLast(5);
        list3.insertLast(6);
        list3.removeAll(6);
        System.out.println(list3); // 1 -> 2 -> 3 -> 4 -> 5 -> null

        list3 = new IntLinkedList();
        list3.insertLast(6);
        list3.insertLast(5);
        list3.insertLast(3);
        list3.insertLast(6);
        list3.insertLast(1);
        list3.insertLast(2);
        list3.insertLast(6);
        list3.insertLast(0);
        list3.removeAll(6);
        System.out.println(list3); // 5 -> 3 -> 1 -> 2 -> 0 -> null

        list3 = new IntLinkedList();
        list3.insertLast(6);
        list3.insertLast(6);
        list3.insertLast(6);
        list3.insertLast(6);
        list3.insertLast(6);
        list3.removeAll(6);
        System.out.println(list3); // null

// Test 7: reverse
        System.out.println("\nTest 7:");
        IntLinkedList list4 = new IntLinkedList();
        list4.insertLast(3);
        list4.insertLast(2);
        list4.insertLast(4);
        list4.reverse();
        System.out.println(list4); // 4 -> 2 -> 3 -> null

// Test8: hasCycle
        System.out.println("\nTest 8:");
        IntLinkedList list5 = new IntLinkedList();
        list5.insertLast(3);
        list5.insertLast(2);
        list5.insertLast(4);
        list5.head.next.next.next = list5.head;
        System.out.println(list5.hasCycle()); // true

        list5 = new IntLinkedList();
        list5.insertLast(3);
        list5.insertLast(2);
        list5.insertLast(4);
        list5.insertLast(5);
        list5.head.next.next.next.next = list5.head.next;
        System.out.println(list5.hasCycle()); // true

        list5 = new IntLinkedList();
        list5.insertLast(3);
        list5.insertLast(2);
        list5.insertLast(4);
        list5.insertLast(5);
        System.out.println(list5.hasCycle()); // false*/
    }

    //Stack Stuff

    @Override
    public void push(int data) {
        insertLast(data);
    }

    @Override
    public int pop() {
        return removeLast();
    }

    @Override
    public int peek() {
        IntNode current = head;
        while (current != null && current.next != null) {
            current = current.next;
        }
        return current.data;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    //Regular IntLinkedList Stuff

    // Returns the total number of nodes in the Linked List
    public int countNodes() {
        if (head == null) {
            return 0;
        } else {
            int count = 1;
            IntNode current = head;

            while (current.next != null) {
                current = current.next;
                count += 1;
            }
            return count;
        }
    }

    // Inserts a new node at the front of the LinkedList (prepend)
    public void insertFirst(int data) {
        IntNode newNode = new IntNode(data);
        newNode.next = head;
        head = newNode;
    }

    // Inserts a new node at the back of the LinkedList (append)
    public void insertLast(int data) {
        IntNode newNode = new IntNode(data);
        if (head == null) {
            head = newNode;
        } else {
            IntNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Returns true if val is present in the list, and false otherwie
    public boolean search(int val) {
        IntNode current = head;
        while (current.next != null) {
            if (current.data == val) {
                return true;
            }
            current = current.next;
        }
        return current.data == val;
    }

    // Removes the first node from the LinkedList, and returns its data value
    public int removeFirst() {
        if (head == null) {
            return -1;
        }
        int hd = head.data;
        head = head.next;
        return hd;
    }

    // Removes the last node from the LinkedList, and returns its data value
    public int removeLast() {
        IntNode current = head;
        head = null;

        while (current != null && current.next != null) {
            insertLast(current.data);
            current = current.next;
        }
        if (current == null)
            return -1;
        else
            return current.data;
    }

    public void removeAll(int val) {
        IntNode current = head;
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
        IntNode current = head;
        head = null;

        while (current != null && current.next != null) {
            insertFirst(current.data);
            current = current.next;
        }

        if (current != null)
            insertFirst(current.data);
    }

    public boolean hasCycle() {
        IntNode current = head;
        List<Integer> result = new ArrayList<>();
        while (current != null && current.next != null) {
            if (result.contains(current.data)) {
                return true;
            }
            result.add(current.data);
            current = current.next;
        }
        return false;
    }

    // toString function that is called when LinkedList is printed
    public String toString() {
        StringBuilder str = new StringBuilder();
        IntNode current = head;
        while (current != null) {
            str.append(current.data).append(" -> ");
            current = current.next;
        }
        str.append("null");
        return str.toString();
    }
}