class ProductOfNumbers {
    List<Integer> prefix;
    public ProductOfNumbers() {
       prefix  = new ArrayList<>();
       prefix.add(1);
    }
    
    public void add(int num) {
        if(num==0){
            prefix  = new ArrayList<>();
            prefix.add(1);
        }else{ 
            int last = prefix.size()-1;
            prefix.add(prefix.get(last)*num);
        }
    }
    
    public int getProduct(int k) {
        int size = prefix.size();
        
        // matlb khii zero aaya hogaa ussse size choti ho gyiii
        if(size-1<k){
            return 0;
        }

        return prefix.get(size-1) / prefix.get(size - 1 - k);                                          
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */