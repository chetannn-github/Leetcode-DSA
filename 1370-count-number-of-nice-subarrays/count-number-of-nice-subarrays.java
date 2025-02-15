// class Solution {

//     public int numberOfSubarrays(int[] nums, int k) {
//         int currSum = 0; 
//         int  ans = 0;
//         Map<Integer, Integer> hm = new HashMap<>();
//         hm.put(0,1);

//         for (int i = 0; i < nums.length; i++) {
//             currSum += nums[i] &1 ;
//             if (hm.containsKey(currSum - k)) {
//                 ans = ans + hm.get(currSum - k);
//             }
//             hm.put(currSum, hm.getOrDefault(currSum, 0) + 1);
//         }

//         return ans;
//     }
// }


class Solution {

    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k) {
        int size = 0;
        int ans = 0;
        int start = 0;

        for (int end = 0; end < nums.length; end++) {
            size += nums[end] % 2;

            while (size > k) {
                size -= nums[start] % 2;
                start++;
            }
            ans += end - start + 1;
        }

        return ans;
    }
}