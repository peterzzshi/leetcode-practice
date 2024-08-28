import java.util.EmptyStackException;
import java.util.Stack;

class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(final int val) {
        this.stack.push(val);
        if (this.minStack.isEmpty() || this.minStack.peek() > val) {
            this.minStack.push(val);
        }
    }

    public void pop() {
        if (!this.stack.isEmpty()) {
            if (this.stack.peek().equals(this.minStack.peek())) {
                this.minStack.pop();
            }
            this.stack.pop();
        }
    }

    public int top() {
        if (this.stack.isEmpty()) {
            throw new EmptyStackException();
        }
        return this.stack.peek();
    }

    public int getMin() {
        if (this.minStack.isEmpty()) {
            throw new EmptyStackException();
        }
        return this.minStack.peek();
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