// public class Solution {
//     public boolean find132pattern(int[] nums) {
//         int minI = Integer.MAX_VALUE;
//         for (int j = 0; j < nums.length - 1; j++) {
//             minI = Math.min(minI, nums[j]);
//             if(minI == nums[j]) continue;
//             // i found out i and j  then ab k kii turn
//             for (int k = j + 1; k < nums.length; k++) {
//                 if (nums[k] < nums[j] && minI < nums[k]) return true;
//             }
//         }
//         return false;
//     }
// }


public class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int num3 = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < num3) {
                return true;
            }

            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                num3 = stack.pop();
            }
            stack.push(nums[i]);
        }

        return false;
    }
}