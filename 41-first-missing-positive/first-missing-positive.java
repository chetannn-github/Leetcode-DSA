class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int currIdx = 0;

        while(currIdx < n) {
            int currVal = nums[currIdx];
            
            if(currVal > 0 && currVal <= n) {
                int expectedIdx = currVal - 1;
                if(nums[expectedIdx] != currVal) {
                    int temp = nums[expectedIdx];
                    nums[expectedIdx] = currVal;
                    nums[currIdx] = temp;
                }else currIdx++;
            } else currIdx++;
        }

        for(int i=0; i<n; i++) {
            if(nums[i] != i+1) return i+1;
        }

        return n+1;
    }
}