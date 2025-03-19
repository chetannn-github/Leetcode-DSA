class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashMap<Integer,Integer> hm = new HashMap<>();

        for(int num : nums){
            pq.add(num);
            hm.put(num,hm.getOrDefault(num,0)+1);
        }
        int count = 0;

        while(count!=n-k){
            int min = pq.remove();
            hm.put(min,hm.get(min)-1);
            count++;
        }
        
        int[] ans = new int[k];
        int currIdx = 0;
        for(int num : nums){
            if(hm.get(num)>0){
                hm.put(num,hm.get(num)-1);
                ans[currIdx++] = num;
            }
            if(currIdx==k) return ans;
        }
        
        return ans;
    }
}