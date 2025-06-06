class CustomStack {
    int[] st;
    int idx;
    public CustomStack(int maxSize) {
        this.st = new int[maxSize];
        this.idx = 0;
    }
    
    public void push(int x) {
        if(idx >= st.length) return;
        st[idx++] = x;
    }
    
    public int pop() {
        if(idx > 0){
            idx--;
            return st[idx];
        }
        return -1;
    }
    
    public void increment(int k, int val) {
        for(int i = 0; k>0 && i<idx; i++, k--){
            st[i] += val;
        }
    }
}

