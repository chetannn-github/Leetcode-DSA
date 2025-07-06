// class Solution {
//     int MOD = 1_000_000_007;
//     public int rangeSum(int[] nums, int n, int left, int right) {
//         PriorityQueue<Long> pq = new PriorityQueue<>((a,b)-> (b-a > 0 ? 1 : -1));
//         for(int i=0; i<n; i++) {
//             long sum = 0;

//             for(int j = i; j< n; j++) {
//                 sum += nums[j];

//                 pq.add(sum);
//                 if(pq.size() > right) {
//                     pq.remove();
//                 }
//             }
//         }
//         long result = 0;
//         while(pq.size() >= left) {
//             result += (pq.remove());
//         }

//         return (int) (result  % MOD);
//     }
// }



class Solution {
    int MOD = 1_000_000_007;
    public int rangeSum(int[] nums, int n, int left, int right) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> (a.sum - b.sum > 0 ? 1 : -1));
        for(int i=0; i<n; i++) {
            pq.add(new Pair((long) nums[i], i));
        }
        int count = 1;
        long result = 0;

        while (count <= right) {
            long smallestSum = pq.peek().sum;
            int lastIdx = pq.remove().lastIdx;

            if(lastIdx  < n-1) {
                pq.add(new Pair((long)(smallestSum + nums[lastIdx+1]), lastIdx+1));
            }

            if(count >= left) {
                // System.out.println(smallestSum);
                result += smallestSum;
            }
            count++;
        }

        return (int) (result  % MOD);
    }
}


class Pair{
    long sum;
    int lastIdx ;
    Pair(long sum, int lastIdx) {
        this.sum = sum;
        this.lastIdx = lastIdx;
    }
}