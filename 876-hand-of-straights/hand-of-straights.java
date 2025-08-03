class Solution {
    public boolean isNStraightHand(int[] nums, int k) {
        int n = nums.length;
        if(n % k != 0) return false;

        Arrays.sort(nums);
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int num : nums) {
            hm.put(num, hm.getOrDefault(num,0) + 1);
        }


        for(int i=0; i<n; i++) {
            if(hm.containsKey(nums[i])) {
                int K = k;
                while(K-->0) {
                    int next = nums[i] + K;
                    if(hm.containsKey(next)) {
                        hm.put(next, hm.get(next) - 1);

                        if(hm.get(next) == 0) hm.remove(next);

                    }else return false;
                }
            }
        }

        return hm.size() == 0;
    }
}