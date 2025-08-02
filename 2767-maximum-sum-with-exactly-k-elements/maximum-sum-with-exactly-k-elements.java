class Solution {
    public int maximizeSum(int[] nums, int k) {
        int maxVal = Integer.MIN_VALUE;
        for(int num : nums) maxVal = Math.max(maxVal,num);
        return (k * (2*maxVal + (k-1)))/2;
    }
}