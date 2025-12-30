// class Solution {
//     public int[] maxSlidingWindow(int[] nums, int k) {
//         Deque<Integer> dq = new ArrayDeque<>();
//         int n = nums.length;
//         int[] result = new int[n - k + 1];

//         for(int i = 0; i < n; i++) {
//             while(!dq.isEmpty() && dq.peekFirst() <= i - k) {
//                 dq.removeFirst();
//             }

//             while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
//                 dq.removeLast();
//             }

//             dq.addLast(i);

//             if(i >= k - 1) {
//                 result[i - k + 1] = nums[dq.peekFirst()];
//             }
//         }

//         return result;
//     }
// }


class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(nums[b]-nums[a]));
        int n = nums.length;
        int[] result = new int[n - k + 1];

        for(int i = 0; i < n; i++) {
            while(!pq.isEmpty() && pq.peek() <= i - k) {
                pq.remove();
            }
            pq.add(i);

            if(i >= k - 1) {
                result[i - k + 1] = nums[pq.peek()];
            }
        }

        return result;
    }
}

