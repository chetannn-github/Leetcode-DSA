class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int n = nums.length;
        int[] result = new int[n - k + 1];

        for(int i = 0; i < n; i++) {
            // Remove indexes which are out of the window
            while(!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.removeFirst();
            }

            // Remove all smaller elements (from the back)
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.removeLast();
            }

            dq.addLast(i); // store index

            // Add to result once the window is valid
            if(i >= k - 1) {
                result[i - k + 1] = nums[dq.peekFirst()];
            }
        }

        return result;
    }
}
