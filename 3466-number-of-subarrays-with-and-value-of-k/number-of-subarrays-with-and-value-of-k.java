class Solution {
    public long countSubarrays(int[] nums, int k) {
        Map<Integer, Integer> prev = new HashMap<>();
        long result = 0;

        for (int num : nums) {
            Map<Integer, Integer> curr = new HashMap<>();

            // Extend previous subarrays
            for (Map.Entry<Integer, Integer> entry : prev.entrySet()) {
                int newAnd = entry.getKey() & num;
                curr.put(newAnd, curr.getOrDefault(newAnd, 0) + entry.getValue());
            }

            // Start new subarray from current number
            curr.put(num, curr.getOrDefault(num, 0) + 1);

            // Count subarrays with AND == k
            result += curr.getOrDefault(k, 0);

            // Move to next index
            prev = curr;
        }

        return result;
    }
}
