import java.util.Stack;

/**
 * 155. 最小栈
 * 维护一个辅助栈
 */
class MinStack {
    Stack<Integer> data = new Stack<>();
    Stack<Integer> min = new Stack<>();
    
    public MinStack() {
    }
    
    public void push(int x) {
        data.push(x);
        if (min.isEmpty() || min.peek() > x) {
            min.push(x);
        } else {
            min.push(min.peek());
        }
    }
    
    public void pop() {
        data.pop();
        min.pop();
    }
    
    public int top() {
        return data.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
