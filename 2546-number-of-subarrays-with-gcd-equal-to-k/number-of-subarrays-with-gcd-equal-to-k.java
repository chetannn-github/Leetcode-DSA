class Solution {
    public int subarrayGCD(int[] nums, int k) {
        Map<Integer, Integer> prev = new HashMap<>();
        int result = 0;

        for (int num : nums) {
            Map<Integer,Integer> curr = new HashMap<>();

            for(Integer key : prev.keySet()) {
                int newAnd = gcd(key,num);
                curr.put(newAnd, curr.getOrDefault(newAnd, 0) + prev.get(key));
            }

            curr.put(num, curr.getOrDefault(num, 0) + 1);
            result += curr.getOrDefault(k, 0);
            prev = curr;
        }

        return result;
    }

    private int gcd(int a, int b) {
        if(b == 0) return a;

        return gcd(b,a%b);
    }
}