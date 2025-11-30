class Solution {
    int k;
    HashMap<String,Integer> dp = new HashMap<>();
    public int waysToReachStair(int k) {
        this.k = k;
        return solve(1,0,0);
    }

    private int solve(int curr, int jump, int prev) {
        if(curr -1 > k) return 0;
        String key = curr + " " + jump + " " + prev;
        if(dp.containsKey(key)) return dp.get(key);

        int result = (curr == k ? 1 : 0) ;
        if(curr != 0 && prev == 0) {
            result += solve(curr-1,jump,1);
        }
        
        result += solve(curr + (int) Math.pow(2,jump), jump+1, 0);

        dp.put(key,result);
        return result;
    }
}