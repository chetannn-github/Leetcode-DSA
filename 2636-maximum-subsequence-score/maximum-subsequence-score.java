// class Solution {
//     public long maxScore(int[] nums1, int[] nums2, int k) {
//         long maximumScore = 0L;
//         int n = nums1.length;
//         HashSet<Integer> unwantedIndices = new HashSet<>();
//         PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(nums1[b] - nums1[a]));


//         for(int i=0; i<n; i++) {
//             pq.add(i);
//         }

//         List<Pair> list = new ArrayList<>();
//         for(int i=0; i<n; i++) {
//             list.add(new Pair(nums2[i], i));        
//         }



//         Collections.sort(list, (a,b)-> (a.val - b.val));
        
        
//         for(int i=0; i <= n-k; i++) {
//             int currMin = list.get(i).val;
//             int currMinIdx = list.get(i).idx;
//             int K = k;
//             List<Integer> toBeAdded = new ArrayList<>();
//             long currSum = 0;

//             while(!pq.isEmpty() && K-->0) {
//                 while(unwantedIndices.contains(pq.peek())) pq.remove();   
//                 currSum += nums1[pq.peek()];
//                 toBeAdded.add(pq.remove());
//             }

//             for(int j=0; j< toBeAdded.size(); j++) {
//                 int a = toBeAdded.get(j);
//                 if(currMinIdx != a) {
//                     pq.add(a);
//                 }
//             }


//             long currScore = (long) (currMin * currSum); 
//             maximumScore = Math.max(currScore, maximumScore);


//             unwantedIndices.add(currMinIdx);

//         }
        



//         return maximumScore;
//     }


// }

// class Pair{
//     int val, idx;
//     Pair(int val, int idx) {
//         this.val = val;
//         this.idx = idx;
//     }
// }



class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        long maximumScore = 0L;
        int n = nums1.length;
        HashSet<Integer> unwantedIndices = new HashSet<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(nums1[b] - nums1[a]));


        for(int i=0; i<n; i++) {
            pq.add(i);
        }

        List<Pair> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            list.add(new Pair(nums2[i], i));        
        }

        Collections.sort(list, (a,b)-> (a.val - b.val));
        long currSum = 0L;
        HashSet<Integer> currSumIndices = new HashSet<>();

        int K = k;
        while(!pq.isEmpty() && K-->0) {
            currSum += nums1[pq.peek()];
            currSumIndices.add(pq.remove());
        }

        int prevIdx = -1;
        HashSet<Integer> prevMinIndices = new HashSet<>();

        for(int i=0; i <= n-k; i++) {
            long currMin = (long) list.get(i).val;
            int currMinIdx = list.get(i).idx;

            if(prevIdx != -1 && currSumIndices.contains(prevIdx)) {
                currSum -= nums1[prevIdx];
                while(prevMinIndices.contains(pq.peek()) ) pq.remove();
                currSum += nums1[pq.peek()];
                currSumIndices.add(pq.remove());
            }   
            
            long currScore = (long) currMin * currSum; 
            maximumScore = Math.max(currScore, maximumScore);
            prevMinIndices.add(currMinIdx);


            prevIdx = currMinIdx;

        }
        



        return maximumScore;
    }


}

class Pair{
    int val, idx;
    Pair(int val, int idx) {
        this.val = val;
        this.idx = idx;
    }
}