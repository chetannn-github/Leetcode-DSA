// class Solution {
//     public int[] maxSlidingWindow(int[] nums, int k) {
//         Deque<Integer> dq = new ArrayDeque<>();
//         int n = nums.length;
//         int currDequeElmIdx = 0;
//         for(int i=0; i<k; i++) {
//             dq.add(nums[i]);

//             while(dq.peek() < nums[i]) {
//                 dq.remove();
//                 currDequeElmIdx++;
//             }
//         }

//         int result[] = new int[n - k + 1];
//         result[0] = dq.peek();
//         int start = 1;

//         // System.out.println(dq.toString());

//         for(int i=k; i<n; i++) {
        
//             while(start > currDequeElmIdx) {
//                 dq.remove();
//                 currDequeElmIdx++;
//             }
//             dq.add(nums[i]);
//             while(dq.peek() < nums[i]) {
//                 dq.remove();
//                 currDequeElmIdx++;
//             }

//             result[start] = dq.peek();
//             start++;
            
//         }

//         return result;
//     }
// }



class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int n = nums.length;
        int[] result = new int[n - k + 1];

        for(int i = 0; i < n; i++) {
            // Remove indexes which are out of the window
            while(!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // Remove all smaller elements (from the back)
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            dq.offerLast(i); // store index

            // Add to result once the window is valid
            if(i >= k - 1) {
                result[i - k + 1] = nums[dq.peekFirst()];
            }
        }

        return result;
    }
}
