// class Solution {
//     public int kthSmallest(int[][] matrix, int k) {
//         PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b-a));

//         for(int row[] : matrix){
//             for(int num : row){
//                 pq.add(num);
//                 if(pq.size()>k) pq.remove();
//             }
//         }
//         return pq.peek();
//     }
// }

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int start = matrix[0][0], end = matrix[n-1][n-1];
        int result = 0;

        while(start <= end) {
            int mid = start + ((end-start)>>1);
            int smallerCount = findSmallerCount(matrix,mid);

            if(smallerCount >= k) {
                result = mid;
                end = mid-1;
            }else start = mid+1;
        }

        return result;
    }

    private int findSmallerCount(int[][] matrix, int target) {
        int count = 0;
        int n = matrix.length;

        for(int i=0; i<n; i++) {
            int start = 0, end = n-1;
            int result = -1;

            while(start <= end) {
                int mid =  start + ((end-start)>>1);
                if(matrix[i][mid] <= target) {
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

class Pair {
    int count,val;
    Pair(int count,int val) {
        this.count = count;
        this.val = val;
    }
}