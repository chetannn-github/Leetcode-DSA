class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int n = happiness.length;
        long happinessSum = 0;

        for(int i=n-1; i>=0 && k > 0; i--, k--) {
            happinessSum += Math.max(happiness[i] - (n-1-i), 0); 
        }

        return happinessSum;
    }
}