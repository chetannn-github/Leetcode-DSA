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
    class Pair {
        int id;
        long freq;

        Pair(int id, long freq) {
            this.id = id;
            this.freq = freq;
        }
    }

    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        HashMap<Integer, Long> freqMap = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (b.freq == a.freq) return b.id - a.id;  
            return Long.compare(b.freq, a.freq);      
        });

        int n = nums.length;
        long[] result = new long[n];

        for (int i = 0; i < n; i++) {
            int id = nums[i];
            int change = freq[i];

            long updatedFreq = freqMap.getOrDefault(id, 0L) + change;
            freqMap.put(id, updatedFreq);

            pq.add(new Pair(id, updatedFreq));

            while (!pq.isEmpty()) {
                Pair top = pq.peek();
                if (freqMap.get(top.id) != top.freq) {
                    pq.poll(); 
                } else {
                    result[i] = top.freq;
                    break;
                }
            }
        }

        return result;
    }
}
