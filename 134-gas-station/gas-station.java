class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int minGasNeeded = 0; 
        int n = gas.length;

        for(int i=0; i<n; i++) {
            minGasNeeded += gas[i] - cost[i];
            gas[i] -= cost[i];
        }
        if(minGasNeeded < 0) return -1;

        int cs = 0, result = 0;
        for(int i=0; i<n; i++) {
            if(cs < 0) {
                cs = gas[i];
                result = i;
            }else {
                cs += gas[i];
            }
        }

        return result;


    }
}