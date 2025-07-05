// class Solution {
//     public long[] mostFrequentIDs(int[] nums, int[] freq) {
//         HashMap<Integer,Long> hm = new HashMap<>();

//         int n = nums.length;
//         long[] result = new long[n];

//         PriorityQueue<Integer> pq = new PriorityQueue<>(
//             (a,b)-> (hm.get(b) == hm.get(a) ? (b - a) : (int) (hm.get(b) - hm.get(a)))
//         );

//         for (int i = 0; i < n; i++) {
//             int currID = nums[i];
//             int currFreq = freq[i];

//             long totalFreq = hm.getOrDefault(currID, 0L) + currFreq;

//             if (hm.containsKey(currID)) {
//                 pq.remove(currID);
//             }

//             hm.put(currID, totalFreq);

//             if (totalFreq > 0) {
//                 pq.add(currID);
//             }

//             result[i] = pq.isEmpty() ?  0L : hm.get(pq.peek());
//         }

//         return result;
//     }
// }


class Solution {
    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        int n = nums.length;
        long[] result = new long[n];

        HashMap<Integer, Long> freqMap = new HashMap<>();

        
        PriorityQueue<long[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a[1] == b[1]) return (int) (b[0] - a[0]);
                return Long.compare(b[1], a[1]);
            }
        );

        for (int i = 0; i < n; i++) {
            int id = nums[i];
            int f = freq[i];

            long updatedFreq = (long) (freqMap.getOrDefault(id, 0L) + f);
            freqMap.put(id, updatedFreq);

            pq.add(new long[]{(long) id,  updatedFreq});

            
            while (!pq.isEmpty()) {
                long[] top = pq.peek();
                if (freqMap.get((int)top[0]) == (long) top[1]) {
                    break;
                }
                pq.remove(); 
            }

            result[i] = pq.isEmpty() ? 0 : (long) freqMap.get((int) pq.peek()[0]);
        }

        return result;
    }
}
