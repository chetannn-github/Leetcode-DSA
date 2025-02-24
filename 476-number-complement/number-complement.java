class Solution {
    public int findComplement(int n) {
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