class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
        });
        
        for(int i=0; i<nums.length; i++){
            pq.add(new int[] { nums[i], i});
        }

        while(k!=0){
            int[] minPair = pq.remove();
            int minVal =  minPair[0];
            int minIdx = minPair[1];

            nums[minIdx] *= multiplier;

            pq.add(new int[]{nums[minIdx],minIdx}); 
            k--;
        }

        return nums;
    }
}