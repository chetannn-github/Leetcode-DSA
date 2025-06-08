class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];
            if (hm.containsKey(complement)) {
                return new int[]{hm.get(complement), i};
            }
            hm.put(nums[i], i);
        }

        return new int[]{}; 
    }
}


// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         for(int i=1; i<nums.length; i++){
//             for(int j=i; j<nums.length; j++){
//                 if(nums[j] + nums[j-i] == target){
//                   return new int[] {j,j-i}; 
//                 }
//             }
//         }
//         return null;
//     }
// }
