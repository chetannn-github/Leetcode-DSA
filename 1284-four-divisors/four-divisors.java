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
        divisors.add(1);
        divisors.add(num);

        for(int i=2; i <= (int) Math.sqrt(num); i++) {
            if(num % i == 0) {
                divisors.add(i);
                if(num/i != i) divisors.add(num/i);
            }
        }

        return divisors.size() == 4 ? getSum(divisors) : 0;
    }


    private int getSum(List<Integer> nums) {
        int totalSum = 0;
        for(int num : nums) totalSum += num;
        return totalSum;
    }
}