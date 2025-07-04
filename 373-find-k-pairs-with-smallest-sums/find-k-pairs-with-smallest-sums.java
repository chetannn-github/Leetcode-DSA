// tle
// class Solution {
//     public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
//         PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a,b)->(
//             b.get(0)+b.get(1) - a.get(0)-a.get(1)
//         ));

//         for(int num1 : nums1){
//             for(int num2 : nums2){
//                 pq.add(Arrays.asList(num1, num2));
//                 if(pq.size()>k) pq.remove();

//             }
//         }

//         List<List<Integer>> ans = new ArrayList<>();
//         while(k--!=0){
//             ans.add(pq.remove());
//         }
//         return ans;
//     }
// }


class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->(
            nums1[b.firstArrayIdx]+nums2[b.secondArrayIdx] - (nums1[a.firstArrayIdx] + nums2[a.secondArrayIdx]))
        );
        
        for(int i=0; i<nums1.length; i++){
            for(int j=0; j<nums2.length; j++){
                // this line is importantt
                // k bhar loo uske baad hii check krege kii bhai jo mera sbse badaa hh kyaa alge wale bhii wese hii yaa usse bekaar mil rhee tohh nhi legee
                boolean isKSmallestPairsCompleted = (!pq.isEmpty() && pq.size() == k && nums1[pq.peek().firstArrayIdx] + nums2[pq.peek().secondArrayIdx] <= nums1[i] + nums2[j]) ;

                if(isKSmallestPairsCompleted) break;
                pq.add(new Pair(i,j));
                if(pq.size()>k) pq.remove();

            }

        }

        List<List<Integer>> result = new ArrayList<>();
        while(k-->0){
            result.add(List.of(nums1[pq.peek().firstArrayIdx], nums2[pq.remove().secondArrayIdx]));
        }
        return result;
    }
}


class Pair {
    int firstArrayIdx,secondArrayIdx;
    Pair(int firstArrayIdx,int secondArrayIdx) {
        this.firstArrayIdx = firstArrayIdx;
        this.secondArrayIdx = secondArrayIdx;
    }
}