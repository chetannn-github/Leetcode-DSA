class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int idx = 0, icecreams = 0;
        int n = costs.length;
        
        while(idx < n) {
            if(costs[idx] <= coins) {
                coins -= costs[idx];
                icecreams++;
            }else {
                return icecreams;
            }
            idx++;
        }

        return icecreams;
    }
}