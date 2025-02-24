class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        for(int i= 0; i<=n; i++){
            ans[i] = count(i);
        }
        return ans;
    }
    public int count(int n){
        if(n>0 && ((n & (n-1)) == 0)){return 1;}

        int ans = 0;
        while(n!=0){
            ans += (n&1);
            n >>=1;
        }
        return ans;
    }
}