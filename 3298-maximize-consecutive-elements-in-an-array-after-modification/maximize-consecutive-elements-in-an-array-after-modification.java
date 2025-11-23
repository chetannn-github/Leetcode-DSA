class Solution {
    
    public int maxSelectedElements(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> dp = new HashMap<>();
        Arrays.sort(nums);

        int maxLength = 1;
        for(int num : nums) {
            dp.put(num+1, dp.getOrDefault(num,0) +1);
            dp.put(num, dp.getOrDefault(num-1,0) + 1);
            
            maxLength = Math.max(Math.max(dp.get(num+1),dp.get(num)),maxLength);
        }

        return maxLength;
    }


    
}