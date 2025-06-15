class MyStack {
    Queue<Integer> queue;
    public MyStack() {
        this.queue = new LinkedList<>();
    }
    
    public void push(int x) {
        if(queue.isEmpty()) {
            queue.add(x);
            return;
        }

        queue.add(x);
        int size = queue.size();
        
        for (int i = 0; i < size - 1; i++) {
            queue.add(queue.remove());
        }
    }
    
    public int pop() {
        return queue.remove();
    }
    
    public int top() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}
