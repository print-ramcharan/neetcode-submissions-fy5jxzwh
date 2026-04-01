class MinStack {
    long min; // Change min to long
    Stack<Long> stack; // Change stack to store Long values

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push((long) val);
            min = val;
        } else {
            if (val < min) {
                // Use long to avoid overflow
                stack.push(2L * val - min); // Encoding using long
                min = val;
            } else {
                stack.push((long) val);
            }
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        long top = stack.pop();
        if (top < min) {
            // Decode the previous minimum
            min = 2L * min - top;
        }
    }

    public int top() {
        long top = stack.peek();
        if (top < min) {
            // Return the current minimum if the top is encoded
            return (int) min;
        }
        return (int) top;
    }

    public int getMin() {
        return (int) min; // Return min as an int
    }
}
