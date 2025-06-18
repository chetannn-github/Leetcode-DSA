class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        // esi subrray batani hh jisme saare elements distinct ho aur sum max ho
        int start = 0;
        int maxSum = 0;
        int sum = 0;
        int n = nums.length;
        HashSet<Integer> hs = new HashSet<>();

        for(int end =0; end<n; end++){

            while(hs.size()>0 && hs.contains(nums[end])){
                sum -= nums[start];
                hs.remove(nums[start]);
                start++;
            }
            hs.add(nums[end]);
            sum += nums[end];
            
            maxSum = Math.max(sum,maxSum);
        }

        return maxSum;

    
    }
}