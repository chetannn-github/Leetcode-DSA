class Solution {
    public int minDeletionSize(String[] strs) {
        int rows = strs.length;
        int cols = strs[0].length();
        int result = 0;
        HashSet<Integer> removed = new HashSet<>();
        for(int i=1; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(removed.contains(j)) {
                    continue;
                }
                char prev = strs[i-1].charAt(j);
                char curr = strs[i].charAt(j);

                if(curr < prev) {
                    removed.add(j);
                    result++;
                }
                
            }
        }

        return result;
    }
}