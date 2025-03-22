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
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a,b)->(
            b.get(0)+b.get(1) - a.get(0)-a.get(1)
        ));
       
        for(int num1 : nums1){
            for(int num2 : nums2){
                // this line is importantt
                // k bhar loo uske baad hii check krege kii bhai jo mera sbse badaa hh kyaa alge wale bhii wese hii yaa usse bekaar mil rhee tohh nhi legee
                if(!pq.isEmpty() && pq.size() == k && pq.peek().get(0) + pq.peek().get(1) <= num1 + num2) {
                    break;
                }
                pq.add(Arrays.asList(num1, num2));
                if(pq.size()>k) pq.remove();

            }

        }

        List<List<Integer>> ans = new ArrayList<>();
        while(k--!=0){
            ans.add(pq.remove());
        }
        return ans;
    }
}