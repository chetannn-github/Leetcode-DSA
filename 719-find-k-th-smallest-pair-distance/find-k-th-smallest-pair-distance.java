// class Solution {
//     public int smallestDistancePair(int[] arr, int k) {
//         PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
//             return b-a;
//         });
       
//         for(int i=0; i<arr.length-1; i++){
//             for(int j= i+1; j<arr.length; j++){
//                 int distance = Math.abs(arr[i]-arr[j]);
//                 pq.add(distance);
//                 if(pq.size()>k) pq.remove();
//             }
//         }

//         return pq.peek();
//     }
// }


class Solution {
    public int smallestDistancePair(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        int start = findMinConsecutiveDiff(arr), end = arr[n-1] - arr[0];
        int result = 0;

        while(start <= end) {
            int mid = start + ((end-start)>>1);
            int smallerCount = findSmallerCount(arr,mid);

            if(smallerCount >= k) {
                result = mid;
                end = mid-1;
            }else start = mid+1;
        }

        return result;
    }

    private int findSmallerCount(int[] arr, int target) {
        int count = 0;
        int n = arr.length;

        for(int i=0; i<n-1; i++) {
            int start = i+1, end = n-1;
            int result = i;

            while(start <= end) {
                int mid =  start + ((end-start)>>1);
                if(arr[mid] - arr[i] <= target) {
                    result = mid;
                    
                    start = mid+1;
                }else end = mid-1;
            }

            count += result - i;
        }

        return count;
    }

    private int findMinConsecutiveDiff(int[] arr) {
        int minDiff = Integer.MAX_VALUE;

        for(int i=0; i<arr.length-1; i++) {
            minDiff = Math.min(minDiff,arr[i+1]-arr[i]);
        }

        return minDiff;
    }
}
