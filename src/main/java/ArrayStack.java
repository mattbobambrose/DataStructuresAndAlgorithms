public class ArrayStack implements Stack {
    private int[] stack;
    private int head;
    private int capacity;

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        this.stack = new int[capacity];
        this.head = -1;
    }

    // The default size of our array will be 100
    public ArrayStack() {
        this(100);
    }

    public static void main(String[] args) {
        Stack stack = new ArrayStack();
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
    }

    // Pushes some data value to the top of the Stack
    public void push(int data) {
        head++;

        // Check to see if we need to add more space in our array
        if (head == capacity) {
            capacity *= 2;
            int[] newArr = new int[capacity];
            for (int i = 0; i < stack.length; i++) {
                newArr[i] = stack[i];
            }
            stack = newArr;
        }

        stack[head] = data;
    }

    // Pops some data value off the top of the Stack
    public int pop() {
        head--;
        return stack[head + 1];
    }

    // Returns the data value at the top of the stack without popping
    public int peek() {
        return stack[head];
    }

    // Checks whether or not the stack is empty
    public boolean isEmpty() {
        return (head == -1);
    }
}