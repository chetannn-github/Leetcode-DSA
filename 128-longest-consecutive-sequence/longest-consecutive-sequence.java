class Solution { 
    int maxLength = 0;
    HashMap<Integer,Integer> dp = new HashMap<>();
    HashSet<Integer> set = new HashSet<>();
    public int longestConsecutive(int[] nums) {
       
        for(int num : nums) {
            set.add(num);
        }

        
        for(int num : nums) dfs(num);
        
        return maxLength;
    }

    private int dfs(int curr) {
        if(dp.containsKey(curr)) return dp.get(curr);
        if(!set.contains(curr)) return 0;

    
        int result = 1 + dfs(curr-1);
        dp.put(curr,result);
        maxLength = Math.max(result,maxLength);
        return result;
    }
}