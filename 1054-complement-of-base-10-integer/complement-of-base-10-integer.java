class Solution {
    public int bitwiseComplement(int n) {
        if(n==0){
            return 1;
        }
        int ans = 0;
        int p = 0;
        while(n!=0){
            if((n&1) == 0){
                ans |= (1 << p);
            }
            p++;
            n>>=1;
        }
        return ans;  
    }
}