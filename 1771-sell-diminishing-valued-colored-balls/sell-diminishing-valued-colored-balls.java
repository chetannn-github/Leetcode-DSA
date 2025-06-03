// class Solution {
//     int MOD = 1_000_000_007;
//     public int maxProfit(int[] inventory, int orders) {
//         HashMap<Integer,Integer> hm = new HashMap<>();
//         int max = Integer.MIN_VALUE;

//         for(int num : inventory) {
//             hm.put(num, hm.getOrDefault(num,0)  + 1);
//             max = Math.max(num,max);
//         }
//         long ans = 0;
//         while(orders>0) {
//             int maxFreq = hm.get(max);


//             if(orders > maxFreq){
//                 ans += (maxFreq * max);
//             }else {
//                 ans += orders * max;
//             }
            
//             ans %= MOD;
//             max--;
//             orders -= maxFreq;
//             hm.put(max, hm.getOrDefault(max,0)  + maxFreq);
            
//         }
        
//         return (int) ans;
//     }
// }


class Solution {
    public int maxProfit(int[] inventory, int orders) {
        int MOD = 1_000_000_007;
        Arrays.sort(inventory);
        int curIndex = inventory.length - 1;
        int curValue = inventory[curIndex];
        long profit = 0;
        
        while (orders > 0) {
            while (curIndex >= 0 && inventory[curIndex] == curValue) {
                curIndex--;
            }
            int nextValue = curIndex < 0 ? 0 : inventory[curIndex];
            int numSameColor = inventory.length - 1 - curIndex;

            long nums = (long) (curValue - nextValue) * numSameColor;
            if (orders >= nums) {
                profit += (long)(curValue + nextValue + 1) * (curValue - nextValue) / 2 * numSameColor;
            } else {
                int numFullRow = orders / numSameColor;
                int remainder = orders % numSameColor;
                profit += (long)(curValue + curValue - numFullRow + 1) * numFullRow / 2 * numSameColor;
                profit += (long)(curValue - numFullRow) * remainder;
            }
            orders -= nums;
            profit = profit % MOD;
            curValue = nextValue;
        }
        return (int)profit;
    }
}