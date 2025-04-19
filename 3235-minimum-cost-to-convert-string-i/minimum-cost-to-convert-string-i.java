class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long[][] minCost = new long[26][26];
        for(long[] row : minCost){
            Arrays.fill(row,Long.MAX_VALUE);
        }
        for(int i=0; i<original.length; i++){
            int from = original[i] - 'a';
            int to = changed[i] - 'a';
             minCost[from][to] = Math.min(minCost[from][to], (long)cost[i]); 
        }

        for(int via = 0; via<26; via++){
            for(int i=0; i<26; i++){
                for(int j=0; j<26; j++){
                    if(i==j) {
                        minCost[i][i] = 0L;
                        continue;
                    }
                    if(minCost[i][via] != Long.MAX_VALUE && minCost[via][j] != Long.MAX_VALUE){
                        long viaCost = (long) minCost[i][via] + minCost[via][j];
                        if(viaCost < minCost[i][j]){
                            minCost[i][j] = viaCost;
                        }
                    }
                }
            }
        }
        long minCostSum = 0;
        for(int i=0; i<source.length(); i++){
            int from = source.charAt(i) - 'a';
            int to = target.charAt(i) - 'a';

            if(minCost[from][to] == Long.MAX_VALUE) return -1;
            minCostSum += minCost[from][to];
        }

        return minCostSum ;
    }
}