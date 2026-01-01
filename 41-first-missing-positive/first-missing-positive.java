class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        
        for(int i=0; i<n;) {
            if(nums[i] <= n && nums[i] > 0) {
                int currPos = nums[i] - 1;

                if(nums[currPos] != nums[i]) {
                    int temp = nums[currPos];
                    nums[currPos] = nums[i];
                    nums[i] = temp;
                }else i++;
            }else i++;
        }

        for(int i=0; i<n; i++) {
            if(nums[i] < 0 || nums[i] > n) return i+1;
            if(nums[i] != i+1) return i+1;

        
        }

        return n+1;
    }
}