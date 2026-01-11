// class Solution {
//     public int findKthNumber(int m, int n, int k) {
//         PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b-a));

//         for(int i=0; i<m; i++) {
//             for(int j=0; j<n; j++) {
//                 int num = (i+1) * (j+1);
//                 pq.add(num);
//                 if (pq.size()>k) pq.remove();
//             }
//         }
//         return pq.peek();
//     }
// }


class Solution {
    public int findKthNumber(int m, int n, int k) {
        int start = 1, end = m*n;
        int result = 0;

        while(start <= end) {
            int mid = start + ((end-start)>>1);
            int smallerCount = findSmallerCount(n,m,mid);

            if(smallerCount >= k) {
                result = mid;
                end = mid-1;
            }else start = mid+1;
        }

        return result;
    }

    private int findSmallerCount(int n, int m, int target) {
        int count = 0;

        for(int i=0; i<n; i++) {
            int start = 0, end = m-1;
            int result = -1;

            while(start <= end) {
                int mid =  start + ((end-start)>>1);
                if((i+1)*(mid+1) <= target) {
                    result = mid;
    
                    start = mid+1;
                }else end = mid-1;
            }

            count += result+1;
            if(result == -1) break;
        }

        return count;
    }
}

