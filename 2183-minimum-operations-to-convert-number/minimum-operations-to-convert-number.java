class Solution {
    public int minimumOperations(int[] nums, int start, int goal) {
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);
        int ops = 0;

        while(!queue.isEmpty()) {
            int currSize = queue.size();

            while(currSize-- > 0) {
                int curr = queue.remove();
            
                for(int num : nums) {
                    int[] next = {curr + num , curr - num, curr ^ num};

                    for(int val : next) {
                        if(val == goal) return ops+1;
                        if(val > 1000 || val < 0) continue;
                        if(!visited.contains(val)) {
                            queue.add(val);
                            visited.add(val);
                        }
                    }
                }
            }
            ops++;
        }
        return -1;
    }
}
