class Solution {
    public long countSubarrays(int[] nums, int k) {
        Map<Integer, Integer> prev = new HashMap<>();
        long result = 0;

        for (int num : nums) {
            Map<Integer, Integer> curr = new HashMap<>();

            for (Integer key : prev.keySet()) {
                int newAnd = key & num;
                curr.put(newAnd, curr.getOrDefault(newAnd, 0) + prev.get(key));
            }

            curr.put(num, curr.getOrDefault(num, 0) + 1);

            result += curr.getOrDefault(k, 0);

            prev = curr;
        }

        return result;
    }
}
