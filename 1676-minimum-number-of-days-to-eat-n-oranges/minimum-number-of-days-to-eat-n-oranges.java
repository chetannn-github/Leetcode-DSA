class Solution {
    HashMap<Integer,Integer> dp = new HashMap<>();
    public int minDays(int n) {
        return solve(n);
    }

    private int solve(int n) {
        if(n==0) return 0;
        if(dp.containsKey(n)) return dp.get(n);
        
        int opt1 = Integer.MAX_VALUE;
        int opt2 = Integer.MAX_VALUE;
        int opt3 = Integer.MAX_VALUE;

        if((n&1) == 0) {
            opt2 = 1 + solve(n/2);
        }else opt1 = 1 + solve(n-1);
        
        if((n%3) == 0) {
            opt3 = 1 + solve(n - 2 * (n/3));
        }else opt1 = 1 + solve(n-1);

        dp.put(n,Math.min(opt1, Math.min(opt2, opt3)));
        return dp.get(n);
    }
}