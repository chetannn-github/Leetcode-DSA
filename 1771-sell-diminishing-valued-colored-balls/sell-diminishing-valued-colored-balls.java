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
        int n =  inventory.length;
        int currIndex = n - 1;
        int currVal = inventory[currIndex];
        long profit = 0;
        
        while (orders > 0) {
            while (currIndex >= 0 && inventory[currIndex] == currVal) {
                currIndex--;
            }

            int nextVal = currIndex < 0 ? 0 : inventory[currIndex];

            long countOfSame = (long) (n-1 - currIndex) * (currVal  - nextVal) ;
        
            if(countOfSame <= orders) {
                profit += (long) (currVal + nextVal + 1) * (currVal - nextVal) / 2 * (n-1- currIndex);
            }else {
                int fullRows =  orders / (n-1- currIndex);
                int remainder = orders % (n-1- currIndex)  ;

                profit += (long)  (currVal + (currVal - fullRows + 1)) * (fullRows) /2 * (n-1- currIndex) ;

                profit += (long) (remainder) * (currVal - fullRows);
            }


            orders -= countOfSame;
            profit %= MOD;
            currVal = nextVal;
            
        }
        return (int)profit;
    }
}