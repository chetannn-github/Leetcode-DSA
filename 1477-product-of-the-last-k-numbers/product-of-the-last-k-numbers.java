class ProductOfNumbers {
    List<Integer> prefix;
    int size = 0;
    public ProductOfNumbers() {
       prefix  = new ArrayList<>();
       prefix.add(1);
       size =1;
    }
    
    public void add(int num) {
        if(num==0){
            prefix  = new ArrayList<>();
            prefix.add(1);
            size = 1;
        }else{ 
            int last = size - 1;
            prefix.add(prefix.get(last)*num);
            size++;
        }
    }
    
    public int getProduct(int k) {
        // matlb khii zero aaya hogaa ussse size choti ho gyiii
        if(size-1<k){
            return 0;
        }

        return prefix.get(size-1) / prefix.get(size - 1 - k);                                          
    }
}
