class Solution {
    public int[] numberGame(int[] nums) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] ans = new int[n];

        for(int num : nums){ 
            pq.add(num);
        }
        int idx = 0;
        while(!pq.isEmpty()){
            int alice = pq.remove();
            int bob = pq.remove();

            ans[idx++] = bob;
            ans[idx++] = alice;
        }
        return ans;
    }
}