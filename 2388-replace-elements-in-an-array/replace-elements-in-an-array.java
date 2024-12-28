class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int i = 0;
        for(int num : nums){
            hm.put(num, i);
            i++;
        }

        for(int[] op : operations){
            int idx = hm.get(op[0]);
            hm.put(op[1], idx);
            nums[idx] = op[1];
        }
        return nums;
    }
}