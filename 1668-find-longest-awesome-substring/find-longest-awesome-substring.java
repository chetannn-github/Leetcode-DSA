public class Solution {
    public int longestAwesome(String s) {
        int result = 0;
        int mask = 0;
        HashMap<Integer, Integer> seen = new HashMap<>();
        seen.put(0, -1);  // base case

        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - '0';
            mask ^= (1 << digit);

            // Case 1: all even frequency
            if (seen.containsKey(mask)) {
                result = Math.max(result, i - seen.get(mask));
            } else {
                seen.put(mask, i);
            }

            // Case 2: one odd frequency allowed
            for (int j = 0; j < 10; j++) {
                int maskWithOneBitFlipped = mask ^ (1 << j);
                if (seen.containsKey(maskWithOneBitFlipped)) {
                    result = Math.max(result, i - seen.get(maskWithOneBitFlipped));
                }
            }
        }

        return result;
    }
}
