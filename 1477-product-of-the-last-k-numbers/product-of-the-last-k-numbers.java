class ProductOfNumbers {
    List<Integer> data;
    public ProductOfNumbers() {
       data  = new ArrayList<>();
    }
    
    public void add(int num) {
        data.add(num);
    }
    
    public int getProduct(int k) {
        int size = data.size();
        int prod = 1;
        for(int i= size-1; i>size-1-k ; i--){
            prod *= data.get(i);
        }
        return prod;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */