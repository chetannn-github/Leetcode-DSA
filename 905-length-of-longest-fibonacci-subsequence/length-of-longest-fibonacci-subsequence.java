class Solution {
    public int lenLongestFibSubseq(int[] nums) {
        int maxLength = 0;
        HashSet<Integer> hs = new HashSet<>();
        int N = nums.length;
        for(int num : nums ) hs.add(num);

        for(int i=0; i<N; i++) {
            for(int j=i+1; j<N; j++) {
                int length = 0;
                int curr = nums[j];
                int prev = nums[i];
                int next = prev + curr;
                
                
                while(hs.contains(next)) {
                    length++;
                    prev = curr;
                    curr = next;
                    next = prev + curr;
                }
                maxLength = Math.max(length,maxLength);
            }
        }

        return maxLength == 0 ? 0 : maxLength + 2;
    }
}