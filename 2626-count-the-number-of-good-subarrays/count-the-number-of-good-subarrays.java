class Solution {
    public long countGood(int[] nums, int k) {
        int n = nums.length;
        int pairs = 0;
        long subarrays = 0;
        int start = 0;

        HashMap<Integer,Integer> hm = new HashMap<>();

        for(int end=0; end<n; end++){
            hm.put(nums[end], hm.getOrDefault(nums[end],0)+1);
            pairs += hm.get(nums[end])-1;

            while(pairs>=k){
                subarrays += n - end; // kyuki aage waale tohh good hogee hiii naa
                hm.put(nums[start], hm.get(nums[start]) -1 );
                pairs -= hm.get(nums[start]);
                start++;
            }
        }

        return subarrays;
    }
}