public class ArrayQueue implements Queue {
    private int[] queue;
    private int tail;
    private int head;
    private int capacity;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.tail = -1;
        this.head = 0;
    }

    // The default size of our array will be 100
    public ArrayQueue() {
        this(100);
    }

    public static void main(String[] args) {
        Queue queue = new ArrayQueue(5);
        queue.enqueue(10);
        queue.enqueue(5);
        queue.enqueue(2);
        queue.enqueue(7);

        System.out.println(queue.peek()); // 10

        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
        // 10
        // 5
        // 2
        // 7
    }

    public void enqueue(int data) {
        tail++;

        // Check to see if we need to add more space in our array
        if (tail == capacity) {
            capacity *= 2;
            int[] newArr = new int[capacity];
            for (int i = 0; i < queue.length; i++) {
                newArr[i] = queue[i];
            }
            queue = newArr;
        }

        queue[tail] = data;
    }

    public int dequeue() {
        return queue[head++];
    }

    public int peek() {
        return queue[head];
    }

    public boolean isEmpty() {
        return head - 1 == tail;
    }
}