class MyQueue {
    Stack<Integer> st;
    public MyQueue() {
        this.st = new Stack<>();
    }
    
    public void push(int x) {
        if(st.isEmpty()) {
            st.push(x);
            return;
        }

        int val = st.pop();
        push(x);
        st.push(val);
        return;
    }
    
    public int pop() {
        return st.pop();
    }
    
    public int peek() {
        return st.peek();
    }
    
    public boolean empty() {
        return st.isEmpty();
    }
}

