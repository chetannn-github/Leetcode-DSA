class Solution {
    public int minimumDeviation(int[] nums) {
        int n = nums.length;
        int minVal = Integer.MAX_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b-a));
        
        for(int i=0; i<n; i++) {
            nums[i] = (nums[i] & 1) == 1 ? 2 * nums[i] : nums[i];
            minVal = Math.min(minVal,nums[i]);
            pq.add(nums[i]);
        }

        int minDeviation = Integer.MAX_VALUE;

        while((pq.peek() & 1) == 0) {
            int maxVal = pq.remove();
            int currDeviation = maxVal - minVal;

            minDeviation = Math.min(minDeviation,currDeviation);

            pq.add(maxVal/2);
            minVal = Math.min(minVal,maxVal/2);
        }
        
        minDeviation = Math.min(minDeviation,pq.remove() - minVal);
        return minDeviation;

    }
}