class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        for(int[] row : grid) {
            count += row.length - bs(row);
        }
        return count;
    }

    public int bs(int[] mat) {
        int s = 0, e = mat.length - 1;
        int ans = mat.length;

        while(s<=e) {
            int mid = s + ((e - s)>>1);

            if(mat[mid] >= 0) {
                s = mid +1;
            }else {
                ans = mid;
                e = mid - 1;
            }
        }
        return ans;
    }
}