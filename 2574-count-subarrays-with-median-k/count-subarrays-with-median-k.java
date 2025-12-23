class Solution {
    public int countSubarrays(int[] nums, int k) {
        // big - small == 0 Or big - small == 1
        int n = nums.length;
        int idx = 0;

        for(int i = 0; i < n; i++) {
            if(nums[i] == k) {
                idx = i;
                break;
            }
        }

        Map<Integer, Integer> count = new HashMap<>();
        count.put(0, 1);

        int diff = 0;
        for (int i = idx - 1; i>=0; i--) {
            if (nums[i] > k) diff++;
            else diff--;
            count.put(diff, count.getOrDefault(diff, 0) + 1);
        }

        int result = 0;
        diff = 0;

        for(int i = idx; i<n; i++) {
            if(nums[i] > k) diff++;
            else if(nums[i] < k) diff--;

            result += count.getOrDefault(-diff, 0);
            result += count.getOrDefault(1 - diff, 0);
        }

        return result;
    }
}
