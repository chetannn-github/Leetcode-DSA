class MinStack {
    Stack<Integer> st;
    Stack<Integer> min;
    Integer minVal = Integer.MAX_VALUE;
    
    public MinStack() {
        st = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        minVal = Math.min(val,minVal);
        min.push(minVal);
    }
    
    public void pop() {
        st.pop();
        min.pop();
        minVal = min.isEmpty() ? Integer.MAX_VALUE : min.peek();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}

