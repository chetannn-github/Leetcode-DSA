class Solution {
    public int sumFourDivisors(int[] nums) {
        int result = 0;
        for(int num : nums) {
            result += findDivisorSum(num);
        }

        return result;
    }

    private int findDivisorSum(int num) {
        List<Integer> divisors = new ArrayList<>();

        int count = 2;
        int sum = 1 + num;
        
        for(int i=2; i <= (int) Math.sqrt(num); i++) {
            if(num % i == 0) {
                divisors.add(i);
                sum += i;
                count++;
                if(num/i != i) {
                    count++;
                    sum += num/i;
                }
            }

            if(count > 4) break;
        }

        return count == 4 ? sum : 0;
    }

}