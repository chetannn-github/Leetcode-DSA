// class Solution {
//     public int[] kthSmallestPrimeFraction(int[] arr, int k) {
//         PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
//             return (double) b[0]/b[1]- (double) a[0]/a[1] > 0.0 ? 1 : -1;
//         });
       
//         for(int i=0; i<arr.length-1; i++){
//             for(int j= i+1; j<arr.length; j++){
//                 pq.add(new int[]{arr[i],arr[j]});
//                 if(pq.size()>k) pq.remove();
//             }
//         }

//         return pq.peek();
//     }
// }

class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> (((long) arr[a[0]] * arr[b[1]] - (long) arr[b[0]] * arr[a[1]]) > 0 ? 1 : -1)
        );

        for(int j = 1; j<n; j++) pq.add(new int[]{0, j});

        while(--k > 0) {
            int[] curr = pq.poll();
            int i = curr[0], j = curr[1];

            
                pq.offer(new int[]{i + 1, j});
            
        }

        int[] res = pq.peek();
        return new int[]{arr[res[0]], arr[res[1]]};
    }
}
