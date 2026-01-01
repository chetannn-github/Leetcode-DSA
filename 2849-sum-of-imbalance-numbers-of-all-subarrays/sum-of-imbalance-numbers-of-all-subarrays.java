class Solution {
    public int sumImbalanceNumbers(int[] nums) {
        int result = 0;
        int n = nums.length;

        for(int i=0; i<n; i++) {
            HashSet<Integer> set = new HashSet<>();
            int imbalance = 0;

            for(int j=i; j<n; j++) {
                int curr = nums[j], next = curr+1 , prev = curr-1;

                if(!set.contains(curr)) {
                    if(set.contains(prev) && set.contains(next)) imbalance--;
                    else if(!set.isEmpty() && !set.contains(prev) && !set.contains(next)) imbalance++;
                }
                set.add(curr);
                result += imbalance;
            }
           
        }

        return result;
    }
}