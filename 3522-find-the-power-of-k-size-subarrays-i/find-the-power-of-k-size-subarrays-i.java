class Solution {
    public int[] resultsArray(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int count = 0;

        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.removeFirst();
            }

            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.removeLast();
                
            }
            
            if(i > 0 && nums[i] > nums[i-1] && nums[i] - nums[i-1] == 1) count++;
            else count = 1;

            dq.addLast(i);

            if (i >= k - 1) {
                result[i - k + 1] = (dq.size() == 1 && count >= k)? nums[dq.peekFirst()] : -1;
            }
        }

        return result;
    }
}