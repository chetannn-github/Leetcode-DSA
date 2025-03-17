class Solution {
    public boolean divideArray(int[] nums) {
        int n = nums.length;
        if(n%2 == 1) return false;

        int[] freq = new int[501];
        
        for(int num : nums){
            freq[num]++;
        }

        for(int occr : freq){
            if(occr %2 == 1) return false;
        }
        return true;
    }
}