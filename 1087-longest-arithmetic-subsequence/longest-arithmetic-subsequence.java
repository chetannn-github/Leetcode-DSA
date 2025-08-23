class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        HashSet<Integer> possibleD = new HashSet<>();
        for(int i=0; i<n-1; i++) {
            for(int j=i+1; j<n; j++) {
                int d = nums[j] - nums[i];
                possibleD.add(d);
            }
        }
        int maxLength = 0;
        for(int d : possibleD) {
            HashMap<Integer,Integer> dp = new HashMap<>();
            for(int num : nums) {
                dp.put(num, dp  .getOrDefault(num - d, 0) + 1);
                maxLength = Math.max(maxLength, dp  .get(num));
            }
        }   

        return maxLength;
    }
}