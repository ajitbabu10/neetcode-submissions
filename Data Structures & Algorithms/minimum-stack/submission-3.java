class MinStack {

    long min;
    Stack<Long> stack;

    public MinStack() {
        min = Integer.MAX_VALUE;
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if(stack.isEmpty()) {
            stack.push((long) val);
            min = (long) val;
        } 
        else {
            if(val > min) {
                stack.push((long) val);
            } else {
                stack.push((long) 2*val - min);
                min = (long) val;
            }
        }
    }
    
    public void pop() {
        long val = stack.pop();
        if(val < min) { //It is modified
            min = 2*min - val;
        } 
    }
    
    public int top() {
        long peek = stack.peek();
        if(peek < min) {
            return (int) min;
        }
        return (int) peek;
    }
    
    public int getMin() {
        return (int) min;
    }
}
