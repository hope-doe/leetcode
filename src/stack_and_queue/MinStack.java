package stack_and_queue;

import java.util.Stack;

class MinStack {

    Stack<int[]> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        int min = stack.isEmpty() ? val : Math.min(stack.peek()[1], val);
        int[] pair = {val, min};

        stack.push(pair);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        if (stack.isEmpty()) throw new IllegalStateException("Illegal call on an empty stack");

        return stack.peek()[0];
    }

    public int getMin() {
        if (stack.isEmpty()) throw new IllegalStateException("Illegal call on an empty stack");

        return stack.peek()[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
