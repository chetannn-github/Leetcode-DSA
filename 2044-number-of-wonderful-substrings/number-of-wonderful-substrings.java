class Solution {
    public long wonderfulSubstrings(String s) {
        long result = 0;
        int mask = 0;
        HashMap<Integer, Integer> seen = new HashMap<>();
        seen.put(0, 1);  // base case

        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - 'a';
            mask ^= (1 << digit);

            // Case 1: all even frequency
            if (seen.containsKey(mask)) {
                result += seen.get(mask);
                seen.put(mask,seen.get(mask) + 1);
            } else {
                seen.put(mask, 1);
            }

            // Case 2: one odd frequency allowed
            for (int j = 0; j < 26; j++) {
                int maskWithOneBitFlipped = mask ^ (1 << j);
                if (seen.containsKey(maskWithOneBitFlipped)) {
                    result += seen.get(maskWithOneBitFlipped);
                }
            }
        }

        return result;
    }
}