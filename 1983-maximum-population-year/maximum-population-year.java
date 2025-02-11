class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] pop = new int[2051];
        for(int i=0; i<logs.length; i++){
            pop[logs[i][0]]++;
            pop[logs[i][1]]--;
        }
        int maxYear = 1950;
        for(int i=1950;i<2051;i++){
            pop[i] += pop[i-1];
            maxYear = pop[i] > pop[maxYear]? i : maxYear;
        }
    return maxYear;
}}