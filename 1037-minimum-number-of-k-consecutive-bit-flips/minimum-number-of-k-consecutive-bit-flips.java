class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        HashSet<Integer> isFlipped = new HashSet<>();

        int totalFlipCount = 0;
        int currFlip = 0;
        for(int i=0; i<n; i++) {
            if(isFlipped.contains(i-k)) currFlip--;
            
            if(nums[i] == currFlip%2) {
                if(i+k > n) return -1;
                currFlip++;
                totalFlipCount++;
                isFlipped.add(i);
            }
        }

        return totalFlipCount;
    }
}