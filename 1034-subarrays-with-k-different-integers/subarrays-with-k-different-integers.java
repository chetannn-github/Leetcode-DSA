class Solution {
    int[] nums;
    public int subarraysWithKDistinct(int[] nums, int k) {
        this.nums = nums;
        return solve(k) - solve(k-1);
    }

    private int solve(int k) {
        int diff = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        int start = 0;
        int subarrays = 0;

        for(int end=0; end<nums.length; end++) {
            hm.put(nums[end],hm.getOrDefault(nums[end],0) + 1);
            if(hm.get(nums[end]) == 1) diff++;


            while(diff > k) {
                hm.put(nums[start], hm.get(nums[start])-1);
                if(hm.get(nums[start]) == 0) diff--;
                start++;
            }
            subarrays += end - start + 1;
        }

        return subarrays;
    }
}