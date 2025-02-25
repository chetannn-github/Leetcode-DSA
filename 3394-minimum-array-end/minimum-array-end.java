class Solution {
    public long minEnd(int n, int x) {
        //phele dikkt yhh thii kii me n ko shift krr rha toh 31 bit tk pahuchte hii wo negative bn jaa rha thaaa kukii n tohh bhai int hain naa wo long thoriii hainn 
        // yhhh baat line 11 kii ho rhiii hhh
        n--;
        long N = n;
        long ans = x;
        long i = 0;

        while(N>0){
            if((x&1)==0){
                ans = ans | ((N&1)<<i) ;
                N >>=1;   
            }
            if(x>0) x >>= 1;
            
            i++;
        }
        return ans;
    
    }
}

