class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] degree = new int[n];

        for(int[] road : roads){
            degree[road[0]]++;
            degree[road[1]]++;
        }

        Arrays.sort(degree);

        int val = n;
        long ans = 0;

        for(int i=n-1; i>=0; i--){
            int currDegree = degree[i];
            ans += (long) n* currDegree;
            n--;
        }

        return ans;
    }
}