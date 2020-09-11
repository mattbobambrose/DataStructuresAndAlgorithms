public class ArrayStack implements Stack {
    public int[] iar;
    public boolean[] bar;

    public ArrayStack(int size) {
        iar = new int[size];
        bar = new boolean[size];
    }

    public static void main(String[] args) {
        Stack stack = new ArrayStack(4);
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

    @Override
    public void push(int data) {
        for (int i = 0; i < bar.length; i++) {
            if (bar[i] == false) {
                iar[i] = data;
                bar[i] = true;
            }
        }
    }

    @Override
    public int pop() {
        if (bar[0] == false) {
            return 0;
        }
        for (int i = 0; i < bar.length; i++) {
            if (bar[i] == false) {
                int d = iar[i - 1];
                iar[i - 1] = 0;
                bar[i - 1] = false;
                return d;
            }
        }
        if (bar[bar.length - 1] == true) {
            int v = iar[iar.length - 1];
            iar[iar.length - 1] = 0;
            bar[bar.length - 1] = false;
            return v;
        }
    }

    @Override
    public int peek() {
        if (bar[0] == false) {
            return 0;
        }
        for (int i = 0; i < bar.length; i++) {
            if (bar[i] == false) {
                return iar[i - 1];
            }
        }
        return iar[iar.length - 1];
    }

    @Override
    public boolean isEmpty() {
        return bar[0] == false;
    }
}