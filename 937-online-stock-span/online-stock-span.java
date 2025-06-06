class StockSpanner {
    List<Integer> st;
    int size = 0;
    public StockSpanner() {
        this.st = new ArrayList<>();
    }
    
    public int next(int price) {
        st.add(price);
        size++;
        int count = 0;

        for(int i= size-1; i>=0; i--){
            if(price < st.get(i)) break;
            count++;
        }

        return count;
        
    }
}
