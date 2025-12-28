class Solution {
    public long sumDigitDifferences(int[] nums) {
        int digits = (int) Math.log10(nums[0]) + 1;

        HashMap<Integer,Long>[] digitMap = new HashMap[digits];

        for(int i=0; i<digits; i++) {
            digitMap[i] = new HashMap<>();
        }

        for(int i=0; i<digits; i++) {
            for(int j=0; j<nums.length; j++) {
                int lastDigit = nums[j] % 10;
                digitMap[i].put(lastDigit,digitMap[i].getOrDefault(lastDigit,0L) + 1L);
                nums[j] /= 10;
            }
        }

        long result = 0L;
        for(HashMap<Integer,Long> map : digitMap) {
            long cumSum = 0;

            for(int key : map.keySet()) {
                long freq = map.get(key);
                result = result + (cumSum * map.get(key));
                cumSum += freq;
            }
        }

        

        return result;
    }
}